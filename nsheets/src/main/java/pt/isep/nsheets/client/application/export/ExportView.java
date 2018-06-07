package pt.isep.nsheets.client.application.export;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class ExportView extends ViewImpl implements ExportPresenter.MyView {

    @UiField
    MaterialButton export_pdf;
    @UiField
    MaterialButton export_csv;
    @UiField
    MaterialButton export_xml;
    @UiField
    MaterialButton export_csl;
    
    @UiField
    MaterialInput color_line;
    
    @UiField
    MaterialButton style_export_pdf, close, save, save_pdf;
    
    @UiField
    MaterialRadioButton dotted, double_, solid, dashed;
    
    @UiField
    MaterialModal modal;
    
     private String style;
    private String color;
    private final List<MaterialRadioButton> radiolist;
    
    @UiHandler("style_export_pdf")
    void openOverlay(ClickEvent event) {
        this.modal.open();
    }
    
    @UiHandler("save")
    void save(ClickEvent event){
        color = color_line.getValue();
        style = findSelected().getFormValue();
        MaterialToast.fireToast("Line style: "+style+"Line Color: "+color);
    }
   


    @Inject
    ExportView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        radiolist = createMaterialRadioButtonArray();
    }

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

    @Override
    public void cslButtonClickHandler(ClickHandler clickHandler) {
        export_csl.addClickHandler(clickHandler);
    }

    @Override
    public void closeModal(ClickHandler clickHandler) {
        close.addClickHandler(clickHandler);
    }

    @Override
    public MaterialModal getOverlay() {
        return modal;
    }

    interface Binder extends UiBinder<Widget, ExportView> {
    }
    
    private List<MaterialRadioButton> createMaterialRadioButtonArray() {
    
        List<MaterialRadioButton> list = new ArrayList<>();
        list.add(dotted);
        list.add(double_);
        list.add(solid);
        list.add(dashed);

        return list;
        
}
    
    private MaterialRadioButton findSelected(){
        
        for(MaterialRadioButton button:radiolist){
            if(button.getValue())
                return button;
        }
        
        return null;
    }

}