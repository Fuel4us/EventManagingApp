package pt.isep.nsheets.client.application.export;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

class ExportView extends ViewImpl implements ExportPresenter.MyView {
	interface Binder extends UiBinder<Widget, ExportView> {
	}

	@Inject
	ExportView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}