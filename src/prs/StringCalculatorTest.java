package prs;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void EmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }
}
