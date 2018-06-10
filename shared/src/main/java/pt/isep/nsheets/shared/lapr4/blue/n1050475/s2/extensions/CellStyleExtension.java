package pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions;

import com.google.gwt.dom.client.Style;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.TextAlign;
import org.apache.xalan.xsltc.dom.AdaptiveResultTreeImpl;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.UIExtension;
import gwt.material.design.client.constants.Color;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CellStyleExtension extends Extension {

    public static ArrayList<CellStyle> lstCellStyle = new ArrayList<CellStyle>();

    /**
     * Creates a new extensions.
     *
     * @param name the name of the extensions
     */
    public CellStyleExtension(String name) {
        super(name);
    }

    public static CellStyle getCellStyle(Address address) {
        for(CellStyle c : lstCellStyle){
            if(c.getAddress().equals(address)){
                return c;
            }
        }
        return null;
    }

    public static void addCellStyle(CellStyle cellStyle){
        CellStyle c = CellStyleExtension.getCellStyle(cellStyle.getAddress());
        if(c != null){
            lstCellStyle.remove(c);
        }
        lstCellStyle.add(cellStyle);

    }

    public static boolean removeCellStyle(CellStyle cellStyle) {
        return lstCellStyle.remove(cellStyle);
    }

    @Override
    public UIExtension getUIExtension(MaterialWidget element) {
        return new CellDecorator(element);
    }

    class CellDecorator extends UIExtension {
        MaterialWidget element;

        CellDecorator(MaterialWidget element) {
            this.element = element;
        }


        @Override
        public void decorate(Object o) {
            CellStyle c = CellStyleExtension.getCellStyle((Address) o);
            if (c != null) {
                element.setBackgroundColor(Color.values()[c.getBackgroungColor()]);
                element.setTextColor(Color.values()[c.getFontColor()]);
                if(c.getTextALIGN() == -1){
                    element.setTextAlign(TextAlign.LEFT);
                }else if(c.getTextALIGN() == 1){
                    element.setTextAlign(TextAlign.RIGHT);
                }else{
                    element.setTextAlign(TextAlign.CENTER);
                }
                element.setFontSize(c.getFontSize(), Style.Unit.PX);
            }else{
                element.setBackgroundColor(Color.WHITE);
                element.setTextColor(Color.BLACK);
                element.setTextAlign(TextAlign.CENTER);
                element.setFontSize(12, Style.Unit.PX);
            }
        }
    }
}