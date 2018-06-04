package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.CalendarEventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 * @author Gonçalo Silva
 */
public class JpaCalendarEventRepository extends NSheetsJpaRepositoryBase<CalendarEvent, Long> implements CalendarEventRepository {

    JpaCalendarEventRepository(PersistenceSettings settings) {
        super(settings);
    }
}
