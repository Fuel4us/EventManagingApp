package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContactDTO implements Serializable {

    private String contactName;
    private String contactEmail;

    /**
     *
     * @param contactName must be non-null
     * @param contactEmail
     * @throws IllegalArgumentException
     */
    public ContactDTO(String contactName, String contactEmail) throws IllegalArgumentException {
        if (contactName == null) {
            throw new IllegalArgumentException("Name of Contact is Null");
        }
        this.contactName = contactName;

        if (contactEmail == null) {
            this.contactEmail = "";
        } else {
            this.contactEmail = contactEmail;
        }
    }

    /**
     * for persistence purposes
     */
    public ContactDTO() {
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }
    
    
}
