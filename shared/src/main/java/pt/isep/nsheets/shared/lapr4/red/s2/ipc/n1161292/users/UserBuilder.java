package pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.users;

import java.util.List;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class UserBuilder {

    private String email;
    private String name;
    private String nickname;
    private Password password;
    private boolean superUser;
    private List<UserDTO> blacklist;

    public UserBuilder() {
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = new Password(password);
        return this;
    }

    public UserBuilder withPassword(Password password) {
        this.password = password;
        return this;
    }

    public UserBuilder withSuperUser(boolean superUser) {
        this.superUser = superUser;
        return this;
    }

    public UserBuilder withBlacklist(List<UserDTO> blacklist) {
        this.blacklist = blacklist;
        return this;
    }

    public UserDTO build() {
        return new UserDTO(this.email, this.name, this.nickname, this.password.toString(), this.superUser, this.blacklist);
    }
}
