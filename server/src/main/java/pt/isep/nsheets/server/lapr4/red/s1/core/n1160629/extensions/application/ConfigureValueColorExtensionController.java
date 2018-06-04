package pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.persistence.ConfigurationRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.ValueColorExtension;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.services.ConfigurationDTO;

import java.util.Collection;
import java.util.Iterator;

public class ConfigureValueColorExtensionController {
    Configuration config = ValueColorExtension.config;

    public Configuration configureExtension(int bgColorPos, int fgColorPos, int bgColorNeg, int fgColorNeg){
        config.setBgColorPos(bgColorPos);
        config.setFgColorPos(fgColorPos);
        config.setBgColorNeg(bgColorNeg);
        config.setFgColorNeg(fgColorNeg);

        final ConfigurationRepository configurationRepository = PersistenceContext.repositories().configuration();
        Configuration ret = null;
        try {
            ret = configurationRepository.save(config);
        } catch (DataConcurrencyException e) {
            e.printStackTrace();
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int[] loadValuesFromDatabase(){
        int ret[] = new int[4];

        Configuration configuration = loadConfigurationFromDatabase();

        if(configuration==null){
            configuration = new Configuration();
        }
        ret[0]=configuration.getBgColorPos();
        ret[1]=configuration.getFgColorPos();
        ret[2]=configuration.getBgColorNeg();
        ret[3]=configuration.getFgColorNeg();
        return ret;
    }

    public Configuration loadConfigurationFromDatabase(){
        final ConfigurationRepository configurationRepository = PersistenceContext.repositories().configuration();
        Iterator<Configuration> configurationIterator = configurationRepository.findAll().iterator();
        if(configurationIterator.hasNext()){
            return configurationIterator.next();
        }
        return config;
    }
}
