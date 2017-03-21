package evaluators;

import exceptions.InvalidFormatException;
import operators.Operator;
import utils.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualMathExpressionEvaluator extends AbstractMathExpressionEvaluator {

    private static ManualMathExpressionEvaluator instance = new ManualMathExpressionEvaluator();

    public static ManualMathExpressionEvaluator getInstance() {
        return instance;
    }

    private ManualMathExpressionEvaluator() {
    }

    private static final String SPLIT_REGEXP = "(?=[/*+-])|(?<=[/*+-])";

    private List<Operator> operators = new ArrayList<>();

    public Double evaluate(String line) throws InvalidFormatException
    {
        if (line == null || line.trim().isEmpty())
            return 0d;
        ValidationUtil.checkLine(line, operators, constraintRegexps);
        List<Object> list = splitIntoPartsAndReturnList(line);
        List<Operator> operatorsToApply = new ArrayList<>(operators);
        operatorsToApply.sort((x, y) -> x.getPriority() - y.getPriority());
        while (!operatorsToApply.isEmpty())
        {
            int currentPriority = operatorsToApply.get(0).getPriority();
            List<Operator> operators = operatorsToApply.stream().
                    filter(x -> x.getPriority() == currentPriority)
                    .collect(Collectors.toList());
            processAllOccurrencesOfOperators(list, operators);
            operatorsToApply.removeAll(operators);
        }
        return (Double) list.get(0);
    }

    private static List<Object> splitIntoPartsAndReturnList(String line)
    {
        List<Object> list = new ArrayList<>();
        String parts[] = line.split(SPLIT_REGEXP);
        for (String part : parts) {
            try {
                list.add(Double.parseDouble(part));
            } catch (NumberFormatException e) {
                list.add(part);
            }
        }
        return list;
    }

    private static void processAllOccurrencesOfOperators(List<Object> list, List<Operator> operators)
            throws InvalidFormatException
    {
        for (int i = 0; i < list.size(); i++) {
            for (Operator operator : operators) {
                if (list.get(i) instanceof String && list.get(i).equals(operator.getOperator())) {
                    Double a = (Double) list.get(i - 1);
                    Double b = (Double) list.get(i + 1);
                    Double result = (Double) operator.getFunction().apply(a, b);
                    list.remove(i + 1);
                    list.remove(i);
                    list.remove(i - 1);
                    list.add(--i, result);
                }
            }
        }
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

}
