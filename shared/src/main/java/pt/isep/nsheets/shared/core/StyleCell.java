/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core;

import gwt.material.design.client.constants.Color;




/**
 *
 * @author pedromonteiro
 */
public class StyleCell {

    private Color back_color;
    private Color font_color;

    public StyleCell(Color back_color, Color font_color) {
        this.back_color = back_color;
        this.font_color = font_color;
    }

    public Color getBack_color() {
        return back_color;
    }

    public Color getFont_color() {
        return font_color;
    }

    public void setBack_color(Color back_color) {
        this.back_color = back_color;
    }

    public void setFont_color(Color font_color) {
        this.font_color = font_color;
    }
    
    
    
    
    
    
}
