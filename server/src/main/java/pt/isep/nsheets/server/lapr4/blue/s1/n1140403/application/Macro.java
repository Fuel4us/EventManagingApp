/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s1.n1140403.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.parser.ExpressionVisitor;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Formula;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompiler;

/**
 *
 * @author i140403
 */
public class Macro implements Serializable{
    
    public String name;
    private String code;
    private List<Formula> list_formulas;  
    private final Spreadsheet workbook;
    
    
    public Macro(Spreadsheet workbook) {
        this.name = "";
        this.workbook = workbook;
    }

    /**
     * Method that returns the name of a macro
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns the code of a macro
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method that returns the spreadsheet associated with the macro
     * @return 
     */
    public Spreadsheet getWorkbook() {
        return workbook;
    }   
    
    /**
     * Method that allows to change the name of a macro
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Method that allows to change the code of a macro
     */
    public void setCode(String code){
        this.code = code;
    }
    
    /**
     * Method that runs the code of the macro and returns the result of the last operation
     */
    public Value runCode() throws IllegalValueTypeException{
        Value result = null;
        
        for(Formula f : list_formulas){
            try {
                result = f.evaluate();
            } catch (IllegalValueTypeException ex) {
                //Logger.getLogger(Macro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return result;
    }
    
    /**
     * Method that ignores the comments and transforms all the instructions in 
     * the macro in a list of strings.
     */
    public void treatCode(String name) throws FormulaCompilationException{
        if(code.isEmpty() || name.isEmpty()){
            throw new NullPointerException("This macro has no code or name assigned.");
        }
        list_formulas = new ArrayList<>();
        String[] final_code = code.split(";");
        String[] auxiliar=name.split("[(]");
        auxiliar[1]=auxiliar[1].replace(")","");
        String [] parameters=auxiliar[1].split(",");
         
        for(String text : final_code){
            if(!text.startsWith(";")){
                Formula form = FormulaCompiler.getInstance().compile(this.workbook.getCell(1,3),"="+ text);
                if(form.getExpression()!=null){
                    list_formulas.add(form);
                }
            }
        }
    }
    
}

