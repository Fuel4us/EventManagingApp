/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.listNotes;

import javax.inject.Inject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class ListNotesView extends ViewImpl implements ListNotesPresenter.MyView {

    interface Binder extends UiBinder<Widget, ListNotesView> {
    }

    @Inject
    ListNotesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
