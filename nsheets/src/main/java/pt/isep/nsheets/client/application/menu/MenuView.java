package pt.isep.nsheets.client.application.menu;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSideNavPush;
import gwt.material.design.client.ui.html.ListItem;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {

    interface Binder extends UiBinder<Widget, MenuView> {

    }

    @UiField
    MaterialNavBar navBar;
    @UiField
    MaterialSideNavPush sideNav;

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    void newOptionCreator(String name) {
        ListItem newItem = new ListItem();
        newItem.setTitle(name);
        sideNav.add(newItem);
    }

}
