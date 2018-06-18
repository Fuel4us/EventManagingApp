/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1140317.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public interface CellCommentServiceAsync {

    void getListCellStyle(AsyncCallback<ArrayList<CellCommentDTO>> async);

    void saveCellStyle(CellCommentDTO cellStyleDTO, AsyncCallback<CellCommentDTO> async);
}
