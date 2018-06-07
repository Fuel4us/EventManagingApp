package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {

    /**
     *
     * @return
     */
    ArrayList<ContactDTO> getContacts();

    /**
     *
     * @param contactsDTO
     * @return
     * @throws DataException
     */
    ContactDTO addContact(ContactDTO contactsDTO) throws DataException;
}
