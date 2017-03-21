package evaluators;

import exceptions.InvalidFormatException;

public interface MathExpressionEvaluator {
    Double evaluate(String line) throws InvalidFormatException;
}
