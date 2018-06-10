package pt.isep.nsheets.client.application.imports;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

public class ImportPresenter extends Presenter<ImportPresenter.MyView, ImportPresenter.MyProxy> {

    interface MyView extends View {
    }

    @NameToken(NameTokens.imports)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ImportPresenter> {
    }

    @Inject
    ImportPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Import", "Import your saved workbooks", "", "", this);
    }
}