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
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.ConditionalFormattingExtension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalDTO;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalService;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalServiceAsync;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions.CellStyleExtension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleService;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleServiceAsync;
import pt.isep.nsheets.shared.services.ConfigurationDTO;
import pt.isep.nsheets.shared.services.ConfigurationService;
import pt.isep.nsheets.shared.services.ConfigurationServiceAsync;

import java.util.ArrayList;
import java.util.List;

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

        /* 1050475 Hernani Gil
           Repository loading
         */


        /*1050475 lang03.1 persistencia com erro de compilacao no ConditionalService*/

        ConditionalServiceAsync conditionalServiceAsync = GWT.create(ConditionalService.class);
        AsyncCallback<ArrayList<ConditionalDTO>> callbackCond = new AsyncCallback<ArrayList<ConditionalDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error retrieving extension configuration! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<ConditionalDTO> result) {
                List<Conditional> lstResultFromDTO = new ArrayList<Conditional>();
                for (ConditionalDTO cond: result) {
                    lstResultFromDTO.add(Conditional.fromDTO(cond));
                }

                ConditionalFormattingExtension.setLstConditional(lstResultFromDTO);
            }
        };

        conditionalServiceAsync.getListConditional(callbackCond);

        //loadCellStyles();

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

    public void loadCellStyles(){
        //End of extension CellStyle loading

        /* 1050475 Hernani Gil
           Repository loading
         */

        /* Core08.1 */

        CellStyleServiceAsync cellStyleServiceAsync = GWT.create(CellStyleService.class);
        AsyncCallback<ArrayList<CellStyleDTO>> callbackCStyle = new AsyncCallback<ArrayList<CellStyleDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error retrieving extension cellStyle! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<CellStyleDTO> result) {
                //ArrayList<CellStyle> lstResultFromDTO = new ArrayList<CellStyle>();
                for (CellStyleDTO cellStyleDTO: result) {
                    //lstResultFromDTO.add(CellStyle.fromDTO(cellStyleDTO));
                    CellStyleExtension.addCellStyle(CellStyle.fromDTO(cellStyleDTO));
                }

                //CellStyleExtension.lstCellStyle = lstResultFromDTO;
                MaterialToast.fireToast("Sucess retrieving extension "+ result.size() +" cellStyle!" );
            }
        };

        cellStyleServiceAsync.getListCellStyle(callbackCStyle);

        /*End of extension cellSTyle loading*/

    }
}
