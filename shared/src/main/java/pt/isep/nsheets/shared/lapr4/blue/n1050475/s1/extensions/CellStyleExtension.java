package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions;

import gwt.material.design.client.base.MaterialWidget;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.UIExtension;
import gwt.material.design.client.constants.Color;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;

public class CellStyleExtension extends Extension {


    /**
     * Creates a new extensions.
     *
     * @param name the name of the extensions
     */
    public CellStyleExtension(String name) {
        super(name);
    }

    public static Configuration getConfig() {
        return config;
    }

    public static void setConfig(Configuration config) {
        CellStyleExtension.config=config;
    }

    public static Configuration config = new Configuration();
    public static boolean result;

    public static void setResult(boolean result){ };

    @Override
    public UIExtension getUIExtension(MaterialWidget element) {
        return new CellDecorator(element, result, config);
    }

    class CellDecorator extends UIExtension{
        MaterialWidget element;
        private boolean conditionResult;
        Configuration configuration;

        CellDecorator(MaterialWidget element, boolean conditionResult, Configuration configuration){
            this.element=element;
            this.conditionResult = conditionResult;
            this.configuration = configuration;
        }


        @Override
        public void decorate(Object o) {

                    if(this.conditionResult){
                        element.setBackgroundColor(Color.values()[config.getBgColorPos()]);
                        element.setTextColor(Color.values()[config.getFgColorPos()]);
                    } else {
                        element.setBackgroundColor(Color.values()[config.getBgColorNeg()]);
                        element.setTextColor(Color.values()[config.getFgColorNeg()]);
                    }

            }
        }
    }
