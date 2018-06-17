package pt.isep.nsheets.client.lapr4.blue.s2.core.n1150478.application.extensions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.html.ListItem;
import java.util.LinkedList;
import java.util.List;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.ConfigurationDTO;
import pt.isep.nsheets.shared.services.ConfigurationService;
import pt.isep.nsheets.shared.services.ConfigurationServiceAsync;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.application.workbook.WorkbookView;
import pt.isep.nsheets.client.resources.AppResources;

/**
 * João Pereira_1150478@isep.ipp.pt
 */
public class ExtensionsPresenter extends Presenter<ExtensionsPresenter.MyView, ExtensionsPresenter.MyProxy> {

    private MyView view;

    private final List<String> menuNames = new LinkedList<>();

    private final List<String> popupNames = new LinkedList<>();

    private MaterialSideNavPush activatedSideNav;

    private final List<String> namesSides = new LinkedList<>();

    private final List<MaterialSideNavPush> sides = new LinkedList<>();

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

        IconType getIconMenuChoosed();

        IconType getIconPopChoosed();

        MaterialButton getBtnSide();

        MaterialTextBox getTxtSide();

        MaterialButton getBtnSwitch();

        MaterialComboBox getComboBars();

        MaterialSwitch getMaterialSwitch1();

        MaterialSwitch getMaterialSwitch2();

        MaterialSwitch getMaterialSwitch3();

        MaterialSwitch getMaterialSwitch4();

    }

    @NameToken(NameTokens.extensions)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ExtensionsPresenter> {
    }

    public MaterialSideNavPush getActivatedSideNav() {
        return activatedSideNav;
    }

    public void setActivatedSideNav(MaterialSideNavPush activatedSideNav) {
        this.activatedSideNav = activatedSideNav;
    }

    void addSideName(String name) {
        namesSides.add(name);
    }

    public List<String> getNamesSides() {
        return namesSides;
    }

    void addSides(MaterialSideNavPush side) {
        sides.add(side);
    }

    public List<MaterialSideNavPush> getSides() {
        return sides;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public List<String> getPopupNames() {
        return popupNames;
    }

    public void addMenuName(String name) {
        menuNames.add(name);
    }

    public void addPopupName(String name) {
        popupNames.add(name);
    }

    @Inject
    ExtensionsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;

        // ISTO VAI BUSCAR O VALOR DO BOOLEAN QUE TOU A FALAR
        if (view.getMaterialSwitch1().getValue() == true) { }

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

        addSideName("sideBar");
        addSides(MenuView.getSideNav());
        getView().getComboBars().addItem("sideBar", MenuView.getSideNav());

        getView().getMenuButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String name = getView().getMenuName().getText();
                if (name.isEmpty()) {
                    MaterialToast.fireToast("The name of new menu option is empty! Please write one.");
                } else if (getMenuNames().contains(name)) {
                    MaterialToast.fireToast("This menu option already exists! Please write another name.");
                } else {
                    IconType icon = getView().getIconMenuChoosed();
                    ListItem newItem = new ListItem();
                    MaterialLink ls = new MaterialLink();
                    ls.setText(name);
                    ls.setTextColor(Color.BLACK);
                    ls.setTextAlign(TextAlign.CENTER);
                    ls.setIconType(icon);
                    newItem.add(ls);
                    addMenuName(name);

                    if (MenuView.getNavBar().getActivates().equals("sideBar")) {
                        MenuView.getSideNav().add(newItem);
                        MaterialToast.fireToast("Menu Option created on the original side bar!");
                    } else {
                        getSides().get(getView().getComboBars().getSelectedIndex()).add(newItem);
                        MaterialToast.fireToast("Menu Option created on the new side bar!");
                    }
                }
            }
        });

        getView().getPopButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String name = getView().getPopName().getText();
                if (name.isEmpty()) {
                    MaterialToast.fireToast("The name of the popup is empty! Please write one.");
                } else if (getPopupNames().contains(name)) {
                    MaterialToast.fireToast("This popup option already exists! Please write another name.");
                } else {
                    IconType icon = getView().getIconPopChoosed();
                    MaterialLink pop = new MaterialLink();
                    pop.setText(name);
                    pop.setDisplay(Display.BLOCK);
                    pop.setTextColor(Color.BLACK);
                    pop.setIconType(icon);
                    addPopupName(name);
                    WorkbookView.getPopupMenu().add(pop);
                    MaterialToast.fireToast("Popup menu option created!");
                }
            }
        });

        getView().getBtnSide().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String name = getView().getTxtSide().getText();
                if (name.isEmpty()) {
                    MaterialToast.fireToast("Side bar name is empty! Please choose one.");
                } else if (!getNamesSides().contains(name)) {
                    MaterialSideNavPush aux = new MaterialSideNavPush();
                    ListItem temp = new ListItem();
                    MaterialImage image = new MaterialImage();
                    MaterialLabel nameBox = new MaterialLabel();
                    nameBox.setEnabled(false);
                    nameBox.setText(name);
                    nameBox.setFontSize("2em");
                    nameBox.setTextAlign(TextAlign.CENTER);
                    image.setWidth("100%");
                    image.setResource(AppResources.INSTANCE.nsheets_logo());
                    temp.add(image);
                    aux.setId(name);
                    aux.setWidth(280);
                    aux.setAllowBodyScroll(true);
                    aux.setShowOnAttach(true);

                    aux.add(temp);
                    aux.add(nameBox);
                    MenuView.getNavBar().setActivates(name);
                    MenuView.getPanel().add(aux);
                    setActivatedSideNav(aux);
                    getView().getComboBars().addItem(name, aux);
                    addSideName(name);
                    addSides(aux);
                    MaterialToast.fireToast("The SideBar was created successfully!", "rounded");
                } else {
                    MaterialToast.fireToast("This name already exists! Pick another please.", "rounded");
                }
            }
        });

        getView().getBtnSwitch().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String createdBar = getNamesSides().get(getView().getComboBars().getSelectedIndex());
                MenuView.getNavBar().setActivates(createdBar);
                MenuView.getPanel().add(getSides().get(getView().getComboBars().getSelectedIndex()));
                MaterialToast.fireToast("SideBar changed!", "rounded");
            }
        });
    }
}
