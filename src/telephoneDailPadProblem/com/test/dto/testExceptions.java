package telephoneDailPadProblem.com.test.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class testExceptions {

    @Test
    @DisplayName("Exception testing: when anything other than number is passed as input")
    public void exceptionTesting()
    {
        Throwable exception = assertThrows(NumberFormatException.class, () -> TelephoneDialPad.retrieveCombinations("*"));
        assertTrue(exception.getMessage().contains("For input string: "));
        
    }
    
}
