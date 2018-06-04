package pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629;

import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.UIExtension;

public class ValueColorExtension extends Extension {


    /**
     * Creates a new extensions.
     *
     * @param name the name of the extensions
     */
    public ValueColorExtension(String name) {
        super(name);
    }

    public static Configuration getConfig() {
        return config;
    }

    public static void setConfig(Configuration config) {
        ValueColorExtension.config=config;
    }

    public static Configuration config = new Configuration();

    @Override
    public UIExtension getUIExtension(MaterialWidget element) {
        return new CellDecorator(element);
    }

    class CellDecorator extends UIExtension{
        MaterialWidget element;

        CellDecorator(MaterialWidget element){
            this.element=element;
        }

        @Override
        public void decorate(Object o) {
            Cell cell = (Cell) o;

            if(cell.getValue().isOfType(Value.Type.NUMERIC)){
                try {
                    Number number = cell.getValue().toNumber();
                    if(number.intValue()>=0){
                        element.setBackgroundColor(Color.values()[config.getBgColorPos()]);
                        element.setTextColor(Color.values()[config.getFgColorPos()]);
                    } else {
                        element.setBackgroundColor(Color.values()[config.getBgColorNeg()]);
                        element.setTextColor(Color.values()[config.getFgColorNeg()]);
                    }
                } catch (IllegalValueTypeException e) {
                }
            }
        }
    }
}
