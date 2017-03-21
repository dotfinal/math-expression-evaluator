import evaluators.MathExpressionEvaluator;
import exceptions.InvalidFormatException;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractMathExpressionEvaluatorTest {
    
    MathExpressionEvaluator mathExpressionEvaluator;

    @Test
    public void testRegularCase() throws Exception{
        assertTrue(mathExpressionEvaluator.evaluate(
                "1*12/3*7+8/4*9/3-9*16/2/4/2*5/3") == 19);
    }

    @Test
    public void testRegularCaseWithExtraSpaces() throws Exception{
        assertTrue(mathExpressionEvaluator.evaluate(
                "     1*12/3*7 + 8/4*9   /3 - 9*16   /2/4  /2*5/3") == 19);
    }

    @Test
    public void testRegularCaseWithFloat() throws Exception{
        assertTrue(mathExpressionEvaluator.evaluate(
                "1.1*100+890.000") == 1000);
    }

    @Test
    public void testEmptyLine() throws Exception{
        assertTrue(mathExpressionEvaluator.evaluate(""    ) == 0);
    }

    @Test
    public void testDivideByZero() throws Exception{
        assertTrue(mathExpressionEvaluator.evaluate("1/0").isInfinite());
    }


    @Test(expected = InvalidFormatException.class)
    public void testUnacceptableDoubleFormat() throws Exception{
        mathExpressionEvaluator.evaluate("1+.234");
    }

    @Test(expected = InvalidFormatException.class)
    public void testUnacceptableCharacter() throws Exception{
        mathExpressionEvaluator.evaluate("(1+2)");
    }

    @Test(expected = InvalidFormatException.class)
    public void testTwoOperatorsBesideFormat() throws Exception{
        mathExpressionEvaluator.evaluate("1+  +2");
    }

    @Test(expected = InvalidFormatException.class)
    public void testTwoNumbersBesideFormat() throws Exception{
        mathExpressionEvaluator.evaluate("1+2 3");
    }

    @Test(expected = InvalidFormatException.class)
    public void testUnaryMinus() throws Exception{
        mathExpressionEvaluator.evaluate("-5+5");
    }

    @Test(expected = InvalidFormatException.class)
    public void testWithNumberMissed() throws Exception{
        mathExpressionEvaluator.evaluate("1/");
    }
}