package prs;


import static org.junit.Assert.assertSame;

import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void EmptyString(){
        assertSame(0, StringCalculator.add(""));
    }
    @Test
    public void SingleValuedString(){
        assertSame(2, StringCalculator.add("2"));
    }
}
