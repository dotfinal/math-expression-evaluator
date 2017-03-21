package evaluators;

import java.util.List;

abstract class AbstractMathExpressionEvaluator implements MathExpressionEvaluator {

    protected List<String> constraintRegexps;

    public List<String> getConstraintRegexps() {
        return constraintRegexps;
    }

    public void setConstraintRegexps(List<String> constraintRegexps) {
        this.constraintRegexps = constraintRegexps;
    }


}
