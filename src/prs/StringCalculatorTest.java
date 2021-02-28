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
    @Test
    public void TwoNumberedString(){
        assertSame(4,StringCalculator.add("1,3"));
    }
    @Test
    public void MultiValuedString(){
        assertSame(7, StringCalculator.add("1,2,4"));
    }
    @Test
    public void NewLineBetweenNumbers(){
        assertSame(11, StringCalculator.add("2\n6,3"));
    }
}
