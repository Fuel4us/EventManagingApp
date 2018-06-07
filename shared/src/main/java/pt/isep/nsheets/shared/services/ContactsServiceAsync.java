package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ContactsServiceAsync {

    /**
     *
     * @param callback
     */
    void getContacts(AsyncCallback<ArrayList<ContactDTO>> callback);

    /**
     *
     * @param contactsDTO
     * @param callback
     */
    void addContact(ContactDTO contactsDTO, AsyncCallback<ContactDTO> callback);

}
