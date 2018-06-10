package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContactDTO implements Serializable {

    private UserDTO contact;
    private UserDTO contactOwner;
    private boolean waitingAcceptance;
    private boolean accepted;

    /**
     *
     * @param contact
     * @param contactOwner
     * @param waitingAcceptance
     * @param accepted
     * @param blacklist
     * @throws IllegalArgumentException
     */
    public ContactDTO(UserDTO contact, UserDTO contactOwner, boolean waitingAcceptance, boolean accepted) throws IllegalArgumentException {
        if (contact == null) {
            throw new IllegalArgumentException("Name of Contact is Null");
        }
        this.contact = contact;

        this.contactOwner = contactOwner;
        this.waitingAcceptance = waitingAcceptance;
        this.accepted = accepted;
    }

    /**
     * for persistence purposes
     */
    public ContactDTO() {
    }

    public UserDTO getContact() {
        return contact;
    }

    public UserDTO getContactOwner() {
        return contactOwner;
    }

    public boolean isWaitingAcceptance() {
        return waitingAcceptance;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
