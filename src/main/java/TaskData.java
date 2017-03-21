import operators.Operator;

import java.util.Arrays;
import java.util.List;

public class TaskData {
    private static List<String> constraintRegexps = Arrays.asList(
            "^[%all.].*",
            ".*[%all.]$",
            ".*[%all.]\\s*[%all.].*",
            ".*\\d\\s{1,}\\d.*",
            ".*[^0-9*/+-. ].*",
            ".*\\D\\..*");

    private static List<Operator> operators = Arrays.asList(
            new Operator<Double>("*", 4, (a, b) -> (a * b)),
            new Operator<Double>("/", 4,(a, b) -> (a / b)),
            new Operator<Double>("+", 5,(a, b) -> (a + b)),
            new Operator<Double>("-", 5,(a, b) -> (a - b)));

    private static String possibleOperators = "*/+-";

    public static List<String> getConstraintRegexps() {
        return constraintRegexps;
    }

    public static List<Operator> getOperators() {
        return operators;
    }

    public static String getPossibleOperators() {
        return possibleOperators;
    }
}
