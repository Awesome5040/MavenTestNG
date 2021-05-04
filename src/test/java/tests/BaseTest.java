package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.setWebDriver(new ChromeDriver(new ChromeOptions()));
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeDriver() {
        getWebDriver().quit();
    }

    void openPage() {
        getWebDriver().navigate().to("https://translate.google.com/?hl=en&tl=fr");
    }

    protected void typeText(final String text) {
        $x("//textarea[@aria-autocomplete='list']").shouldBe(visible).sendKeys(text);
        waitForPageLoad();
    }

    String getTransletedText() {
        return $x("//span[@class='VIiyi']").shouldBe(visible).getText();
    }

    private void waitForPageLoad() {
        new WebDriverWait(getWebDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
