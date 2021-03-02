package prs;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class StringCalculatorTest {
    @Test
    @Order(1)
    public void EmptyString() throws Exception {
        assertSame(0, StringCalculator.add(""));
    }
    @Test
    @Order(2)
    public void SingleValuedString() throws Exception {
        assertSame(2, StringCalculator.add("2"));
    }
    @Test
    @Order(3)
    public void TwoNumberedString() throws Exception {
        assertSame(4,StringCalculator.add("1,3"));
    }
    @Test
    @Order(4)
    public void MultiValuedString() throws Exception {
        assertSame(7, StringCalculator.add("1,2,4"));
    }
    @Test
    @Order(5)
    public void NewLineBetweenNumbers() throws Exception {
        assertSame(11, StringCalculator.add("2\n6,3"));
    }
    @Test
    @Order(6)
    public void DifferentDelimiters() throws Exception {
        assertSame(14, StringCalculator.add("//;\n10;4"));
    }
    @Test
    @Order(7)
    public void NegativeNumberException(){
        Exception ex=assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("-3"));
        assertEquals("negatives not allowed : -3", ex.getMessage());
    }
    @Test
    @Order(8)
    public void MulitpleNegativeNumberException(){
        Exception ex=assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("-3,5,-4"));
        assertEquals("negatives not allowed : -3,-4", ex.getMessage());
    }
    @Test
    @Order(100)
    public void TestGetCalledCount(){
        assertSame(8, StringCalculator.getCalledCount());
    }
}
