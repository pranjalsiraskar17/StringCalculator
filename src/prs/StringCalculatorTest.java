package prs;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void EmptyString() throws Exception {
        assertSame(0, StringCalculator.add(""));
    }
    @Test
    public void SingleValuedString() throws Exception {
        assertSame(2, StringCalculator.add("2"));
    }
    @Test
    public void TwoNumberedString() throws Exception {
        assertSame(4,StringCalculator.add("1,3"));
    }
    @Test
    public void MultiValuedString() throws Exception {
        assertSame(7, StringCalculator.add("1,2,4"));
    }
    @Test
    public void NewLineBetweenNumbers() throws Exception {
        assertSame(11, StringCalculator.add("2\n6,3"));
    }
    @Test
    public void DifferentDelimiters() throws Exception {
        assertSame(14, StringCalculator.add("//;\n10;4"));
    }
    @Test
    public void NegativeNumberException(){
        Exception ex=assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("-3"));
        assertSame("negatives not allowed : -3", ex.getMessage());
    }
    @Test
    public void MulitpleNegativeNumberException(){
        Exception ex=assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("-3,5,-4"));
        assertSame("negatives not allowed : -3,-4", ex.getMessage());
    }
}
