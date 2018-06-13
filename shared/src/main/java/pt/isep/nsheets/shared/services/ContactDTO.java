package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContactDTO implements Serializable {

    private String contactEmail;
    private String contactOwnerEmail;
    private boolean waitingAcceptance;
    private boolean accepted;

    /**
     *
     * @param contactEmail
     * @param contactOwnerEmail
     * @param waitingAcceptance
     * @param accepted
     * @throws IllegalArgumentException
     */
    public ContactDTO(String contactEmail, String contactOwnerEmail, boolean waitingAcceptance, boolean accepted) throws IllegalArgumentException {
        if (contactEmail == null || contactOwnerEmail == null) {
            throw new IllegalArgumentException("Name of Contact is Null");
        }
        this.contactEmail = contactEmail;

        this.contactOwnerEmail = contactOwnerEmail;
        this.waitingAcceptance = waitingAcceptance;
        this.accepted = accepted;
    }

    /**
     * for persistence purposes
     */
    public ContactDTO() {
    }

    public String getContact() {
        return contactEmail;
    }

    public String getContactOwner() {
        return contactOwnerEmail;
    }

    public boolean isWaitingAcceptance() {
        return waitingAcceptance;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
