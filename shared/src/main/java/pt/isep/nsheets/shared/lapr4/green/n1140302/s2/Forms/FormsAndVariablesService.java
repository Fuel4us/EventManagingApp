package pt.isep.nsheets.shared.lapr4.green.n1140302.s2.Forms;

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;

import java.util.ArrayList;
import java.util.List;

public class FormsAndVariablesService {

    private static List<TemporaryVariable> temporaryVariablesListText = new ArrayList<>();
    private static List<TemporaryVariable> temporaryVariablesListButton = new ArrayList<>();

    public String getTemporaryVariableValueByName(String name,int choice){
        Value value = new Value(name);
        if(choice==1) {
            for (TemporaryVariable var :
                    temporaryVariablesListButton) {

                try {
                    if (var.getName().toText().equalsIgnoreCase(value.toText())) {

                            return var.getValue().toText();
                    }
                } catch (IllegalValueTypeException e) {
                    e.printStackTrace();
                }
            }
        }else {
            for (TemporaryVariable tempVar:
                    temporaryVariablesListText) {

                try {
                    if(tempVar.getName().toText().equalsIgnoreCase(value.toText())){
                            return tempVar.getValue().toText();
                    }
                } catch (IllegalValueTypeException e) {
                    e.printStackTrace();
                }
            }
        }

        return "";
    }

    public void addTemporaryVariable(String name, String value, int choice){
        TemporaryVariable temporaryVariable = null;

            temporaryVariable = new TemporaryVariable(new Value(value),new Value(name));

            boolean flag = false;
            if(choice==1){
                for (TemporaryVariable var:
                     temporaryVariablesListButton) {
                    try {
                        if(var.getName().toText().equalsIgnoreCase(name)){
                            flag = true;
                        }
                    } catch (IllegalValueTypeException e) {
                        e.printStackTrace();
                    }
                }
                if (flag){
                    updateTemporaryVariable(temporaryVariable,choice);
                }else{
                    temporaryVariablesListButton.add(temporaryVariable);
                }
            }else {
                for (TemporaryVariable var :
                        temporaryVariablesListButton) {
                    try {
                        if (var.getName().toText().equalsIgnoreCase(name)) {
                            flag = true;
                        }
                    } catch (IllegalValueTypeException e) {
                        e.printStackTrace();
                    }
                }
                if (flag) {
                    updateTemporaryVariable(temporaryVariable, choice);
                } else {
                    temporaryVariablesListButton.add(temporaryVariable);
                }
            }
    }



    public void updateTemporaryVariable(TemporaryVariable temporaryVariable,int choice) {
        if (choice == 1) {
            for (TemporaryVariable tempVar :
                    temporaryVariablesListButton) {
                if (temporaryVariable.getName().equals(tempVar.getName())) {
                    temporaryVariablesListButton.remove(tempVar);
                    temporaryVariablesListButton.add(temporaryVariable);
                }
            }
        } else {
            for (TemporaryVariable var :
                    temporaryVariablesListButton) {
                if (temporaryVariable.getName().equals(var.getName())){
                    temporaryVariablesListText.remove(var);
                    temporaryVariablesListText.add(temporaryVariable);
                }
            }
        }
    }
}
