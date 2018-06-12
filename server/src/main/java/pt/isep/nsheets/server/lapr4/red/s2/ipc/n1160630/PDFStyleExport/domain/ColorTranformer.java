/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain;

//import com.googlecode.gwt.charts.client.options.Color;

import gwt.material.design.client.constants.Color;


/**
 *
 * @author pedromonteiro
 */
public enum ColorTranformer {
    DEFAULT(""),
    BLACK("#000000"),
    WHITE("#FFFFFF"),
    TRANSPARENT(""),
    // Blue Grey
    BLUE_GREY_LIGHTEN_5("#ECEFF1"),
    BLUE_GREY_LIGHTEN_4("#CFD8DC"),
    BLUE_GREY_LIGHTEN_3("#B0BEC5"),
    BLUE_GREY_LIGHTEN_2("#90A4AE"),
    BLUE_GREY_LIGHTEN_1("#78909C"),
    BLUE_GREY("#607D8B"),
    BLUE_GREY_DARKEN_1("#546E7A"),
    BLUE_GREY_DARKEN_2("#455A64"),
    BLUE_GREY_DARKEN_3("#37474F"),
    BLUE_GREY_DARKEN_4("#263238"),
    // Grey
    GREY_LIGHTEN_5("#FAFAFA"),
    GREY_LIGHTEN_4("#F5F5F5"),
    GREY_LIGHTEN_3("#EEEEEE"),
    GREY_LIGHTEN_2("#E0E0E0"),
    GREY_LIGHTEN_1("#BDBDBD"),
    GREY("#9E9E9E"),
    GREY_DARKEN_1("#757575"),
    GREY_DARKEN_2("#616161"),
    GREY_DARKEN_3("#424242"),
    GREY_DARKEN_4("#212121"),
    // Brown
    BROWN_LIGHTEN_5("#EFEBE9"),
    BROWN_LIGHTEN_4("#D7CCC8"),
    BROWN_LIGHTEN_3("#BCAAA4"),
    BROWN_LIGHTEN_2("#A1887F"),
    BROWN_LIGHTEN_1("b#8D6E63"),
    BROWN("#795548"),
    BROWN_DARKEN_1("#6D4C41"),
    BROWN_DARKEN_2("#5D4037"),
    BROWN_DARKEN_3("#4E342E"),
    BROWN_DARKEN_4("#3E2723"),
    // Deep Orange
    DEEP_ORANGE_LIGHTEN_5("#FBE9E7"),
    DEEP_ORANGE_LIGHTEN_4("#FFCCBC"),
    DEEP_ORANGE_LIGHTEN_3("#FFAB91"),
    DEEP_ORANGE_LIGHTEN_2("#FF8A65"),
    DEEP_ORANGE_LIGHTEN_1("#FF7043"),
    DEEP_ORANGE("#FF5722"),
    DEEP_ORANGE_DARKEN_1("#F4511E"),
    DEEP_ORANGE_DARKEN_2("#E64A19"),
    DEEP_ORANGE_DARKEN_3("#D84315"),
    DEEP_ORANGE_DARKEN_4("#BF360C"),
    DEEP_ORANGE_ACCENT_1("#FF9E80"),
    DEEP_ORANGE_ACCENT_2("#FF6E40"),
    DEEP_ORANGE_ACCENT_3("#FF3D00"),
    DEEP_ORANGE_ACCENT_4("#DD2C00"),
    // Orange
    ORANGE_LIGHTEN_5("#FFF3E0"),
    ORANGE_LIGHTEN_4("#FFE0B2"),
    ORANGE_LIGHTEN_3("#FFCC80"),
    ORANGE_LIGHTEN_2("#FFB74D"),
    ORANGE_LIGHTEN_1("#FFA726"),
    ORANGE("#FF9800"),
    ORANGE_DARKEN_1("#FB8C00"),
    ORANGE_DARKEN_2("#F57C00"),
    ORANGE_DARKEN_3("#EF6C00"),
    ORANGE_DARKEN_4("#E65100"),
    ORANGE_ACCENT_1("#FFD180"),
    ORANGE_ACCENT_2("#FFAB40"),
    ORANGE_ACCENT_3("#FF9100"),
    ORANGE_ACCENT_4("#FF6D00"),
    // amber
    AMBER_LIGHTEN_5("#FFF8E1"),
    AMBER_LIGHTEN_4("#FFECB3"),
    AMBER_LIGHTEN_3("#FFE082"),
    AMBER_LIGHTEN_2("#FFD54F"),
    AMBER_LIGHTEN_1("#FFCA28"),
    AMBER("#FFC107"),
    AMBER_DARKEN_1("#FFB300"),
    AMBER_DARKEN_2("#FFA000"),
    AMBER_DARKEN_3("#FF8F00"),
    AMBER_DARKEN_4("#FF6F00"),
    AMBER_ACCENT_1("#FFE57F"),
    AMBER_ACCENT_2("#FFD740"),
    AMBER_ACCENT_3("#FFC400"),
    AMBER_ACCENT_4("#FFAB00"),
    // Yellow
    YELLOW_LIGHTEN_5("#FFFDE7"),
    YELLOW_LIGHTEN_4("##FFF9C4"),
    YELLOW_LIGHTEN_3("#FFF59D"),
    YELLOW_LIGHTEN_2("#FFF176"),
    YELLOW_LIGHTEN_1("#FFEE58"),
    YELLOW("FFEB3B"),
    YELLOW_DARKEN_1("#FDD835"),
    YELLOW_DARKEN_2("#FBC02D"),
    YELLOW_DARKEN_3("#F9A825"),
    YELLOW_DARKEN_4("#F57F17"),
    YELLOW_ACCENT_1("#FFFF8D"),
    YELLOW_ACCENT_2("#FFFF00"),
    YELLOW_ACCENT_3("#FFEA00"),
    YELLOW_ACCENT_4("#FFD600"),
    // Lime
    LIME_LIGHTEN_5("#F9FBE7"),
    LIME_LIGHTEN_4("#F0F4C3"),
    LIME_LIGHTEN_3("#E6EE9C"),
    LIME_LIGHTEN_2("#DCE775"),
    LIME_LIGHTEN_1("#D4E157"),
    LIME("#CDDC39"),
    LIME_DARKEN_1("#C0CA33"),
    LIME_DARKEN_2("#AFB42B"),
    LIME_DARKEN_3("#9E9D24"),
    LIME_DARKEN_4("#827717"),
    LIME_ACCENT_1("#F4FF81"),
    LIME_ACCENT_2("#EEFF41"),
    LIME_ACCENT_3("#C6FF00"),
    LIME_ACCENT_4("#AEEA00"),
    // Light Green
    LIGHT_GREEN_LIGHTEN_5("#F1F8E9"),
    LIGHT_GREEN_LIGHTEN_4("#DCEDC8"),
    LIGHT_GREEN_LIGHTEN_3("#C5E1A5"),
    LIGHT_GREEN_LIGHTEN_2("#AED581"),
    LIGHT_GREEN_LIGHTEN_1("#9CCC65"),
    LIGHT_GREEN("#8BC34A"),
    LIGHT_GREEN_DARKEN_1("#7CB342"),
    LIGHT_GREEN_DARKEN_2("#689F38"),
    LIGHT_GREEN_DARKEN_3("#558B2F"),
    LIGHT_GREEN_DARKEN_4("#33691E"),
    LIGHT_GREEN_ACCENT_1("#CCFF90"),
    LIGHT_GREEN_ACCENT_2("#B2FF59"),
    LIGHT_GREEN_ACCENT_3("#76FF03"),
    LIGHT_GREEN_ACCENT_4("#64DD17"),
    // Green
    GREEN_LIGHTEN_5("#E8F5E9"),
    GREEN_LIGHTEN_4("#C8E6C9"),
    GREEN_LIGHTEN_3("#A5D6A7"),
    GREEN_LIGHTEN_2("#81C784"),
    GREEN_LIGHTEN_1("#66BB6A"),
    GREEN("#4CAF50"),
    GREEN_DARKEN_1("#43A047"),
    GREEN_DARKEN_2("#388E3C"),
    GREEN_DARKEN_3("#2E7D32"),
    GREEN_DARKEN_4("#1B5E20"),
    GREEN_ACCENT_1("#B9F6CA"),
    GREEN_ACCENT_2("#69F0AE"),
    GREEN_ACCENT_3("#00E676"),
    GREEN_ACCENT_4("#00C853"),
    // Teal
    TEAL_LIGHTEN_5("#E0F2F1"),
    TEAL_LIGHTEN_4("#B2DFDB"),
    TEAL_LIGHTEN_3("#80CBC4"),
    TEAL_LIGHTEN_2("#4DB6AC"),
    TEAL_LIGHTEN_1("#26A69A"),
    TEAL("#009688"),
    TEAL_DARKEN_1("#00897B"),
    TEAL_DARKEN_2("#00796B"),
    TEAL_DARKEN_3("#00695C"),
    TEAL_DARKEN_4("#004D40"),
    TEAL_ACCENT_1("#A7FFEB"),
    TEAL_ACCENT_2("#64FFDA"),
    TEAL_ACCENT_3("#1DE9B6"),
    TEAL_ACCENT_4("#00BFA5"),
    // Cyan
    CYAN_LIGHTEN_5("#E0F7FA"),
    CYAN_LIGHTEN_4("#B2EBF2"),
    CYAN_LIGHTEN_3("#80DEEA"),
    CYAN_LIGHTEN_2("#4DD0E1"),
    CYAN_LIGHTEN_1("#26C6DA"),
    CYAN("#00BCD4"),
    CYAN_DARKEN_1("#00ACC1"),
    CYAN_DARKEN_2("#00ACC1"),
    CYAN_DARKEN_3("#00838F"),
    CYAN_DARKEN_4("#006064"),
    CYAN_ACCENT_1("#84FFFF"),
    CYAN_ACCENT_2("#18FFFF"),
    CYAN_ACCENT_3("#00E5FF"),
    CYAN_ACCENT_4("#00B8D4"),
    // Light Blue
    LIGHT_BLUE_LIGHTEN_5("#E1F5FE"),
    LIGHT_BLUE_LIGHTEN_4("#B3E5FC"),
    LIGHT_BLUE_LIGHTEN_3("#81D4FA"),
    LIGHT_BLUE_LIGHTEN_2("#4FC3F7"),
    LIGHT_BLUE_LIGHTEN_1("#29B6F6"),
    LIGHT_BLUE("#03A9F4"),
    LIGHT_BLUE_DARKEN_1("#039BE5"),
    LIGHT_BLUE_DARKEN_2("#0288D1"),
    LIGHT_BLUE_DARKEN_3("#0277BD"),
    LIGHT_BLUE_DARKEN_4("#01579B"),
    LIGHT_BLUE_ACCENT_1("#80D8FF"),
    LIGHT_BLUE_ACCENT_2("#40C4FF"),
    LIGHT_BLUE_ACCENT_3("#00B0FF"),
    LIGHT_BLUE_ACCENT_4("#0091EA"),
    // Blue
    BLUE_LIGHTEN_5("#E3F2FD"),
    BLUE_LIGHTEN_4("#BBDEFB"),
    BLUE_LIGHTEN_3("#90CAF9"),
    BLUE_LIGHTEN_2("#64B5F6"),
    BLUE_LIGHTEN_1("#42A5F5"),
    BLUE("#2196F3"),
    BLUE_DARKEN_1("#1E88E5"),
    BLUE_DARKEN_2("#1976D2"),
    BLUE_DARKEN_3("#1565C0"),
    BLUE_DARKEN_4("#0D47A1"),
    BLUE_ACCENT_1("#82B1FF"),
    BLUE_ACCENT_2("#448AFF"),
    BLUE_ACCENT_3("#2979FF"),
    BLUE_ACCENT_4("#2962FF"),
    // Indigo
    INDIGO_LIGHTEN_5("#E8EAF6"),
    INDIGO_LIGHTEN_4("#C5CAE9"),
    INDIGO_LIGHTEN_3("#9FA8DA"),
    INDIGO_LIGHTEN_2("#7986CB"),
    INDIGO_LIGHTEN_1("#5C6BC0"),
    INDIGO("#3F51B5"),
    INDIGO_DARKEN_1("#3949AB"),
    INDIGO_DARKEN_2("#303F9F"),
    INDIGO_DARKEN_3("#283593"),
    INDIGO_DARKEN_4("#1A237E"),
    INDIGO_ACCENT_1("#8C9EFF"),
    INDIGO_ACCENT_2("#536DFE"),
    INDIGO_ACCENT_3("#3D5AFE"),
    INDIGO_ACCENT_4("#304FFE"),
    // Deep Purple
    PURPLE_LIGHTEN_5("#EDE7F6"),
    PURPLE_LIGHTEN_4("#D1C4E9"),
    PURPLE_LIGHTEN_3("#B39DDB"),
    PURPLE_LIGHTEN_2("#9575CD"),
    PURPLE_LIGHTEN_1("#7E57C2"),
    PURPLE("#673AB7"),
    PURPLE_DARKEN_1("#5E35B1"),
    PURPLE_DARKEN_2("#512DA8"),
    PURPLE_DARKEN_3("#4527A0"),
    PURPLE_DARKEN_4("#311B92"),
    PURPLE_ACCENT_1("#B388FF"),
    PURPLE_ACCENT_2("#7C4DFF"),
    PURPLE_ACCENT_3("#651FFF"),
    PURPLE_ACCENT_4("#6200EA"),
    // Purple
    DEEP_PURPLE_LIGHTEN_5("#EDE7F6"),
    DEEP_PURPLE_LIGHTEN_4("#D1C4E9"),
    DEEP_PURPLE_LIGHTEN_3("#B39DDB"),
    DEEP_PURPLE_LIGHTEN_2("#9575CD"),
    DEEP_PURPLE_LIGHTEN_1("#7E57C2"),
    DEEP_PURPLE("#673AB7"),
    DEEP_PURPLE_DARKEN_1("#5E35B1"),
    DEEP_PURPLE_DARKEN_2("#512DA8"),
    DEEP_PURPLE_DARKEN_3("#4527A0"),
    DEEP_PURPLE_DARKEN_4("#311B92"),
    DEEP_PURPLE_ACCENT_1("#B388FF"),
    DEEP_PURPLE_ACCENT_2("#7C4DFF"),
    VPURPLE_ACCENT_3("#651FFF"),
    VPURPLE_ACCENT_4("#6200EA"),
    // Pink
    PINK_LIGHTEN_5("#FCE4EC"),
    PINK_LIGHTEN_4("#F8BBD0"),
    PINK_LIGHTEN_3("#F48FB1"),
    PINK_LIGHTEN_2("#F06292"),
    PINK_LIGHTEN_1("#EC407A"),
    PINK("#E91E63"),
    PINK_DARKEN_1("#D81B60"),
    PINK_DARKEN_2("#C2185B"),
    PINK_DARKEN_3("#AD1457"),
    PINK_DARKEN_4("#880E4F"),
    PINK_ACCENT_1("#FF80AB"),
    PINK_ACCENT_2("#FF4081"),
    PINK_ACCENT_3("#F50057"),
    PINK_ACCENT_4("#C51162"),
    // Red
    RED_LIGHTEN_5("#FFEBEE"),
    RED_LIGHTEN_4("#FFCDD2"),
    RED_LIGHTEN_3("#EF9A9A"),
    RED_LIGHTEN_2("#E57373"),
    RED_LIGHTEN_1("#EF5350"),
    RED("#F44336"),
    RED_DARKEN_1("#E53935"),
    RED_DARKEN_2("#D32F2F"),
    RED_DARKEN_3("#C62828"),
    RED_DARKEN_4("#B71C1C"),
    RED_ACCENT_1("#FF8A80"),
    RED_ACCENT_2("#FF5252"),
    RED_ACCENT_3("#FF1744"),
    RED_ACCENT_4("#D50000");
    
    
    
    private final String hexColor;

    ColorTranformer(final String hexColor) {
        this.hexColor = hexColor;
    }
    
    /**
     * Returns a string with hexadecimal code, giving a GWT color constant
     * @param color GWT Color
     * @return hexadecimal code
     */
    public static String getHexColorByGWTColor(Color color){
        
        for(ColorTranformer color_t:values()){
            if(color_t.name().equals(color.name()))
                return color_t.hexColor;
        }
        return null;
    }
    
    /**
     * Returns a string with hexadecimal code, giving a GWT color constant number
     * @param color GWT Color number
     * @return hexadecimal code
     */
    public static String getHexColorByGWTColor(int color){
        
        for(ColorTranformer color_t:values()){
            if(color_t.ordinal()==color)
                return color_t.hexColor;
        }
        
        return null;
    }
}
