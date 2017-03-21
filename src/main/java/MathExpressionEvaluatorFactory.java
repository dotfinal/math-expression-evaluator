import evaluators.JSEngineMathExpressionEvaluator;
import evaluators.ManualMathExpressionEvaluator;
import evaluators.MathExpressionEvaluator;
import operators.Operator;

import java.util.List;

public class MathExpressionEvaluatorFactory {
    public static MathExpressionEvaluator createManualEvaluator(List<String> constraintRegexps,
                                                                List<Operator> operators)
    {
        ManualMathExpressionEvaluator mathExpressionEvaluator = ManualMathExpressionEvaluator.getInstance();
        mathExpressionEvaluator.setOperators(operators);
        mathExpressionEvaluator.setConstraintRegexps(constraintRegexps);
        return mathExpressionEvaluator;
    }

    public static JSEngineMathExpressionEvaluator createJSEvaluator(List<String> constraintRegexps,
                                                                    String possibleOperators)
    {
        JSEngineMathExpressionEvaluator mathExpressionEvaluator = JSEngineMathExpressionEvaluator.getInstance();
        mathExpressionEvaluator.setConstraintRegexps(constraintRegexps);
        mathExpressionEvaluator.setPossibleOperators(possibleOperators);
        return mathExpressionEvaluator;
    }
}
