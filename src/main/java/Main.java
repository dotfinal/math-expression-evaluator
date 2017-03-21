import evaluators.MathExpressionEvaluator;
import exceptions.InvalidFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MathExpressionEvaluator mathExpressionEvaluator = getManualEvaluator();

        try {
            System.out.println(mathExpressionEvaluator.evaluate(reader.readLine()));
        }
        catch (InvalidFormatException e)
        {
            System.err.println("ERROR: Invalid format of the line.");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("ERROR: An argument is required.");
        }
    }

    private static MathExpressionEvaluator getManualEvaluator()
    {
        return MathExpressionEvaluatorFactory
                .createManualEvaluator(TaskData.getConstraintRegexps(), TaskData.getOperators());
    }

    private static MathExpressionEvaluator getJSEvaluator()
    {
        return MathExpressionEvaluatorFactory
                .createJSEvaluator(TaskData.getConstraintRegexps(), TaskData.getPossibleOperators());
    }
}
