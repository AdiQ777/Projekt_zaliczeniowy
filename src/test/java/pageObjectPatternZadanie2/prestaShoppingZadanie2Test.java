package pageObjectPatternZadanie2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/presta-shop-shopping.feature",
        plugin = {"pretty", "html:out/report.html"}
)
public class prestaShoppingZadanie2Test {
}
