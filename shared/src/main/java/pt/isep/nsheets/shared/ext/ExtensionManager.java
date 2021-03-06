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
package pt.isep.nsheets.shared.ext;


import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions.CellStyleExtension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.ConditionalFormattingExtension;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.ValueColorExtension;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * The class that manages extensions to the CleanSheets application.
 * @author Einar Pehrson
 */
public class ExtensionManager {

	/** The singleton instance */
	private static final ExtensionManager instance = new ExtensionManager();

	/** The extensions that have been loaded */
	private SortedMap<String, Extension> extensionMap
		= new TreeMap<String, Extension>();

	/**
	 * Creates the extensions manager.
	 */
	private ExtensionManager() {
		instantiateExtensions();
	}

	/**
	 * Returns the singleton instance.
	 * @return the singleton instance
	 */
	public static ExtensionManager getInstance() {
		return instance;
	}

	/**
	 * Returns the extensions that have been loaded.
	 * @return the extensions that have been loaded
	 */
	public Extension[] getExtensions() {
		Collection<Extension> extensions = extensionMap.values();
		return extensions.toArray(new Extension[extensions.size()]);
	}

	/**
	 * Returns the extensions with the given name.
         * @param name name
	 * @return the extensions with the given name or null if none was found
	 */
	public Extension getExtension(String name) {
		return extensionMap.get(name);
	}

	private void instantiateExtensions(){
		//instantiate extensions here like
		//Extension extensions=new ActualExtension();
		// extensionMap.put(extensions.getName(), extensions);
		Extension extension = new ValueColorExtension("Value Colour Extension");
		Extension extension2 = new ConditionalFormattingExtension("ConditionalFormatting");
		Extension extension3 = new CellStyleExtension("CellStyleExtension");
		extensionMap.put(extension.getName(), extension);
		extensionMap.put(extension2.getName(), extension2);
		extensionMap.put(extension3.getName(), extension3);
	}

}