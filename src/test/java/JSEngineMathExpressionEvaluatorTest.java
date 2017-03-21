import evaluators.JSEngineMathExpressionEvaluator;
import evaluators.ManualMathExpressionEvaluator;
import org.junit.Before;

public class JSEngineMathExpressionEvaluatorTest extends AbstractMathExpressionEvaluatorTest {
    @Before
    public void setUp() throws Exception {
        mathExpressionEvaluator = MathExpressionEvaluatorFactory
                .createJSEvaluator(TaskData.getConstraintRegexps(), TaskData.getPossibleOperators());
    }
}
