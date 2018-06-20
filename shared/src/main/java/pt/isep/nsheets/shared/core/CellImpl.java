/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package pt.isep.nsheets.shared.core;

//import java.io.ObjectInputStream;		// not supported in GWT
//import java.io.ObjectOutputStream;		// not supported in GWT
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.velocity.runtime.directive.Macro;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Formula;
import pt.isep.nsheets.shared.core.formula.Reference;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompiler;
import pt.isep.nsheets.shared.core.formula.compiler.MacroExpressionCompiler;
import pt.isep.nsheets.shared.core.formula.util.ReferenceTransposer;
import pt.isep.nsheets.shared.ext.CellExtension;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.ExtensionManager;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The implementation of the <code>Cell</code> interface.
 *
 * @author Einar Pehrson
 */
@Entity
public class CellImpl implements Cell, Serializable {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 926673794084390673L;

    /**
     * The spreadsheet to which the cell belongs
     */
    @Transient
    private Spreadsheet spreadsheet;

    /**
     * The address of the cell
     */
    @OneToOne
    private Address address;

    /**
     * The value of the cell
     */
    @Embedded
    private Value value = new Value();

    /**
     * The content of the cell
     */
    private String content = "";

    /**
     * The cell's formula
     */
    @Transient
    private Formula formula;

    /**
     * The cell's precedents
     */
    @ManyToMany(targetEntity = CellImpl.class)
    private Set<Cell> precedents = new TreeSet<Cell>();

    /**
     * The cell's dependents
     */
    @ManyToMany(targetEntity = CellImpl.class)
    private Set<Cell> dependents = new TreeSet<Cell>();

    /**
     * The cell listeners that have been registered on the cell
     */
    private transient List<CellListener> listeners
            = new ArrayList<CellListener>();

    /**
     * The cell extensions that have been instantiated
     */
    private transient Map<String, CellExtension> extensions
            = new HashMap<String, CellExtension>();

    @Transient
    private List<ChartDTO> chartList = new ArrayList<>();

    private Set<TemporaryVariable> tempVariableList = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    public CellImpl() {
    }

    /**
     * Creates a new cell at the given address in the given spreadsheet. (not
     * intended to be used directly).
     *
     * @see Spreadsheet#getCell(Address)
     * @param spreadsheet the spreadsheet
     * @param address the address of the cell
     */
    CellImpl(Spreadsheet spreadsheet, Address address) {
        this.spreadsheet = spreadsheet;
        this.address = address;
    }

    /**
     * Creates a new cell at the given address in the given spreadsheet,
     * initialized with the given content (not intended to be used directly).
     *
     * @see Spreadsheet#getCell(Address)
     * @param spreadsheet the spreadsheet
     * @param address the address of the cell
     * @param content the content of the cell
     * @throws FormulaCompilationException if an incorrectly formatted formula
     * was entered
     */
    public CellImpl(Spreadsheet spreadsheet, Address address, String content) throws FormulaCompilationException {
        this(spreadsheet, address);
        storeContent(content);
        reevaluate();
    }

    public CellImpl(Address address, String content, SortedSet<Cell> precedents, SortedSet<Cell> dependents) {
        this.address = address;
        this.content = content;
        this.precedents = precedents;
        this.dependents = dependents;
    }

    /*
 * LOCATION
     */
    @Override
    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    /*
 * VALUE
     */
    public Value getValue() {
        return value;
    }

    /**
     * Updates the cell's value, and fires an event if it changed.
     */
    private void reevaluate() {
        Value oldValue = value;

        // Fetches the new value
        Value newValue;
        if (formula != null) {
            try {
                newValue = formula.evaluate();
            } catch (IllegalValueTypeException e) {
                newValue = new Value(e);
            }
        } else {
            newValue = Value.parseValue(content);
        }

        // Stores value
        value = newValue;

        // Checks for change
        if (!newValue.equals(oldValue)) {
            fireValueChanged();
        }
    }

    /**
     * Notifies all registered listeners that the value of the cell changed.
     */
    private void fireValueChanged() {
        for (CellListener listener : listeners) {
            listener.valueChanged(this);
        }
        for (CellExtension extension : extensions.values()) {
            extension.valueChanged(this);
        }

        // Notifies dependents of the changed value
        for (Cell dependent : dependents) {
            if (dependent instanceof CellImpl) {
                ((CellImpl) dependent).reevaluate();
            }
        }
    }

    /*
 * CONTENT
     */
    public String getContent() {
        return content;
    }

    public Formula getFormula() {
        return formula;
    }

