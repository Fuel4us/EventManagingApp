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

    public String getName() {
        return name;
    }

    private String name;

    private transient Language language;

    private String commandList;

    public Macro(String givenName) {
        this.validateName(givenName);
        this.language = LanguageManager.getInstance().getLanguage("MacroExcel");
        this.commandList = "";
    }

    private Long id;

    public Macro() {
    }

    private void validateName(String givenName) {

        if (givenName.isEmpty() || givenName.equals(null)) {
            this.name = MACRO_DEFAULTNAME;
        } else {
            this.name = givenName;
        }
    }

    public String name() {

        return this.name;
    }

    public void changeLanguage(Language lang) {

        if (!this.language.equals(lang)) {
            this.language = lang;
        }

    }

    public Language language() {

        return this.language;
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

        return this.name() + " - " + this.language().getName() + " language";
    }
}
