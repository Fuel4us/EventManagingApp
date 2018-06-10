/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain;

import java.awt.Color;

/**
 *
 * @author pedromonteiro
 */
public class ColorUtil {
    
    private final Color color;
    

    
    public ColorUtil(String hexcode) {
        color = Color.decode(hexcode);
       
    }

    public Color getColor() {
        return color;
    }
    
    
    
    
    
}
