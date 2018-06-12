package pt.isep.nsheets.shared.lapr4.green.n1140302.s2.Forms;

public class FormsAndVariablesController {
    private FormsAndVariablesService service;

    public FormsAndVariablesController(){
        service= new FormsAndVariablesService();
    }

    public String getTemporaryVariableByName(String name,int choice){
        return this.service.getTemporaryVariableValueByName(name,choice);
    }

    public void addTemporaryVariable(String name, String value,int choice){
        this.service.addTemporaryVariable(name,value,choice);
    }
}
