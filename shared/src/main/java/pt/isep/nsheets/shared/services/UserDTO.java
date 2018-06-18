package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    private String email;
    private String name;
    private String nickname;
    private String password;
    private String pictureName;
    private boolean superUser;
    private boolean state;

    public UserDTO(String email, String name, String nickname, String password, String pictureName, boolean superUser, boolean state) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.pictureName = pictureName;
        this.superUser = superUser;
        this.state = state;
    }

    public UserDTO(String email, String name, String nickname, String password, String pictureName, boolean superUser) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.pictureName = pictureName;
        this.superUser = superUser;
        this.state = true;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public UserDTO() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isSuperuser() {
        return this.superUser;
    }

    public String getPictureName() {
        return pictureName;
    }

    public boolean isActivate() { return state; }

    public void setState(boolean state){
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.nickname);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.pictureName);
        hash = 29 * hash + (this.superUser ? 1 : 0);
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
        final UserDTO other = (UserDTO) obj;
        if (this.superUser != other.superUser) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pictureName, other.pictureName)) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
