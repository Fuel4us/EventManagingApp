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

    private String contactName;
    private String contactEmail;

    /**
     *
     * @param contactName must be non-null
     * @param contactEmail
     * @throws IllegalArgumentException
     */
    public Contact(String contactName, String contactEmail) throws IllegalArgumentException {
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
     * for persistence purposes only
     */
    protected Contact() {
    }

    @Override
    public Long id() {
        return this.id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
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
        if (!this.contactName.equals(that.contactName)) {
            return false;
        }

        if (!this.contactEmail.equals(that.contactEmail)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.id.compareTo(id) == 0);
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", contactName=" + contactName + ", contactEmail=" + contactEmail + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.contactName);
        hash = 41 * hash + Objects.hashCode(this.contactEmail);
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
        if (!Objects.equals(this.contactName, other.contactName)) {
            return false;
        }
        if (!Objects.equals(this.contactEmail, other.contactEmail)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public ContactDTO toDTO() {
        return new ContactDTO(this.contactName, this.contactEmail);
    }

    /**
     *
     * @param contactDTO
     * @return
     * @throws IllegalArgumentException
     */
    public static Contact fromDTO(ContactDTO contactDTO) throws IllegalArgumentException {
        return new Contact(contactDTO.getContactName(), contactDTO.getContactEmail());
    }

}
