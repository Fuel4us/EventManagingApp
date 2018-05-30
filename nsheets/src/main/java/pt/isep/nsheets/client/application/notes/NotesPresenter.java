package pt.isep.nsheets.client.application.notes;

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

public class NotesPresenter extends Presenter<NotesPresenter.MyView, NotesPresenter.MyProxy>  {
	
    interface MyView extends View  {
    }
    
    @NameToken(NameTokens.notes)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<NotesPresenter> {
    }

    @Inject
    NotesPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }
    
    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Notes", "A description of NSheets", "", "", this);
    }
    
}