    public void clear() {
        try {
            setContent("");
        } catch (FormulaCompilationException e) {
        }
        fireCellCleared();
    }

    public void setContentByMacro(String content) throws FormulaCompilationException {
        MacroExpressionCompiler compiler = new MacroExpressionCompiler();
        if (!this.content.equals(content)) {
            Formula formula = null;
            if (content.length() > 1) {
                formula = compiler.compile(this, content);
            }
            this.content = content;
            this.formula = formula;
            updateDependencies();
            fireContentChanged();
            reevaluate();
        }
    }

    public void setContent(String content) throws FormulaCompilationException {
        if (!this.content.equals(content)) {
            storeContent(content);
            fireContentChanged();
            reevaluate();
        }
    }

    /**
     * Updates the cell's content, and registers dependencies.
     *
     * @param content the content to store
     * @throws FormulaCompilationException if an incorrectly formatted formula
     * was entered
     */
    private void storeContent(String content) throws FormulaCompilationException {
        // Parses formula
        Formula formula = null;
        if (content.length() > 1) {
            formula = FormulaCompiler.getInstance().compile(this, content);
        }

        // Stores content and formula
        this.content = content;
        this.formula = formula;
        updateDependencies();
    }

    /**
     * Updates the cell's dependencies.
     */
    private void updateDependencies() {
        // Deregisters as dependent with each old precedent
        for (Cell precedent : precedents) {
            ((CellImpl) precedent).removeDependent(this);
        }
        precedents.clear();

        if (formula != null) // Registers as dependent with each new precedent
        {
            for (Reference reference : formula.getReferences()) {
                for (Cell precedent : reference.getCells()) {
                    if (!this.equals(precedent)) {
                        precedents.add(precedent);
                        ((CellImpl) precedent).addDependent(this);
                    }
                }
            }
        }
    }

    /**
     * Notifies all registered listeners that the content of the cell changed.
     */
    private void fireContentChanged() {
        for (CellListener listener : listeners) {
            listener.contentChanged(this);
        }
        for (CellExtension extension : extensions.values()) {
            extension.contentChanged(this);
        }
    }

    /**
     * Notifies all registered listeners that the cell was cleared.
     */
    private void fireCellCleared() {
        for (CellListener listener : listeners) {
            listener.cellCleared(this);
        }
        for (CellExtension extension : extensions.values()) {
            extension.cellCleared(this);
        }
    }

    /*
 * DEPENDENCIES
     */
    public SortedSet<Cell> getPrecedents() {
        return new TreeSet<Cell>(precedents);
    }

    public SortedSet<Cell> getDependents() {
        return new TreeSet<Cell>(dependents);
    }

    /**
     * Adds the given cell as a dependent of this cell, to be notified when its
     * value changes.
     *
     * @param cell the dependent to add
     */
    private void addDependent(Cell cell) {
        dependents.add(cell);
        fireDependentsChanged();
    }

    /**
     * Removes the given cell as a dependent of this cell.
     *
     * @param cell the dependent to remove
     */
    private void removeDependent(Cell cell) {
        dependents.remove(cell);
        fireDependentsChanged();
    }

    /**
     * Notifies all registered listeners that the content of the cell changed.
     */
    private void fireDependentsChanged() {
        for (CellListener listener : listeners) {
            listener.dependentsChanged(this);
        }
        for (CellExtension extension : extensions.values()) {
            extension.dependentsChanged(this);
        }
    }

    /*
 * CLIPBOARD
     */
    public void copyFrom(Cell source) {
        // Copies content
        if (source.getFormula() == null) {
            try {
                setContent(source.getContent());
            } catch (FormulaCompilationException e) {
            }
        } else {
            // Copies and transposes formula
            this.formula = new Formula(this,
                    new ReferenceTransposer(
                            getAddress().getColumn() - source.getAddress().getColumn(),
                            getAddress().getRow() - source.getAddress().getRow()
                    ).getExpression(source.getFormula().getExpression())
            );
            this.content = source.getContent().charAt(0) + formula.toString();
            updateDependencies();
            fireContentChanged();
            reevaluate();
        }
        fireCellCopied(source);
    }

    public void moveFrom(Cell source) {
        // Change the address of the source cell
        // Remove the target cell from the spreadsheet
        // Flag the target cell as overwritten!

        // fireCellCopied(source);
    }

    /**
     * Notifies all registered listeners that the cell was copied (or moved).
     *
     * @param source the cell from which data was copied
     */
    private void fireCellCopied(Cell source) {
        for (CellListener listener : listeners) {
            listener.cellCopied(this, source);
        }
        for (CellExtension extension : extensions.values()) {
            extension.cellCopied(this, source);
        }
    }

