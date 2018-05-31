package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence;

public interface RepositoryFactory {

    PersistenceSettings setSettings(PersistenceSettings settings);

    CalendarEventRepository calendarEvents();
}
