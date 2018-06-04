package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;


import java.util.Arrays;
import java.util.List;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.shared.services.UserDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hilario Coelho
 */
public class LoginUserController {
    private List<User> users = Arrays.asList(
            new User("1160557@isep.ipp.pt", "Hilario", "coelho98", "123asd", true),
            new User("1160558@isep.ipp.pt", "Hilario", "coelho98", "123asd", false)
    );
        
    public LoginUserController() {
        
    }
    
    public UserDTO attemptLogin(String email, String password) {
        for(User u : users) {
            if(u.getEmail().equals(email) && u.verifyPassword(password))
                return u.toDTO();
        }
        return null;
    }
}
