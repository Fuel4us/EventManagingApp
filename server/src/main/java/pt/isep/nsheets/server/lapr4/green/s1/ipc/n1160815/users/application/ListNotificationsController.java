/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Notification;

/**
 *
 * @author Josué Lapa
 */
public class ListNotificationsController {

    public Iterable<Notification> listNotifications(String username) {
        return new ChatService().allNotificationsFromUser(username);
    }
}
