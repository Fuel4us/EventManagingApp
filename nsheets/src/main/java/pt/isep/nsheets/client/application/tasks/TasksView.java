/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.tasks;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */

public class TasksView extends ViewImpl implements TasksPresenter.MyView {

    interface Binder extends UiBinder<Widget, TasksView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @Inject
    TasksView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
