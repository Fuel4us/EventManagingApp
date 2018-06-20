package pt.isep.nsheets.shared.core.vb;

import java.util.HashMap;
import java.util.Map;

public class Function {

    private String functionName;
    private String functionBody;
    private Map<String, Value> parameters;

    public Function(String functionName, String functionBody) {
        this.functionName = functionName;
        this.functionBody = functionBody;
        parameters = new HashMap<>();
    }

    public String getFunction() {
        return "Function " + functionName + "() As\n" + functionBody + "\nEnd Function";
    }

    public void addParameter(String parameterName, Value parameterValue) {
        parameters.put(parameterName, parameterValue);
    }
}
