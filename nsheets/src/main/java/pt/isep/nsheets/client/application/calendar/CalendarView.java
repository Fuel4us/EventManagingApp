package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

class CalendarView extends ViewImpl implements CalendarPresenter.MyView {
    interface Binder extends UiBinder<Widget, CalendarView> {
    }

    @Inject
    CalendarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

}