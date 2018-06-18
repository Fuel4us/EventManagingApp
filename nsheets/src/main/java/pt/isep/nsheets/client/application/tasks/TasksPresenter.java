/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.tasks;

import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.security.CurrentUser;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksPresenter extends Presenter<TasksPresenter.MyView, TasksPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

    }

    @NameToken(NameTokens.tasks)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TasksPresenter> {
    }
    
    @Inject
    TasksPresenter(EventBus eventBus, TasksPresenter.MyView view, TasksPresenter.MyProxy proxy, CurrentUser currentUser){
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        
        this.view = view;
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Tasks", "Make your Tasks", "", "", this);

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
