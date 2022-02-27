package pageObjectPatternZadanie2;

import Helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjectPatternZadanie2.pages.AccountLogin;
import pageObjectPatternZadanie2.pages.ItemConfigurator;
import pageObjectPatternZadanie2.pages.ItemSelector;
import pageObjectPatternZadanie2.pages.OrderConfirmation;

import java.io.File;
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

    @And("select the proper size {string} and quantity of items {string} and add item to cart")
    public void selectTheProperSizeMAndQuantityOfItems(String size, String quantity) {

        ItemConfigurator itemConfigurator = new ItemConfigurator(driver);
        itemConfigurator.selectSize(size);
        itemConfigurator.selectQuantity(quantity);
        itemConfigurator.addToCart();
    }

    @And("go to the checkout page to confirm the address")
    public void goToTheCheckoutPageToConfirmTheAddress() {
        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
        orderConfirmation.proceedToCheckout();
        orderConfirmation.addressConfirmation();
    }

    @And("choose correct delivery {string} and payment type {string}")
    public void chooseCorrectDeliveryAndPaymentType(String shippingType, String paymentType) {
        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
        orderConfirmation.shippingSelection(shippingType);
        orderConfirmation.paymentSelection(paymentType);
    }

    @And("confirm the order")
    public void confirmTheOrder() {
        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
        orderConfirmation.orderConfirmation();
    }

    @Then("the order is placed correctly - screenshot for confirmation")
    public void theOrerIsPlacedCorrectlyScreenshotForConfirmation() throws Exception {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/Screen.png"));
    }
}
