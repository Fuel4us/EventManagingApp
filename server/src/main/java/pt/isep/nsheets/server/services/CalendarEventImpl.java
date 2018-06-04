package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application.CreateCalendarEventController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application.DeleteCalendarEventController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application.EditCalendarEventController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application.ViewCalendarEventsController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.CalendarEventDTO;
import pt.isep.nsheets.shared.services.CalendarEventService;
import pt.isep.nsheets.shared.services.DataException;

import java.util.ArrayList;
import java.util.Properties;

/**
 * @author Gonçalo Silva
 */
public class CalendarEventImpl extends RemoteServiceServlet implements CalendarEventService {

    private PersistenceSettings getPersistenceSettings() {
        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<CalendarEventDTO> getCalendarEvents() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ViewCalendarEventsController controller = new ViewCalendarEventsController();

        ArrayList<CalendarEventDTO> events = new ArrayList<CalendarEventDTO>();

        Iterable<CalendarEvent> list = controller.viewCalendarEvents();

        list.forEach(calendarEvents -> events.add(calendarEvents.toDTO()));

        return events;
    }

    @Override
    public CalendarEventDTO createCalendarEvent(CalendarEventDTO dto) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        CreateCalendarEventController controller = new CreateCalendarEventController();

        try {
            controller.createCalendarEvent(dto);
        } catch (DataConcurrencyException ex) {
            throw new DataException(ex);
        } catch (DataIntegrityViolationException ex) {
            throw new DataException(ex);
        }

        return null;
    }

    @Override
    public CalendarEventDTO editCalendarEvent(CalendarEventDTO dto) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        EditCalendarEventController controller = new EditCalendarEventController();

        controller.editCalendarEvent(dto);

        return null;
    }

    @Override
    public CalendarEventDTO deleteCalendarEvent(CalendarEventDTO dto) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        DeleteCalendarEventController controller = new DeleteCalendarEventController();

        controller.deleteCalendarEvent(dto);

        return null;
    }
}
