package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class AddressDTO implements IsSerializable {
    
    public int column;
    public int row;
    public String location;
    
    protected AddressDTO() {}
    
    public AddressDTO(int column, int row, String location){
        this.column = column;
        this.row = row;
        this.location = location;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AddressDTO)) {
            return false;
        }
        
        AddressDTO dto = (AddressDTO) o;
        
        return column == dto.column && row == dto.row;
    }
}
