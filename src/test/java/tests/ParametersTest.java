package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest extends BaseTest {

    @Test
    @Parameters({"inputString", "expectedResult"})
    public void translateTest2(final String inputString, final String outputString) {
        openPage();
        typeText(inputString);
        Assertions.assertThat(outputString).as("Translation is not correct")
                .isEqualTo(getTransletedText());
    }
}