package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupModule extends AbstractPresenterModule {
    
    @Override
    protected void configure() {
        bindPresenter(SignupPresenter.class, SignupPresenter.MyView.class, SignupView.class, SignupPresenter.MyProxy.class);
    }
}
