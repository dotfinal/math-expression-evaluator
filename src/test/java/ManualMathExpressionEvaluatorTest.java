import evaluators.ManualMathExpressionEvaluator;
import org.junit.Before;

public class ManualMathExpressionEvaluatorTest extends AbstractMathExpressionEvaluatorTest {
    @Before
    public void setUp() throws Exception {
        mathExpressionEvaluator = MathExpressionEvaluatorFactory
                .createManualEvaluator(TaskData.getConstraintRegexps(), TaskData.getOperators());
    }
}
