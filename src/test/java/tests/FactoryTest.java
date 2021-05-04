package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class FactoryTest extends BaseTest {

   private String inputString;
   private String expectedResult;

    public FactoryTest(String inputString, String expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

    @Test
    public void translateTest() {
        openPage();
        typeText(inputString);
        Assertions.assertThat(expectedResult).as("Translation is not correct")
                .isEqualTo(getTransletedText());
    }
}
