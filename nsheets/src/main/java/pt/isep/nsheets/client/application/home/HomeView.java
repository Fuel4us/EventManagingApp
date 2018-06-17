package pt.isep.nsheets.client.application.home;

import com.google.gwt.core.client.GWT;
import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

class HomeView extends ViewImpl implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    private WorkbookDTO wdto;

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialButton newWorkbookButton, saveButton, deleteButton, renameButton, cancelButton, searchButton, swichStateButton;

    @UiField
    MaterialModal modal, optionModal;

    @UiField
    MaterialTextBox name, description, renameTxt, searchTxt;

    @Inject
    HomeView(Binder uiBinder, CurrentUser currentUser) {
        initWidget(uiBinder.createAndBindUi(this));

        MenuView.getUsername().clear();
        MenuView.getUsername().setText("Welcome, " + currentUser.getUser().getNickname());

        MenuView.getLogout().clear();
        MenuView.getLogout().setText("Logout");

        MenuView.getImage().setUrl(currentUser.getUser().getPictureName());
        MenuView.getImage().setBorder("2px solid #186AAB");
    }

    private MaterialCard createCard(WorkbookDTO wb) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_2);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();

        cardTitle.add(new Anchor(wb.name, "#workbook"));
        cardTitle.setIconType(IconType.SETTINGS);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label = new MaterialLabel();
        label.setText(wb.description);

        cardContent.add(cardTitle);
        cardContent.add(label);

        card.add(cardContent);

        card.addClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                public void onFailure(Throwable caught) {

                }

                public void onSuccess(WorkbookDTO result) {
                    MaterialToast.fireToast(result.name);
                    renameTxt.setText(result.name);
                    openOptionModal();

                    wdto = result;
                    Settings.getInstance().updateWorkbook(result);
                }
            };

            workbooksSvc.findByName(wb.name, callback);
        });

        return card;
    }

    @Override
    public void setContents(ArrayList<WorkbookDTO> contents
    ) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (WorkbookDTO wb : contents) {
            MaterialCard card = createCard(wb);

            if (colCount == 1) {
                row = new MaterialRow();
                htmlPanel.add(row);
                ++colCount;
                if (colCount >= 4) {
                    colCount = 1;
                }
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("l4");
            row.add(col);

            col.add(card);
        }

    }

    @Override
    public void buttonClickHandler(ClickHandler ch
    ) {
        saveButton.addClickHandler(ch);
    }

    @Override
    public void addClickHandler(ClickHandler ch
    ) {
        // TODO Auto-generated method stub

        newWorkbookButton.addClickHandler(ch);
    }

    @Override
    public void renameClickHandler(ClickHandler ch) {
        renameButton.addClickHandler(ch);
    }

    @Override
    public void switchClickHandler(ClickHandler ch) {
        swichStateButton.addClickHandler(ch);
    }

    @Override
    public void deleteClickHandler(ClickHandler ch) {
        deleteButton.addClickHandler(ch);
    }

    @Override
    public void cancelClickHandler(ClickHandler ch) {
        cancelButton.addClickHandler(ch);
    }

    @Override
    public void searchClickHandler(ClickHandler ch) {
        searchButton.addClickHandler(ch);
    }

    @Override
    public WorkbookDTO focusedWorkbookDTO() {
        return wdto;
    }

    @Override
    public String rename() {
        return this.renameTxt.getText();
    }

    @Override
    public MaterialButton getSwichStateButton() {
        return swichStateButton;
    }

    @Override
    public void openModal() {
        this.modal.open();
    }

    @Override
    public void openOptionModal() {
        this.optionModal.open();
    }

    @Override
    public void closeModal() {
        this.modal.close();
    }

    @Override
    public void closeOptionModal() {
        this.optionModal.close();
    }

    @Override
    public String title() {
        return this.name.getValue();
    }

    @Override
    public String description() {
        return this.description.getValue();
    }

    @Override
    public String search() {
        return this.searchTxt.getText();
    }
}
