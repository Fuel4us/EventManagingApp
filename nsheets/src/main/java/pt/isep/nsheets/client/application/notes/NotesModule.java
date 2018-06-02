package pt.isep.nsheets.client.application.notes;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class NotesModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        
        bindPresenter(NotesPresenter.class, NotesPresenter.MyView.class, NotesView.class, NotesPresenter.MyProxy.class);
    }
}
