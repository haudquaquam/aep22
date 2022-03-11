package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReverseTest {
    @Test
    public void emptyStringReversedShouldBeEmptyString() {
        String empty = "";
        Reverse reverser = new Reverse(empty);
        assertEquals(empty, reverser.result());
    }

    @Test
    public void oneCharacterStringReversedShouldBeSame() {
        String oneChar = "h";
        Reverse reverser = new Reverse(oneChar);
        assertEquals(oneChar, reverser.result());
    }

    @Test
    public void reverseHelloTest() {
        String hello = "hello";
        Reverse reverser = new Reverse(hello);
        assertEquals("olleh", reverser.result());
    }
}
