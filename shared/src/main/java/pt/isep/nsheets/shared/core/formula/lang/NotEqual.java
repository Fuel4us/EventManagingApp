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
package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.Value;

/**
 * A relational not-equal operator.
 * @author Einar Pehrson
 */
public class NotEqual extends RelationalOperator {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 520258360283536310L;

	/**
	 * Creates a new relational not-equal operator.
	 */
	public NotEqual() {}

	public <T> boolean compare(Comparable<T> left, T right) {
		return left.compareTo(right) != 0;
	}

	public String getIdentifier() {
		return "<>";
	}

	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	public String toString() {
		return getIdentifier();
	}
}