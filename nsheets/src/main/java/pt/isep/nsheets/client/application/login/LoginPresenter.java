package pt.isep.nsheets.client.application.login;

import com.google.gwt.event.dom.client.ClickHandler;
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

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {

	private MyView view;

	interface MyView extends View {
            void addLoginHandler(ClickHandler ch);
            
            String getEmail();
            String getPassword();
	}

	@NameToken(NameTokens.login)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<LoginPresenter> {
	}

	@Inject
	LoginPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
            super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

            this.view = view;
            
            this.view.addLoginHandler(event -> {
                String email = this.view.getEmail();
                String password = this.view.getPassword();
            });
	}

	private void refreshView() {
	}
	
	@Override
	protected void onReveal() {
            super.onReveal();

            SetPageTitleEvent.fire("Login", "Login on NSheets booooooyyyyy", "", "", this);

            refreshView();
	}
}