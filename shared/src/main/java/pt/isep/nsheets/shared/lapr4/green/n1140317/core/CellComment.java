/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1140317.core;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.lapr4.green.n1140317.services.CellCommentDTO;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class CellComment implements /*AggregateRoot<Long>,*/ Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @OneToOne
    Address address;
    private String txtComment;

    public CellComment() {

    }

    public CellComment(Address address) {
        this.address = address;
        this.txtComment = "No Comment";
    }

    public CellComment(Address address, String[] values) {
        this.address = address;
        try {
            this.txtComment = values[0];

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public CellComment(Address address, String v1) {
        this.address = address;
        try {
            this.txtComment = v1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public String getTxtComment() {
        return txtComment;
    }

    public void setTxtComment(String txtComment) {
        this.txtComment = txtComment;
    }

    public Address getAddress() {
        return this.address;
    }

    public CellCommentDTO toDTO() {
        String[] values = new String[1];
        values[0] = txtComment;

        return new CellCommentDTO(this.address.toDTO(), values);
    }

    public static CellComment fromDTO(CellCommentDTO dto) {
        String[] values = new String[1];
        values[0] = dto.txtComment;
        return new CellComment(Address.fromDTO(dto.address), values);
    }

    public boolean sameAs(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CellComment other = (CellComment) obj;
        if (!this.address.equals(other.getAddress())) {
            return false;
        }

        return true;
    }


    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }


    public Long id() {
        return this.pk;
    }
}
