package pageObjectPatternZadanie2;

import Helpers.WebDriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PrestaShopping {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



}
