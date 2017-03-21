package evaluators;

import exceptions.InvalidFormatException;
import utils.ValidationUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSEngineMathExpressionEvaluator extends AbstractMathExpressionEvaluator{

    private static JSEngineMathExpressionEvaluator instance = new JSEngineMathExpressionEvaluator();

    public static JSEngineMathExpressionEvaluator getInstance() {
        return instance;
    }

    private JSEngineMathExpressionEvaluator() {
    }

    private String possibleOperators;

    public Double evaluate(String line) throws InvalidFormatException {
        if (line == null || line.isEmpty())
            return 0d;
        checkLine(line);
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            return Double.valueOf(engine.eval(line).toString());
        }
        catch (ScriptException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void checkLine(String line) throws InvalidFormatException
    {
        ValidationUtil.checkLine(line, possibleOperators, constraintRegexps);
    }

    public String getPossibleOperators() {
        return possibleOperators;
    }

    public void setPossibleOperators(String possibleOperators) {
        this.possibleOperators = possibleOperators;
    }
}
