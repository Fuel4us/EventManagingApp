package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.jpa;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.CalendarEventRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.PersistenceSettings;

public class JpaCalendarEventRepository extends NSheetsJpaRepositoryBase<CalendarEvent, Long> implements CalendarEventRepository {

    JpaCalendarEventRepository(PersistenceSettings settings) {
        super(settings);
    }
}
