package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.jpa;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.CalendarEventRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.RepositoryFactory;

public class JpaRepositoryFactory implements RepositoryFactory {

    private PersistenceSettings settings = null;

    public PersistenceSettings setSettings(PersistenceSettings settings) {
        return this.settings = settings;
    }

    @Override
    public CalendarEventRepository calendarEvents() {
        return new JpaCalendarEventRepository(this.settings);
    }
}
