package prs;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void EmptyString(){
        assertThat("", Calculator.add(""));
    }
}
