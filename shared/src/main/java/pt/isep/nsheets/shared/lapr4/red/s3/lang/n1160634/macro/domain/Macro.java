package pt.isep.nsheets.shared.lapr4.red.s3.lang.n1160634.macro.domain;

import java.io.Serializable;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;

/**
 *
 * @author Pedro Marques Vieira
 */
public class Macro implements Serializable {

    private static final String MACRO_DEFAULTNAME = "MACRO001";
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String name;

    private String commandList;

    public Macro(String givenName) {
        this.validateName(givenName);
        this.commandList = "";
    }

    public Macro() {
    }

    private void validateName(String givenName) {

        if (givenName.isEmpty() || givenName.equals(null)) {
            this.name = MACRO_DEFAULTNAME;
        } else {
            this.name = givenName;
        }
    }

    public String getName() {
        return name;
    }
    
    public String name() {

        return this.name;
    }

    public void addCommand(String command) {

        this.commandList = command;
    }

    public String commands() {

        return this.commandList;
    }

    public void resetMacro() {

        this.commandList = "";
    }

    @Override
    public String toString() {

        return this.name() + " - " + " macro function";
    }
}
