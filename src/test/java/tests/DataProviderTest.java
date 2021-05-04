package tests;

import dataproviders.TestDataProvider;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class DataProviderTest extends BaseTest {

    @Test(dataProvider = "test-data", dataProviderClass = TestDataProvider.class)
    public void translateTest(final String inputString, final String outputString) {
        openPage();
        typeText(inputString);
        Assertions.assertThat(outputString).as("Translation is not correct")
                .isEqualTo(getTransletedText());
    }

}
