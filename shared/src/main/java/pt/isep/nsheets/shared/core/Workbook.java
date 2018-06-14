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

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang.GlobalVariable;

/**
 * A workbook which can contain several spreadsheets.
 *
 * @author Einar Pehrson
 */
@Entity
public class Workbook implements Iterable<Spreadsheet>, Serializable {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = -6324252462576447242L;

    private String name;
    private String description;
    private boolean publicState;

    /**
     * The spreadsheets of which the workbook consists
     */
    @OneToMany(
            mappedBy = "workbook",
            cascade = CascadeType.ALL,
            targetEntity = SpreadsheetImpl.class
    )
    private List<Spreadsheet> spreadsheets = new ArrayList<Spreadsheet>();

    /**
     * The cell listeners that have been registered on the cell
     */
    private transient List<WorkbookListener> listeners
            = new ArrayList<WorkbookListener>();

    /**
     * The number of spreadsheets that have been created in the workbook
     */
    private int createdSpreadsheets = 0;

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Value is the name and global variable is the actual number value of the
     * variable
     */
    private List<GlobalVariable> globalVariables;

    /**
     * Creates a new empty workbook.
     */
    public Workbook() {
    }

    /**
     * Creates a new workbook, which initially contains the given number of
     * blank spreadsheets.
     *
     * @param sheets the number of sheets to create initially
     */
    public Workbook(String name, String description, boolean publicState, int sheets) {
        this.name = name;
        this.description = description;
        this.publicState = publicState;

        for (int i = 0; i < sheets; i++) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle()));
        }

        this.globalVariables = new ArrayList<GlobalVariable>();
    }
    

    public Workbook(String name, String description, List<Spreadsheet> spreadsheets) {
        this.name = name;
        this.description = description;
        this.spreadsheets = spreadsheets;
        this.globalVariables = new ArrayList<GlobalVariable>();
    }
    
    public Workbook(String name, String description, boolean publicState, List<Spreadsheet> spreadsheets) {
        this.name = name;
        this.description = description;
        this.spreadsheets = spreadsheets;
        this.publicState = publicState;
        this.globalVariables = new ArrayList<GlobalVariable>();
    }


    /**
     * Creates a new workbook, using the given content matrix to create
     * spreadsheets initially.
     *
     * @param contents the content matrices to use when creating spreadsheets
     */
    public Workbook(String name, String description, String[][]... contents) {
        this.name = name;
        this.description = description;

        for (String[][] content : contents) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle(), content));
        }

        this.globalVariables = new ArrayList<GlobalVariable>();
    }

    public Workbook(String name, String description, boolean publicState, String[][]... contents) {
        this.name = name;
        this.description = description;
        this.publicState = publicState;

        for (String[][] content : contents) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle(), content));
        }

        this.globalVariables = new ArrayList<GlobalVariable>();
    }

    /**
     * Adds a blank spreadsheet to the end of the workbook.
     */
    public void addSpreadsheet() {
        Spreadsheet spreadsheet = new SpreadsheetImpl(this,
                getNextSpreadsheetTitle());
        spreadsheets.add(spreadsheet);
        fireSpreadsheetInserted(spreadsheet, spreadsheets.size() - 1);
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a new spreadsheet to the workbook, in which cells are initialized
     * with data from the given content matrix.
     *
     * @param content the contents of the cells in the spreadsheet
     */
    public void addSpreadsheet(String[][] content) {
        Spreadsheet spreadsheet = new SpreadsheetImpl(this,
                getNextSpreadsheetTitle(), content);
        spreadsheets.add(spreadsheet);
        fireSpreadsheetInserted(spreadsheet, spreadsheets.size() - 1);
    }

    /**
     * Returns the title to be used for the next spreadsheet added.
     *
     * @return the title to be used for the next spreadsheet added
     */
    private String getNextSpreadsheetTitle() {
        return SpreadsheetImpl.BASE_TITLE + " " + (createdSpreadsheets++ + 1);
    }

    /**
     * Adds a new blank spreadsheet to the workbook.
     *
     * @param spreadsheet spreadsheet
     */
    public void removeSpreadsheet(Spreadsheet spreadsheet) {
        spreadsheets.remove(spreadsheet);
        // Remove references to the spreadsheet in remaining spreadsheets!
        fireSpreadsheetRemoved(spreadsheet);
    }

    /**
     * Returns the spreadsheet at the given index.
     *
     * @param index the index of the spreadsheet in the workbook
     * @return the spreadsheet at the given index
     * @throws IndexOutOfBoundsException if the index is out of range (index
     * less than 0 or index greater or equal |spreadsheets|)
     */
    public Spreadsheet getSpreadsheet(int index) throws IndexOutOfBoundsException {
        return spreadsheets.get(index);
    }

    /**
     * Returns the number of spreadsheets in the the workbook.
     *
     * @return the number of spreadsheets in the the workbook
     */
    public int getSpreadsheetCount() {
        return spreadsheets.size();
    }

    /**
     * Returns an iterator over the spreadsheets in the workbook.
     *
     * @return an iterator over the spreadsheets in the workbook
     */
    public Iterator<Spreadsheet> iterator() {
        return spreadsheets.iterator();
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public void setPublicState(boolean publicState) {
        this.publicState = publicState;
    }

    /*
 * EVENT HANDLING
     */
    /**
     * Registers the given listener on the workbook.
     *
     * @param listener the listener to be added
     */
    public void addWorkbookListener(WorkbookListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes the given listener from the workbook.
     *
     * @param listener the listener to be removed
     */
    public void removeWorkbookListener(WorkbookListener listener) {
        listeners.remove(listener);
    }

    /**
     * Returns the listeners that have been registered on the workbook.
     *
     * @return the listeners that have been registered on the workbook
     */
    public WorkbookListener[] getWorkbookListeners() {
        return listeners.toArray(new WorkbookListener[listeners.size()]);
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been inserted.
     *
     * @param spreadsheet the spreadsheet that was inserted
     * @param index the index at which the spreadsheet was inserted
     */
    private void fireSpreadsheetInserted(Spreadsheet spreadsheet, int index) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetInserted(spreadsheet, index);
        }
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been removed.
     *
     * @param spreadsheet the spreadsheet that was removed
     */
    private void fireSpreadsheetRemoved(Spreadsheet spreadsheet) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetRemoved(spreadsheet);
        }
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been renamed.
     *
     * @param spreadsheet the spreadsheet that was renamed
     */
    @SuppressWarnings("unused")
    private void fireSpreadsheetRenamed(Spreadsheet spreadsheet) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetRenamed(spreadsheet);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkbookDTO toDTO() {
        List<SpreadsheetDTO> spreadsheetDTOS = new ArrayList<>();
        for (Spreadsheet ss : this.spreadsheets) {
            spreadsheetDTOS.add(ss.toDTO());
        }
        return new WorkbookDTO(this.name, this.description, this.publicState, spreadsheetDTOS);
    }

    public static Workbook fromDTO(WorkbookDTO dto) {
        if (dto.spreadsheets.isEmpty()) {
            return new Workbook(dto.name, dto.description, dto.publicState, dto.createdSpreadsheets);
        } else {
            List<Spreadsheet> spreadsheet = new ArrayList<>();

            for (SpreadsheetDTO ss : dto.spreadsheets) {
                spreadsheet.add(SpreadsheetImpl.fromDTO(ss, ss.columns, ss.rows));
            }

            return new Workbook(dto.name, dto.description,  dto.publicState, spreadsheet);
        }
    }

    public boolean checkIfGVExists(String gvName) {
        for (GlobalVariable tempGV : this.globalVariables) {
            if (tempGV.getGvName().equals(gvName)) {
                return true;
            }
        }

        return false;

        //return globalVariables.containsKey(gvName);
    }

    public GlobalVariable getGlobalVariable(String gvName) {
        for (GlobalVariable tempGV : this.globalVariables) {
            if (tempGV.getGvName().equals(gvName)) {
                return tempGV;
            }
        }

        return null;

        //return globalVariables.
    }

    public void setGVValue(String gvName, Value gvValue) {
        for (GlobalVariable tempGV : this.globalVariables) {
            if (tempGV.getGvName().equals(gvName)) {
                tempGV.setValue(gvValue);
            }
        }
    }

    public void addGlobalVariable(String gvName) {
        if (!checkIfGVExists(gvName)) {
            this.globalVariables.add(new GlobalVariable(new Value(), gvName));
        }
    }
    
    public List<GlobalVariable> globalVariables(){
        return this.globalVariables;
    }
    /*
 * GENERAL
     */

    /**
     * Customizes deserialization by recreating the listener list.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    // java.io.ObjectInputStream not supportted in GWT !
//	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//		stream.defaultReadObject();
//		listeners = new ArrayList<WorkbookListener>();
//	}
}
