package pt.isep.nsheets.client.application.extensions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.application.ConfigureValueColorExtensionController;
import pt.isep.nsheets.shared.services.ConfigurationDTO;
import pt.isep.nsheets.shared.services.ConfigurationService;
import pt.isep.nsheets.shared.services.ConfigurationServiceAsync;

public class ExtensionsPresenter extends Presenter<ExtensionsPresenter.MyView, ExtensionsPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void addConfirmationHandler(ClickHandler ch);

        String getBgColorPosValue();
        String getFgColorPosValue();
        String getBgColorNegValue();
        String getFgColorNegValue();
        void setBgColorPosValue(String bgColorPosValue);
        void setFgColorPosValue(String fgColorPosValue);
        void setBgColorNegValue(String bgColorNegValue);
        void setFgColorNegValue(String fgColorNegValue);
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

            String[] values = new String[4];
            values[0]=view.getBgColorPosValue();
            values[1]=view.getFgColorPosValue();
            values[2]=view.getBgColorNegValue();
            values[3]=view.getFgColorNegValue();

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
    protected void onReveal(){
        super.onReveal();

        SetPageTitleEvent.fire("Extensions", "Configure Extensions", "", "", this);


    }

}
