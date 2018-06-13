package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import eapli.framework.domain.AggregateRoot;
import java.util.Objects;
import pt.isep.nsheets.shared.services.ContactDTO;

@Entity
public class Contact implements AggregateRoot<Long>, Serializable {
    // ORM primary key

    @Id
    @GeneratedValue
    private Long id = null;
    private String contactEmail;
    private String contactOwnerEmail;
    private boolean waitingAcceptance;
    private boolean accepted;

    /**
     *
     * @param contact
     * @param contactOwner
     * @throws IllegalArgumentException
     */
    public Contact(String contact, String contactOwner) throws IllegalArgumentException {
        if (contact == null) {
            throw new IllegalArgumentException("Contact is Null");
        }
        this.contactEmail = contact;

        this.contactOwnerEmail = contactOwner;
        this.waitingAcceptance = true;
        this.accepted = false;

    }

    public Contact(String contact, String contactOwner, boolean waitingAcception, boolean accepted) throws IllegalArgumentException {
        if (contact == null) {
            throw new IllegalArgumentException("Contact is Null");
        }
        this.contactEmail = contact;

        this.contactOwnerEmail = contactOwner;
        this.waitingAcceptance = waitingAcception;
        this.accepted = accepted;

    }

    /**
     * for persistence purposes only
     */
    protected Contact() {
    }

    @Override
    public Long id() {
        return this.id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactOwnerEmail() {
        return contactOwnerEmail;
    }

    public boolean isWaitingAcception() {
        return waitingAcceptance;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void accept() {
        accepted = true;
        waitingAcceptance = false;
    }

    public void deny() {
        accepted = false;
        waitingAcceptance = false;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Contact)) {
            return false;
        }

        final Contact that = (Contact) other;
        if (this == that) {
            return true;
        }
        if (!this.contactEmail.equals(that.contactEmail)) {
            return false;
        }

        if (!this.contactOwnerEmail.equals(that.contactOwnerEmail)) {
            return false;
        }

        if (this.accepted != that.accepted) {
            return false;
        }

        if (this.waitingAcceptance != that.waitingAcceptance) {
            return false;
        }

        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.id.compareTo(id) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.contactEmail);
        hash = 79 * hash + Objects.hashCode(this.contactOwnerEmail);
        hash = 79 * hash + (this.waitingAcceptance ? 1 : 0);
        hash = 79 * hash + (this.accepted ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.waitingAcceptance != other.waitingAcceptance) {
            return false;
        }
        if (this.accepted != other.accepted) {
            return false;
        }
        if (!Objects.equals(this.contactEmail, other.contactEmail)) {
            return false;
        }
        if (!Objects.equals(this.contactOwnerEmail, other.contactOwnerEmail)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", contactEmail=" + contactEmail + ", contactOwnerEmail=" + contactOwnerEmail + ", waitingAcceptance=" + waitingAcceptance + ", accepted=" + accepted + '}';
    }





    /**
     *
     * @return
     */
    public ContactDTO toDTO() {
        return new ContactDTO(this.contactEmail, this.contactOwnerEmail, this.waitingAcceptance, this.accepted);
    }

    /**
     *
     * @param contactDTO
     * @return
     * @throws IllegalArgumentException
     */
    public static Contact fromDTO(ContactDTO contactDTO) throws IllegalArgumentException {
        return new Contact(contactDTO.getContact(), contactDTO.getContactOwner(), contactDTO.isWaitingAcceptance(), contactDTO.isWaitingAcceptance());
    }

}
