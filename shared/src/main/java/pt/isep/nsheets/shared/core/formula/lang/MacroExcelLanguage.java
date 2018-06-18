package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.formula.Function;

/**
 *
 * @author Pedro Marques Vieira
 */
public class MacroExcelLanguage extends MacroLanguage{
    
    public MacroExcelLanguage(String name, String starter) {
        super(name, starter);
    }
    
     @Override
    protected void initFunctions() {
        functions.add(new Average());
        functions.add(new And());
        functions.add(new Count());
        functions.add(new Do());
        functions.add(new Factorial());
        functions.add(new False());
        functions.add(new If());
        functions.add(new Not());
        //functions.add(new NumericFunction());
        functions.add(new Or());
        functions.add(new Sum());
        functions.add(new True());
        functions.add((Function) new MacroFunc());
    }

    @Override
    protected void initBinaryOperators() {
        binaryOperators.add(new Adder());
        binaryOperators.add(new Concatenator());
        binaryOperators.add(new Divider());
        binaryOperators.add(new Equal());
        binaryOperators.add(new Exponentiator());
        binaryOperators.add(new GreaterThan());
        binaryOperators.add(new GreaterThanOrEqual());
        binaryOperators.add(new LessThan());
        binaryOperators.add(new LessThanOrEqual());
        binaryOperators.add(new Multiplier());
        binaryOperators.add(new NotEqual());
        binaryOperators.add(new RangeReference());
        binaryOperators.add(new Subtracter());
        binaryOperators.add(new Attribution());
    }

    @Override
    protected void initUnaryOperators() {
        // functions.add(new Average());
        unaryOperators.add(new Negator());
        unaryOperators.add(new Percent());
    }
    


    @Override
    protected void initNaryOperators(){
        naryOperators.add(new Block());
     
    }
    

    @Override
    public String toString() {
    	return "MacroExcel";
    }
}
