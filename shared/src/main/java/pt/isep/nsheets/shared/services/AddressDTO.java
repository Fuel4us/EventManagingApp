package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.Address;

/**
 *
 * @author TiagoRios(1161292)
 */
@SuppressWarnings("serial")
public class AddressDTO {
    
	public static final char LOWEST_CHAR = 'A';
	public static final char HIGHEST_CHAR = 'Z';

	private int column;
	private int row;
        
    public AddressDTO(int column, int row){
        this.column = column;
        this.row = row;
    }

    public Address fromDTO(){
        return new Address(this.column, this.row);
    }
}
