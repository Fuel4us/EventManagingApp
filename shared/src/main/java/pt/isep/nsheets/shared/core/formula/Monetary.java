/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula;

import java.util.SortedSet;
import java.util.TreeSet;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.util.CircularReferenceException;
import pt.isep.nsheets.shared.core.formula.util.CircularReferenceFinder;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitorException;
import pt.isep.nsheets.shared.core.formula.util.ReferenceFetcher;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class Monetary implements Expression {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 7127589370042533160L;

    /**
     * The cell to which the formula belongs
     */
    private Cell cell;

    /**
     * The expression of the formula
     */
    private Expression expression;

    /**
     * Returns the references in the expression
     */
    private SortedSet<Reference> references;

    /**
     * Creates a new formula.
     *
     * @param cell the cell to which the formula belongs
     * @param expression the expression in the formula
     */
    public Monetary(Cell cell, Expression expression) {
        // Stores members
        this.cell = cell;
        this.expression = expression;
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        if (!hasCircularReference()) {
            return expression.evaluate();
        } else {
            return new Value(new CircularReferenceException(this));
        }
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return expression.accept(visitor);
    }

    /**
     * Returns the cell to which the formula belongs.
     *
     * @return the cell to which the formula belongs
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Returns the expression in the formula.
     *
     * @return the expression in the formula
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Returns the references in the expression.
     *
     * @return the references in the expression
     */
    public SortedSet<Reference> getReferences() {
        if (references == null) {
            references = new ReferenceFetcher().getReferences(expression);
        }
        return new TreeSet<Reference>(references);
    }

    /**
     * Checks if the given formula has any circular references.
     *
     * @return return
     * @throws CircularReferenceException if the formula contains any circular
     * references
     */
    public boolean hasCircularReference() {
        try {
            new CircularReferenceFinder().check(this);
        } catch (ExpressionVisitorException e) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the formula.
     *
     * @return a string representation of the formula
     */
    @Override
    public String toString() {
        return expression.toString();
    }

}