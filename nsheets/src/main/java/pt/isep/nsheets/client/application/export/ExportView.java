package pt.isep.nsheets.client.application.export;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;

import javax.inject.Inject;

class ExportView extends ViewImpl implements ExportPresenter.MyView {

	@Override
	public void csvButtonClickHandler(ClickHandler ch) {
		export_csv.addClickHandler(ch);
	}

        @Override
	public void xmlButtonClickHandler(ClickHandler cHandler) {
		export_xml.addClickHandler(cHandler);
	}

	@Override
	public void pdfButtonClickHandler(ClickHandler clickHandler) {
		export_pdf.addClickHandler(clickHandler);
	}


	interface Binder extends UiBinder<Widget, ExportView> {}

	@UiField
	MaterialButton export_pdf;

	@UiField
	MaterialButton export_csv;
        
        @UiField
	MaterialButton export_xml;

	@Inject
	ExportView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}