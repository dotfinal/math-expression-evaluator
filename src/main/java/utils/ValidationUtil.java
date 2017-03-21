package utils;

import exceptions.InvalidFormatException;
import operators.Operator;

import java.util.List;

public class ValidationUtil {

    private static final String ALL_POSSIBLE_OPERATORS_KEYWORD = "%all";

    public static void checkLine(String line, String possibleOperators, List<String> regexps)
            throws InvalidFormatException
    {
        for (String regexp : regexps)
        {
            if (regexp.contains(ALL_POSSIBLE_OPERATORS_KEYWORD))
                regexp = regexp.replaceAll(ALL_POSSIBLE_OPERATORS_KEYWORD, possibleOperators);
            if (line.matches(regexp))
                throw new InvalidFormatException();
        }
    }

    public static void checkLine(String line, List<Operator> operators,
                                 List<String> regexps)
            throws InvalidFormatException
    {
        StringBuilder possibleOperators = new StringBuilder();
        for (Operator operator : operators)
        {
            possibleOperators.append(operator.getOperator());
        }
        checkLine(line, possibleOperators.toString(), regexps);
    }
}
