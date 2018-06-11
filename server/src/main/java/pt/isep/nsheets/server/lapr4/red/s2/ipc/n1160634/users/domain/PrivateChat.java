package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import eapli.framework.domain.AggregateRoot;
import java.util.List;
import pt.isep.nsheets.shared.services.PrivateChatDTO;

/**
 *
 * @author Pedro Marques Vieira
 */
@Entity
public class PrivateChat implements AggregateRoot<Long>, Serializable {

    /**
     * ORM primary key
     */
    @Id
    @GeneratedValue
    private Long pk = null;

    /**
     * List of the emails of the users
     */
    private List<String> listEmails;

    
    /**
     * Constructor of the PrivateChat with all the arguments
     *
     * @param listEmails list of the emails of users to the private chat
     */
    public PrivateChat(List<String> listEmails) {
        this.listEmails = listEmails;
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable and for ORM!
     */
    protected PrivateChat() {
    }

    /**
     * Method responsable to comapre if it is the same id key
     *
     * @param id other key
     * @return boolean result
     */
    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    /**
     * Method to return the id of the PrivateChat
     *
     * @return long value of the key
     */
    @Override
    public Long id() {
        return this.pk;
    }

    /**
     * Method to create a PrivateChatDTO from this PrivateChat
     *
     * @return PrivateChatDTO created
     */
    public PrivateChatDTO toDTO() {
        return new PrivateChatDTO(this.listEmails);
    }

    /**
     * Method to create a privateChat from a PrivateChatDTO
     *
     * @param pcDto PrivateChatDTO
     * @return Created PrivateChat
     * @throws IllegalArgumentException exceptions
     */
    public static PrivateChat fromDTO(PrivateChatDTO pcDto) throws IllegalArgumentException {
        return new PrivateChat(pcDto.getListEmails());
    }

    /**
     * To compare if a PrivateChat is equal to another
     *
     * @param obj Another object
     * @return boolean result
     */
    @Override
    public boolean sameAs(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrivateChat other = (PrivateChat) obj;
        return this.listEmails.equals(other.listEmails);
    }
}
