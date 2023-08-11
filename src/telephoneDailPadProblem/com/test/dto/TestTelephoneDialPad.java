package telephoneDailPadProblem.com.test.dto;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestTelephoneDialPad {
    TelephoneDialPad telephoneDialPad;
    

    @BeforeEach
    void setUp()
    {
        telephoneDialPad = new TelephoneDialPad();
    }
    @ParameterizedTest
    @DisplayName("Verification if Alphabetic combinations are as expected")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1, encoding = "UTF-8" )
    public void testAlphabeticCombinationsWithoutZeroandOne(String Input, String ExpectedOutput)
    {
        java.util.LinkedList<String> expectedOp = new java.util.LinkedList<String>(Arrays.asList(ExpectedOutput.split(" ")));
        java.util.LinkedList<String> actualOp = TelephoneDialPad.retrieveCombinations(Input);
        assertLinesMatch(expectedOp, actualOp);
    }

    
}


