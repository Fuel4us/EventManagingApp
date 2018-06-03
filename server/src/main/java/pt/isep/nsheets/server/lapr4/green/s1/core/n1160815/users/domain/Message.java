package pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.domain;

/**
 *
 * @author leandro pinto
 */
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

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    private String text;
    
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date currentDate;
    
    private String user;

    public Message(String text) {
        this.text = text;
        this.currentDate = new Date();
    }
    
    public Message(String text,Date currentDate,String user) {
        this.text = text;
        this.currentDate = currentDate;
        this.user = user;
    }

    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected Message() {
    }

    
    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    
    public MessagesDTO toDTO() {
        return new MessagesDTO(this.text, this.currentDate, "user1234321");
    }

    public static Message fromDTO(MessagesDTO dto) throws IllegalArgumentException {
        return new Message(dto.getText(), dto.getDate(),dto.getUser());
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
        final Message other = (Message) obj;
        if (!this.text.equals(other.text)) {
            return false;
        }
        if (!this.currentDate.equals(other.currentDate)) {
            return false;
        }
        return (this.user == null ? other.user != null : !this.user.equals(other.user));
    }
}
