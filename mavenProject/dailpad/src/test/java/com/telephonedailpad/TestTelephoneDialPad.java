package com.telephonedailpad;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestTelephoneDialPad {
    TelephoneDialPad telephoneDialPad;
    
    //To create telephoneDialPad object
    @BeforeEach
    void setUp()
    {
        telephoneDialPad = new TelephoneDialPad();
    }

    //a parameterised test to check alphabet combinations for different inputs
    @ParameterizedTest
    @DisplayName("Verification if Alphabetic combinations are as expected")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1, encoding = "UTF-8" )
    public void testAlphabeticCombinations(String Input, String ExpectedOutput)
    {
        java.util.LinkedList<String> expectedOp = new java.util.LinkedList<String>(Arrays.asList(ExpectedOutput.split(" ")));
        java.util.LinkedList<String> actualOp = TelephoneDialPad.retrieveCombinations(Input);
        assertLinesMatch(expectedOp, actualOp);
    }

    //To test if the code return lower case letters
    @Test
    @DisplayName("Verification if code returns lower case alphabets")
    public void testLowerCase()
    {
        java.util.LinkedList<String> expectedOp = new java.util.LinkedList<String>();
        expectedOp.add("a");
        expectedOp.add("b");
        expectedOp.add("c");
        java.util.LinkedList<String> actualOp = TelephoneDialPad.retrieveCombinations("2");
        assertFalse("the code only return upper case alphabets", expectedOp.equals(actualOp));
    }

    //To test exception and message when the input is anything but an integer
    @Test
    @DisplayName("Exception testing: when anything other than number is passed as input")
    public void exceptionTesting()
    {
        Throwable exception = assertThrows(NumberFormatException.class, () -> TelephoneDialPad.retrieveCombinations("*"));
        assertTrue(exception.getMessage().contains("For input string: "));
        
    }

    
}


