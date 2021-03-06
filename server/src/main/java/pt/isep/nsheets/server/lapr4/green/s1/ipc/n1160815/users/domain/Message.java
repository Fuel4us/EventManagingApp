package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import eapli.framework.domain.AggregateRoot;
import java.util.Date;
import javax.persistence.Temporal;
import pt.isep.nsheets.shared.services.MessagesDTO;

/**
 * Contact
 *
 * @author Leandro Pinto
 *
 */
@Entity
public class Message implements AggregateRoot<Long>, Serializable {

    /**
     * ORM primary key
     */
    @Id
    @GeneratedValue
    private Long pk = null;

    /**
     * Text of the message
     */
    private String text;

    /**
     * Date of the message
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date currentDate;

    /**
     * Nickname of the user of the message
     */
    private String userNickname;

    /**
     * Index of the chat
     */
    private int chatIndex;

    /**
     * Constructor with only the text in the message
     *
     * @param text Text of the message
     */
    public Message(String text) {
        this.text = text;
        this.currentDate = new Date();
    }

    /**
     * Constructor of the message with all the arguments
     *
     * @param text Text of the message
     * @param currentDate Current Date
     * @param user Nickname of the user of the message
     * @param chatIndex Index of the chat
     */
    public Message(String text, Date currentDate, String user, int chatIndex) {
        this.text = text;
        this.currentDate = currentDate;
        this.userNickname = user;
        this.chatIndex = chatIndex;
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable and for ORM!
     */
    protected Message() {
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
     * Method to return the id of the message
     *
     * @return long value of the key
     */
    @Override
    public Long id() {
        return this.pk;
    }

    /**
     * Method to create a MessageDTO from this message
     *
     * @return MessageDTO created
     */
    public MessagesDTO toDTO() {
        return new MessagesDTO(this.text, this.currentDate, this.userNickname, this.chatIndex);
    }

    /**
     * Method to create a message from a MessageDTO
     *
     * @param dto MessageDTO
     * @return Created MEssage
     * @throws IllegalArgumentException exceptions
     */
    public static Message fromDTO(MessagesDTO dto) throws IllegalArgumentException {
        return new Message(dto.getText(), dto.getDate(), dto.getUser(), dto.getChatIndex());
    }

    /**
     * To compare if a message is equal to another
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
        final Message other = (Message) obj;
        if (!this.text.equals(other.text)) {
            return false;
        }
        if (!this.currentDate.equals(other.currentDate)) {
            return false;
        }
        if (chatIndex == other.chatIndex) {
            return false;
        }
        return (this.userNickname == null ? other.userNickname != null : !this.userNickname.equals(other.userNickname));
    }
}
