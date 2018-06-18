/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.tasks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.services.TasksDTO;
import pt.isep.nsheets.shared.services.TasksService;
import pt.isep.nsheets.shared.services.TasksServiceAsync;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksView extends ViewImpl implements TasksPresenter.MyView {

    interface Binder extends UiBinder<Widget, TasksView> {
    }

    private TasksDTO tasksDTO;

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialModal optionModal;

    @UiField
    MaterialButton saveChangesButton, deleteTaskButton, cancelButton, addTaskButton, searchButton;

    @UiField
    MaterialTextBox searchTask, renameTask, changeDescriptionTask, changePriorityTask, changeProgressTask;

    @Inject
    TasksView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    private MaterialCard createCard(TasksDTO task) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_2);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();

        cardTitle.add(new Anchor(task.getName(), "#workbook"));

        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label = new MaterialLabel();
        label.setText(task.getName());

        cardContent.add(cardTitle);
        cardContent.add(label);

        card.add(cardContent);

        card.addClickHandler(e -> {
            TasksServiceAsync tasksSvc = GWT.create(TasksService.class);

            // Set up the callback object.
            AsyncCallback<TasksDTO> callback = new AsyncCallback<TasksDTO>() {
                public void onFailure(Throwable caught) {

                }

                public void onSuccess(TasksDTO result) {
                    MaterialToast.fireToast(result.getName());
                    renameTask.setText(result.getName());
                    changeDescriptionTask.setText(result.getDescription());
                    changePriorityTask.setText(Integer.toString(result.getPriorityLevel()));
                    changeProgressTask.setText(Integer.toString(result.getProgress()));
                    openOptionModal();

                    tasksDTO = result;
                }
            };

            tasksSvc.findByName(task.getName(), callback);
        });

        return card;
    }

    @Override
    public String search() {
        return this.searchTask.getText();
    }

    @Override
    public String rename() {
        return this.renameTask.getText();
    }

    @Override
    public String changeDescription() {
        return this.changeDescriptionTask.getText();
    }

    @Override
    public int changePriority() {
        return Integer.parseInt(this.changePriorityTask.getText());
    }

    @Override
    public int changeProgress() {
        return Integer.parseInt(this.changeProgressTask.getText());
    }

    @Override
    public void openOptionModal() {
        this.optionModal.open();
    }

    @Override
    public void closeOptionModal() {
        this.optionModal.close();
    }

    @Override
    public void saveChangesClickHandler(ClickHandler ch) {
        this.saveChangesButton.addClickHandler(ch);
    }

    @Override
    public void deleteClickHandler(ClickHandler ch) {
        this.deleteTaskButton.addClickHandler(ch);
    }

    @Override
    public void cancelClickHandler(ClickHandler ch) {
        this.cancelButton.addClickHandler(ch);
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        this.addTaskButton.addClickHandler(ch);
    }

    @Override
    public void searchClickHandler(ClickHandler ch) {
        this.searchButton.addClickHandler(ch);
    }
}
