package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pedro Marques Vieira
 */
@SuppressWarnings("serial")
public class PrivateChatDTO implements Serializable {
    
    private List<String> listEmails;

    public PrivateChatDTO(List<String> listUser) {
        this.listEmails = listUser;
    }
    
    // It is mandatory to have a default constructor with no arguments to be serializable!
    public PrivateChatDTO() {
    }

    public List<String> getListEmails() {
        return listEmails;
    }
    
    public void addEmail(String email) {
        listEmails.add(email);
    }
    
}
