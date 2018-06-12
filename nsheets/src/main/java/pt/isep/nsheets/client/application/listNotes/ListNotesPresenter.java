/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.listNotes;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

/**
 * @author Tiago Correia
 */
public class ListNotesPresenter extends Presenter<ListNotesPresenter.MyView, ListNotesPresenter.MyProxy> {

    interface MyView extends View {
    }

    @NameToken(NameTokens.listNotes)
    @ProxyStandard

    interface MyProxy extends ProxyPlace<ListNotesPresenter> {
    }

    @Inject
    ListNotesPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("ListNotes", "A description of NSheets", "", "", this);
    }

}
