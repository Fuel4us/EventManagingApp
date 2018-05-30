package pt.isep.nsheets.client.application.notes;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class NotesView extends ViewImpl implements NotesPresenter.MyView {
	interface Binder extends UiBinder<Widget, NotesView> {
	}

	@Inject
	NotesView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}