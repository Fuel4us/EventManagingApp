package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.shared.services.NotificationDTO;

@Entity
public class Notification implements AggregateRoot<Long>, Serializable {

    /**
     * ORM primary key
     */
    @Id
    @GeneratedValue
    private Long pk = null;

    /**
     * notification username
     */
    private String username;
    /**
     * user who sends the message
     */
    private String sender;

    /**
     * Text of the notification
     */
    private String text;

    /**
     * Constructor of the notification with all the arguments
     *
     * @param username
     * @param from
     * @param text Text of the notification
     */
    public Notification(String username, String from, String text) {
        this.username = username;
        this.sender = from;
        this.text = text;       
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable and for ORM!
     */
    protected Notification() {
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

    @Override
    public Long id() {
        return this.pk;
    }

    public NotificationDTO toDTO() {
        return new NotificationDTO(this.text, this.sender, this.username);
    }

    public static Notification fromDTO(NotificationDTO dto) throws IllegalArgumentException {
        return new Notification(dto.getUsername(), dto.getSender(), dto.getText());
    }

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
        final Notification other = (Notification) obj;
        if (!this.text.equals(other.text)) {
            return false;
        }

        if (!this.sender.equals(other.sender)) {
            return false;
        }
        return (this.username == null ? other.username != null : !this.username.equals(other.username));
    }
}
