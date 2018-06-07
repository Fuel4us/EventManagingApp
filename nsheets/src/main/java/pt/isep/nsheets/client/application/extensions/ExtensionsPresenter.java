package pt.isep.nsheets.client.application.extensions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.ListItem;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.ConfigurationDTO;
import pt.isep.nsheets.shared.services.ConfigurationService;
import pt.isep.nsheets.shared.services.ConfigurationServiceAsync;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.application.workbook.WorkbookView;

/**
 * João Pereira <1150478@isep.ipp.pt>
 */
public class ExtensionsPresenter extends Presenter<ExtensionsPresenter.MyView, ExtensionsPresenter.MyProxy> {
    
    private MyView view;
    
    interface MyView extends View {
        
        void addConfirmationHandler(ClickHandler ch);
        
        int getBgColorPosValue();
        
        int getFgColorPosValue();
        
        int getBgColorNegValue();
        
        int getFgColorNegValue();
        
        void setBgColorPosValue(int index);
        
        void setFgColorPosValue(int index);
        
        void setBgColorNegValue(int index);
        
        void setFgColorNegValue(int index);
        
        MaterialButton getMenuButton();
        
        MaterialTextBox getMenuName();
        
        MaterialTextBox getPopName();
        
        MaterialButton getPopButton();
    }
    
    @NameToken(NameTokens.extensions)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ExtensionsPresenter> {
    }
    
    @Inject
    ExtensionsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;
        
        view.addConfirmationHandler(event -> {
            ConfigurationServiceAsync configurationSvc = GWT.create(ConfigurationService.class);
            
            AsyncCallback<ConfigurationDTO> callback = new AsyncCallback<ConfigurationDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error configuring extension! " + caught.getMessage());
                }
                
                @Override
                public void onSuccess(ConfigurationDTO result) {
                    MaterialToast.fireToast("Extension configured!");
                }
            };
            
            int[] values = new int[4];
            values[0] = view.getBgColorPosValue();
            values[1] = view.getFgColorPosValue();
            values[2] = view.getBgColorNegValue();
            values[3] = view.getFgColorNegValue();
            
            configurationSvc.saveConfiguration(new ConfigurationDTO(values), callback);
        });
        
        ConfigurationServiceAsync configurationSvc = GWT.create(ConfigurationService.class);
        
        AsyncCallback<ConfigurationDTO> callback = new AsyncCallback<ConfigurationDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error retrieving configuration! " + caught.getMessage());
            }
            
            @Override
            public void onSuccess(ConfigurationDTO result) {
                view.setBgColorPosValue(result.getBgColorPos());
                view.setFgColorPosValue(result.getFgColorPos());
                view.setBgColorNegValue(result.getBgColorNeg());
                view.setFgColorNegValue(result.getFgColorNeg());
                MaterialToast.fireToast("Configuration retrieved!");
            }
        };
        configurationSvc.getConfiguration(callback);
    }
    
    @Override
    protected void onReveal() {
        super.onReveal();
        
        SetPageTitleEvent.fire("Extensions", "Configure Extensions", "", "", this);
        
    }
    
    @Override
    protected void onBind() {
        super.onBind();
        
        getView().getMenuButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String name = getView().getMenuName().getText();
                ListItem newItem = new ListItem();
                MaterialLink ls = new MaterialLink();
                ls.setText(name);
                newItem.add(ls);
                MenuView.getSideNav().add(ls);
                MaterialToast.fireToast("Menu Option created!");
            }
        });
        
        getView().getPopButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String name = getView().getPopName().getText();
                MaterialLink pop = new MaterialLink();
                pop.setText(name);
                WorkbookView.getPopupMenu().add(pop);
                MaterialToast.fireToast("Popup option created!");
            }
        });
    }
    
}
