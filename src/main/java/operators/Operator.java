package operators;

import java.util.function.BiFunction;

public class Operator<T> {

    private String operator;

    private int priority;

    BiFunction<T, T, T> function;

    public Operator(String operator, int priority, BiFunction<T, T, T> function) {
        this.operator = operator;
        this.priority = priority;
        this.function = function;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public BiFunction<T, T, T> getFunction() {
        return function;
    }

    public void setFunction(BiFunction<T, T, T> function) {
        this.function = function;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