    /*
 * EVENT HANDLING
     */
    public void addCellListener(CellListener listener) {
        listeners.add(listener);
    }

    public void removeCellListener(CellListener listener) {
        listeners.remove(listener);
    }

    public CellListener[] getCellListeners() {
        return listeners.toArray(new CellListener[listeners.size()]);
    }

    /*
 * EXTENSIONS
     */
    public Cell getExtension(String name) {
        // Looks for an existing cell extension
        CellExtension extension = extensions.get(name);
        if (extension == null) {
            // Creates a new cell extension
            Extension x = ExtensionManager.getInstance().getExtension(name);
            if (x != null) {
                extension = x.extend(this);
                if (extension != null) {
                    extensions.put(name, extension);
                }
            }
        }
        return extension;
    }

    /*
 * GENERAL
     */
    /**
     * Compares this cell with the specified cell for order, by comparing their
     * addresses.
     *
     * @param cell the cell to be compared
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    public int compareTo(Cell cell) {
        if (spreadsheet != cell.getSpreadsheet()) {
            return -1;
        } else {
            return address.compareTo(cell.getAddress());
        }
    }

    /**
     * Returns a string representation of the cell.
     *
     * @return the cell's content
     */
    public String toString() {
        return address.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean hasChart() {
        return this.chartList.size() > 0;
    }

    @Override
    public boolean hasTemporaryVariable() {
        return this.tempVariableList.size() > 0;
    }

    @Override
    public List<ChartDTO> chartList() {
        return this.chartList;
    }

    @Override
    public boolean addChart(ChartDTO chart) {
        return this.chartList.add(chart);
    }

    public CellDTO toDTO() {
        SortedSet<CellDTO> precedentsDTO = new TreeSet<>();
        SortedSet<CellDTO> dependentsDTO = new TreeSet<>();

        for (Cell p : this.precedents) {
            precedentsDTO.add(p.toDTO());
        }

        for (Cell d : this.dependents) {
            dependentsDTO.add(d.toDTO());
        }

        return new CellDTO(address.toDTO(), content, value, precedentsDTO, dependentsDTO);
    }

    public static Cell fromDTO(CellDTO dto) {
        SortedSet<Cell> precedentsCell = new TreeSet<>();
        SortedSet<Cell> dependentsCell = new TreeSet<>();

        for (CellDTO p : dto.precedents) {
            precedentsCell.add(CellImpl.fromDTO(p));
        }

        for (CellDTO d : dto.dependents) {
            dependentsCell.add(CellImpl.fromDTO(d));
        }

        return new CellImpl(Address.fromDTO(dto.address), dto.content, precedentsCell, dependentsCell);
    }

    @Override
    public List<TemporaryVariable> tempVariableList() {
        return tempVariableList();
    }

    @Override
    public boolean addTempVariable(TemporaryVariable tempVariable) {
        for (TemporaryVariable temporaryVariable : tempVariableList) {
            if (tempVariable.equals(temporaryVariable)) {
                return false;
            }
        }
        return tempVariableList.add(tempVariable);
    }

//    @Override
//    public boolean hasChart() {
//        return chartList.size() >0;
//    }
//
//    @Override
//    public List<ChartDTO> chartList() {
//        return chartList;
//    }
//
//    @Override
//    public boolean addChart(ChartDTO chart) {
//        return chartList.add(chart);
//    }
    /**
     * Customizes deserialization by recreating the listener list and by
     * catching exceptions when extensions are not found.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    // not supported in gwt
//	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//		stream.defaultReadObject();
//		listeners = new ArrayList<CellListener>();
//
//		// Reads extensions
//		extensions = new HashMap<String, CellExtension>();
//		int extCount = stream.readInt();
//		for (int i = 0; i < extCount; i++) {
//			try {
//				CellExtension extension = (CellExtension)stream.readObject();
//				extensions.put(extension.getName(), extension);
//			} catch (ClassNotFoundException e) {}
//		}
//	}
    /**
     * Customizes serialization by writing extensions separately.
     *
     * @param stream the object output stream to which the object is to be
     * written
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     */
    // not supported in gwt
//	private void writeObject(ObjectOutputStream stream) throws IOException {
//		stream.defaultWriteObject();
//
//		// Writes extensions
//		stream.writeInt(extensions.size());
//		for (CellExtension extension : extensions.values())
//			stream.writeObject(extension);
//	}
}
