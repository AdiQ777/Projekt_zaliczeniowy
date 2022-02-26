package pageObjectPatternZadanie2;

import Helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjectPatternZadanie2.pages.AccountLogin;
import pageObjectPatternZadanie2.pages.ItemSelector;

import java.time.Duration;

public class prestaShoppingZadanie2 {

    private WebDriver driver;

    @Given("user is on the main paige CodersLab Presta Shop")
    public void userIsOnTheMainPaigeCodersLabPrestaShop() {
        driver = WebDriverFactory.createChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @When("user login with proper credentials - email {string} and password {string}")
    public void userLoginWithProperCredentialsEmailZKowalczykMailPlAndPasswordQwerty(String email, String password) {

        AccountLogin accountLogin = new AccountLogin(driver);
        accountLogin.loginAs(email, password);
    }

    @Then("user is logged into the account")
    public void userIsLoggedIntoTheAccount() {

        String expectedName = "Zenon Kowalczyk";

        AccountLogin accountLogin = new AccountLogin(driver);
        String realName = accountLogin.loginConfirmed();

        Assertions.assertEquals(expectedName, realName);
    }

    @Given("logged user is on the CodersLab Presta Shop main paige")
    public void loggedUserIsOnTheCodersLabPrestaShopMainPaige() {
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @When("user choose the correct item {string}")
    public void userChooseTheCorrectItemHummingbirdPrintedSweater(String itemName) {
        ItemSelector itemSelector = new ItemSelector(driver);
        itemSelector.selectionOfItem(itemName);
    }

    @And("select the proper size {string} and quantity of items {string}")
    public void selectTheProperSizeMAndQuantityOfItems(int arg0) {
    }

    @And("add the items to the shopping cart")
    public void addTheItemsToTheShoppingCart() {
    }

    @And("go to the checkout page to confirm the address")
    public void goToTheCheckoutPageToConfirmTheAddress() {
    }

    @And("choose correct delivery and payment type")
    public void chooseCorrectDeliveryAndPaymentType() {
    }

    @And("confirm the order")
    public void confirmTheOrder() {
    }

    @Then("the order is placed correctly - screenshot for confirmation")
    public void theOrerIsPlacedCorrectlyScreenshotForConfirmation() {
    }
}
