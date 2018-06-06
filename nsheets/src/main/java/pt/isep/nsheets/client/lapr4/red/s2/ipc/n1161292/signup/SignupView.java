package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import javax.inject.Inject;
import pt.isep.nsheets.client.event.SetPageTitleEvent;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupView extends ViewImpl implements SignupPresenter.MyView {
    
    interface Binder extends UiBinder<Widget, SignupView> {
    }
    
    @Inject
    SignupView(SignupView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));		
    }
    
}
