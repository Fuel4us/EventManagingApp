package pt.isep.nsheets.client.application.calendar;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class CalendarModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(CalendarPresenter.class, CalendarPresenter.MyView.class, CalendarView.class, CalendarPresenter.MyProxy.class);
    }
}