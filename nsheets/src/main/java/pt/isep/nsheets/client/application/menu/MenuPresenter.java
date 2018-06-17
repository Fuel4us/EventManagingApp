package pt.isep.nsheets.client.application.menu;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import pt.isep.nsheets.client.event.ContentPushEvent;

import com.gwtplatform.mvp.client.HasUiHandlers;
import gwt.material.design.client.ui.MaterialSideNavPush;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.place.ParameterTokens;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {

	private final PlaceManager placeManager;

	interface MyView extends View, HasUiHandlers<MenuUiHandlers> {
	}

	@Inject
	MenuPresenter(EventBus eventBus, MyView view, PlaceManager placeManager) {
		super(eventBus, view);
		this.placeManager = placeManager;

		MenuView.getUsername().addClickHandler(event -> {
			if(!MenuView.getUsername().getText().startsWith("Welcome")){
				redirectToLoginPage();
			}

		});

		getView().setUiHandlers(this);
	}

	protected void onBind() {
		super.onBind();
	}

	@Override
	public void setContentPush() {
		ContentPushEvent.fire(this);
	}

	private void redirectToLoginPage(){
		String token = placeManager
				.getCurrentPlaceRequest()
				.getParameter(ParameterTokens.REDIRECT, NameTokens.login);
		PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();

		placeManager.revealPlace(placeRequest);
	}
        
}