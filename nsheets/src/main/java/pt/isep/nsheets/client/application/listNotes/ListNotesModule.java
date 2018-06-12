/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.listNotes;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * @author Tiago Correia
 */
public class ListNotesModule extends AbstractPresenterModule{
    
    @Override
    protected void configure() {
        bindPresenter(ListNotesPresenter.class, ListNotesPresenter.MyView.class, ListNotesView.class, ListNotesPresenter.MyProxy.class);
    }
}
