package pt.isep.nsheets.client.application.extensions;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Flex;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTabItem;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.client.ui.html.Label;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.ExtensionManager;

import javax.inject.Inject;

class ExtensionsView extends ViewImpl implements ExtensionsPresenter.MyView {

    interface Binder extends UiBinder<Widget, ExtensionsView> {
    }

    @Inject
    ExtensionsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        loadExtensions();
    }

    @UiField
    MaterialTab extensionTab;

    @UiField
    MaterialRow extensionRow;



    private void loadExtensions(){
       // ExtensionManager extensionManager = ExtensionManager.getInstance();
       // Extension[] extensions=extensionManager.getExtensions();
        for(int i=0;i<5;i++){
            MaterialTabItem materialTabItem = new MaterialTabItem();
            materialTabItem.setWaves(WavesType.LIGHT);
            MaterialLink materialLink = new MaterialLink();
            materialLink.setText("Extension "+i);

            materialLink.setHref("#extension"+i);
            materialTabItem.add(materialLink);
            extensionTab.add(materialTabItem);
            Div test = new Div();
            test.setId("#extension"+i);
            Label label = new Label();
            label.setText("Test for "+i);
            test.add(label);
            test.setVisible(false);
            extensionRow.add(test);
        }
    }



}
