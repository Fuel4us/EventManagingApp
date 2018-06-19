/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.tasks;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(TasksPresenter.class, TasksPresenter.MyView.class, TasksView.class, TasksPresenter.MyProxy.class);
    }

}
