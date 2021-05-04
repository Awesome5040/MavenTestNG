package dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "test-data")
    public static Object[][] dataProvFunc() {
        return new Object[][]{
                {"first string", "première corde"}, {"second string", "seconde chaîne"},
                {"last string", "dernière chaîne"}
        };
    }
}
