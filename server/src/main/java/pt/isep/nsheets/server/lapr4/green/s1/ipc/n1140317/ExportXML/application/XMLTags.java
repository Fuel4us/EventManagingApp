package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;


/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public enum XMLTags {
    
    /**
     * Workbook level element, with its default representation
     */
    WORKBOOK("workbook"),
    /**
     * Spreadsheet level element, with its default representation
     */
    SPREADSHEET("spreadsheet"),
    /**
     * Cell level element, with its default representation
     */
    CELL("cell");

    private final String str;

    /**
     * Returns the default representation for this XML element
     *
     * @return Default element name
     */
    public String getDesc() {
        return str;
    }

    XMLTags(String str) {
        this.str = str;
    }
    
}