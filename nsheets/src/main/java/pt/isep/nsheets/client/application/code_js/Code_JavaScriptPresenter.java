package pt.isep.nsheets.client.application.code_js;

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

public class Code_JavaScriptPresenter extends Presenter<Code_JavaScriptPresenter.MyView, Code_JavaScriptPresenter.MyProxy> {

    interface MyView extends View {
    }

    @NameToken(NameTokens.code_js)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<Code_JavaScriptPresenter> {
    }

    @Inject
    Code_JavaScriptPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Code [JavaScript]", "Add JavaScript Script ", "", "", this);
    }
}

