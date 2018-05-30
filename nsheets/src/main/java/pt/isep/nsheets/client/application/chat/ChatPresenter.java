package pt.isep.nsheets.client.application.chat;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class ChatPresenter extends Presenter<ChatPresenter.MyView, ChatPresenter.MyProxy> {

	private MyView view;

	interface MyView extends View {
		void setContents(ArrayList<WorkbookDescriptionDTO> contents);

		void addClickHandler(ClickHandler ch);
	}

	@NameToken(NameTokens.chat)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<ChatPresenter> {
	}

	@Inject
	ChatPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

		this.view = view;

	}

	private void refreshView() {
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();

		SetPageTitleEvent.fire("Chat", "Public Online Chat", "", "", this);

		refreshView();
	}
}