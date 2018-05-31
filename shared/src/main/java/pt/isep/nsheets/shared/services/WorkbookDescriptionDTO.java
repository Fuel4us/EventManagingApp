package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WorkbookDescriptionDTO implements Serializable {
	
	private String name;
	private String description;
        private WorkbookDTO workbook;
	
	public WorkbookDescriptionDTO(String name, String description) {
		this.name=name;
		this.description=description;
                this.workbook = new WorkbookDTO();
	}

	// It is mandatory to have a default constructor with no arguments to be serializable!
	public WorkbookDescriptionDTO() {
		this.name="";
		this.description="";
	}
	
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
        
        public WorkbookDTO getWorkbook(){
            return this.workbook;
        }
}
