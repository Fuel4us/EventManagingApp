package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("configurationService")
public interface ConfigurationService extends RemoteService{
    ConfigurationDTO getConfiguration();

    ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO) throws DataException;
}
