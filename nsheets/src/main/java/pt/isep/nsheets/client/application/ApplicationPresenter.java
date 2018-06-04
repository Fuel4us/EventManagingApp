/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package pt.isep.nsheets.client.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.menu.MenuPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.ValueColorExtension;
import pt.isep.nsheets.shared.services.ConfigurationDTO;
import pt.isep.nsheets.shared.services.ConfigurationService;
import pt.isep.nsheets.shared.services.ConfigurationServiceAsync;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> 
		implements SetPageTitleEvent.SetPageTitleHandler {
	
    interface MyView extends View {
    		void setPageTitle(String title, String description, String link, String specification);
    }

    public static final PermanentSlot<MenuPresenter> SLOT_MENU = new PermanentSlot<>();
    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    private MenuPresenter menuPresenter;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy, MenuPresenter menuPresenter) {
        super(eventBus, view, proxy, RevealType.Root);

        //load extension configuration before showing anything else
        ConfigurationServiceAsync configurationSvc = GWT.create(ConfigurationService.class);

        AsyncCallback<ConfigurationDTO> callback = new AsyncCallback<ConfigurationDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error retrieving extension configuration! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ConfigurationDTO result) {
                ValueColorExtension.setConfig(result.fromDTO());
            }
        };
        configurationSvc.getConfiguration(callback);
        //End of extension configuration loading

        this.menuPresenter = menuPresenter;
            
    }
    
    @Override
    protected void onReset() {
    		super.onReset();
    }
    
    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(SLOT_MENU, menuPresenter);
        
        addRegisteredHandler(SetPageTitleEvent.TYPE, this);
    }
    
    @Override
    public void onSetPageTitle(SetPageTitleEvent event) {
        getView().setPageTitle(event.getTitle(), event.getDescription(), event.getLink(), event.getSpecification());
    }    
}
