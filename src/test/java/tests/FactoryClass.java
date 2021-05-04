package tests;
import org.testng.annotations.Factory;

public class FactoryClass {

    @Factory
    public Object[] createInstances() {
        return new Object[] { new FactoryTest("first string", "première corde"),
                new FactoryTest("last string", "dernière chaîne")};
    }
}
