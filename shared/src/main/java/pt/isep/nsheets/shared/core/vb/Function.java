package pt.isep.nsheets.shared.core.vb;

public class Function {

    private String functionName;
    private String functionBody;

    public Function(String functionName, String functionBody) {
        this.functionName = functionName;
        this.functionBody = functionBody;
    }

    public String getFunction() {
        return "Function " + functionName + "() As\n" + functionBody + "\nEnd Function";
    }
}
