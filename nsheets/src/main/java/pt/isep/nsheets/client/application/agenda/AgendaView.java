package pt.isep.nsheets.client.application.agenda;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaView extends ViewImpl implements AgendaPresenter.MyView {

    interface Binder extends UiBinder<AgendaView, Widget> {
    }

}
