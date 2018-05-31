package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.jpa;

import eapli.framework.persistence.repositories.impl.jpa.JpaTxRepository;
import eapli.util.Strings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.PersistenceSettings;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.logging.Logger;

abstract class NSheetsJpaRepositoryBase<T, K extends Serializable> extends JpaTxRepository<T, K> {

    private PersistenceSettings settings = null;

    NSheetsJpaRepositoryBase(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    NSheetsJpaRepositoryBase(PersistenceSettings settings) {
        super(settings.getPersistenceUnitName());
        this.settings = settings;
    }

    @Override
    protected EntityManagerFactory entityManagerFactory() {
        if (this.emFactory == null) {
            assert !Strings.isNullOrEmpty(this.persistenceUnitName) : "the persistence unit name must be provided";
            Logger.getLogger(this.getClass().getSimpleName())
                    .info("EAPLI-F-PJ001: Not runing in container mode; creating entity manager factory by hand");
            //this.emFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            this.emFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName, this.settings.properties());
        }
        return this.emFactory;
    }
}
