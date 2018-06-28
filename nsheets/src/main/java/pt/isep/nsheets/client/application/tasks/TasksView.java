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
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
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
    MaterialModal optionModal, newTaskModal;
    
    @UiField
    MaterialButton saveChangesButton, deleteTaskButton, cancelButton, addTaskButton, searchButton, saveButton, cancel2Button;
    
    @UiField
    MaterialTextBox searchTask, renameTask, changeDescriptionTask, changePriorityTask, changeProgressTask, nameTask, descriptionTask, priorityTask;
    
    @Inject
    TasksView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    private MaterialCard createCard(TasksDTO taskDTO) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_2);
        
        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);
        
        MaterialCardTitle cardTitle = new MaterialCardTitle();
        
        cardTitle.add(new Anchor(taskDTO.name, "#tasks"));
        
        cardTitle.setIconType(IconType.SETTINGS);
        cardTitle.setIconPosition(IconPosition.RIGHT);
        
        MaterialLabel label = new MaterialLabel();
        MaterialLabel label2 = new MaterialLabel();
        MaterialLabel label3 = new MaterialLabel();
        label.setText("Description: " + taskDTO.description);
        label2.setText("Priority: " + taskDTO.priorityLevel);
        label3.setText("Progress: " + taskDTO.progress + "%");
        
        cardContent.add(cardTitle);
        cardContent.add(label);
        cardContent.add(label2);
        cardContent.add(label3);
        
        card.add(cardContent);
        
        card.addClickHandler(e -> {
            TasksServiceAsync tasksSvc = GWT.create(TasksService.class);

            // Set up the callback object.
            AsyncCallback<TasksDTO> callback = new AsyncCallback<TasksDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    
                }
                
                @Override
                public void onSuccess(TasksDTO result) {
                    MaterialToast.fireToast(result.name);
                    renameTask.setText(result.name);
                    changeDescriptionTask.setText(result.description);
                    changePriorityTask.setText(result.priorityLevel);
                    changeProgressTask.setText(result.progress);
                    
                    tasksDTO = result;
                }
            };
            
            tasksSvc.findByName(taskDTO.name, callback);
            openOptionModal();
        });
        
        return card;
    }
    
    @Override
    public void setContents(ArrayList<TasksDTO> contents) {
        int colCount = 1;
        
        MaterialRow row = null;
        
        htmlPanel.clear();
        renameTask.clear();
        changeDescriptionTask.clear();
        changePriorityTask.clear();
        changeProgressTask.clear();
        nameTask.clear();
        descriptionTask.clear();
        priorityTask.clear();
        
        for (TasksDTO tasksDTO : contents) {
            MaterialCard card = createCard(tasksDTO);
            
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
    public String changePriority() {
        return this.changePriorityTask.getText();
    }
    
    @Override
    public String changeProgress() {
        return this.changeProgressTask.getText();
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
    public void openNewTaskModal() {
        this.newTaskModal.open();
    }
    
    @Override
    public void closeNewTaskModal() {
        this.newTaskModal.close();
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
    
    @Override
    public String name() {
        return this.nameTask.getText();
    }
    
    @Override
    public String description() {
        return this.descriptionTask.getText();
    }
    
    @Override
    public String priority() {
        return this.priorityTask.getText();
    }
    
    @Override
    public void saveClickHandler(ClickHandler ch) {
        this.saveButton.addClickHandler(ch);
    }
    
    @Override
    public void cancel2ClickHandler(ClickHandler ch) {
        this.cancel2Button.addClickHandler(ch);
    }
    
    @Override
    public TasksDTO focusedTasksDTO() {
        return tasksDTO;
    }
}
