/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lang;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryLanguage extends Language {

    public MonetaryLanguage(String name) {
        super(name);
    }

    @Override
    protected void initBinaryOperators() {
        binaryOperators.add(new Adder());
        binaryOperators.add(new Divider());
        binaryOperators.add(new Multiplier());
        binaryOperators.add(new Subtracter());
    }

}
