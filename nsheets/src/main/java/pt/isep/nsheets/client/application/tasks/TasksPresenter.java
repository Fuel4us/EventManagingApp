/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.tasks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.shared.services.TasksDTO;
import pt.isep.nsheets.shared.services.TasksService;
import pt.isep.nsheets.shared.services.TasksServiceAsync;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksPresenter extends Presenter<TasksPresenter.MyView, TasksPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<TasksDTO> contents);

        String name();

        String description();

        String priority();

        String search();

        String rename();

        String changeDescription();

        int changePriority();

        int changeProgress();

        void openOptionModal();

        void closeOptionModal();

        void openNewTaskModal();

        void closeNewTaskModal();

        void saveChangesClickHandler(ClickHandler ch);

        void deleteClickHandler(ClickHandler ch);

        void cancelClickHandler(ClickHandler ch);

        void addClickHandler(ClickHandler ch);

        void searchClickHandler(ClickHandler ch);

        void saveClickHandler(ClickHandler ch);

        void cancel2ClickHandler(ClickHandler ch);

    }

    @NameToken(NameTokens.tasks)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TasksPresenter> {
    }

    @Inject
    TasksPresenter(EventBus eventBus, TasksPresenter.MyView view, TasksPresenter.MyProxy proxy, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.saveClickHandler(e -> {
            this.view.openNewTaskModal();
            TasksServiceAsync tasksAsync = GWT.create(TasksService.class);
            String userName = MenuView.getUsername().toString();
            //Set up the callback object.
            AsyncCallback<TasksDTO> callback = new AsyncCallback<TasksDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(TasksDTO result) {
                    MaterialToast.fireToast("New Task Created", "rounded");

                    refreshView();
                }
            };

            TasksDTO taskDTO = new TasksDTO(this.view.name(), this.view.description(), Integer.parseInt(this.view.priority()), 0, false);
            tasksAsync.addTask(taskDTO, callback);

            this.view.closeNewTaskModal();
        });
        
       
    }

    private void refreshView() {
        TasksServiceAsync tasksAsync = GWT.create(TasksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<TasksDTO>> callback = new AsyncCallback<ArrayList<TasksDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO: Do something with errors.
            }

            @Override
            public void onSuccess(ArrayList<TasksDTO> result) {
                view.setContents(result);
            }
        };

        tasksAsync.listTasksNotCompleted(MenuView.getUsername().toString(), callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Tasks", "Manage your Tasks", "", "", this);
        refreshView();
        timer();
    }

    private void timer() {
        // Create a new timer
        Timer t = new Timer() {
            @Override
            public void run() {
            }
        };

        // Schedule the timer to run once in 1 second.
        t.scheduleRepeating(1000);
    }
}
