package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialDatePicker;

import javax.inject.Inject;

class CalendarView extends ViewImpl implements CalendarPresenter.MyView {
    interface Binder extends UiBinder<Widget, CalendarView> {
    }

    @UiField
    MaterialDatePicker dp;

    @Inject
    CalendarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}