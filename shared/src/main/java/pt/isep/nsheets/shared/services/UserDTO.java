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
    public UserDTO() {
        this.email = "";
        this.name = "";
        this.nickname = "";
        this.password = "";
        this.superUser = false;
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
}
