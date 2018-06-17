package pt.isep.nsheets.client.application.profile;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ProfileModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ProfilePresenter.class, ProfilePresenter.MyView.class, ProfileView.class, ProfilePresenter.MyProxy.class);
    }
}
