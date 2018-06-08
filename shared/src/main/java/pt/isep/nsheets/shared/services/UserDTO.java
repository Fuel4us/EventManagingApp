package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    private String email;
    private String name;
    private String nickname;
    private String password;
    private boolean superUser;

    public UserDTO(String email, String name, String nickname, String password, boolean superUser) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.superUser = superUser;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public UserDTO() {}

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
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserDTO))
            return false;

        final UserDTO that = (UserDTO) other;
        if (this == that)
            return true;

        if (!this.email.equals(that.email))
            return false;

        if (!this.name.equals(that.name))
            return false;

        if (!this.nickname.equals(that.nickname))
            return false;

        if (!this.password.equals(that.password))
            return false;

        if (this.superUser != that.superUser)
            return false;

        return true;
    }
}
