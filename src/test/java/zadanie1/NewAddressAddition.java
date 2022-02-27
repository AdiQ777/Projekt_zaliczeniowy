package zadanie1;

import Helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class NewAddressAddition {

    private WebDriver driver;

    @Given("user is on the CodersLab MyStore main paige")
    public void userIsOnTheCodersLabMyStoreMainPaige() {
        driver = WebDriverFactory.createChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user clicks SignIn button")
    public void userClicksSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signInButton.click();
    }

    @And("fill {string} and {string} and click SingIn button on login page")
    public void fillEmailAndPasswordAndClickSingInButtonOnLoginPage(String email, String password) {

        driver.findElement(By.className("form-control")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @Then("is logged successfully into account")
    public void isLoggedSuccessfullyIntoAccount() {
        String expectedName = "Zenon Kowalczyk";

        WebElement accountConfirmation = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
        String realName = accountConfirmation.getText();

        Assertions.assertEquals(expectedName, realName);
    }

    @When("logged user clicks AddFirstAddress button")
    public void loggedUserClicksAddFirstAddressButton() {
        driver.findElement(By.xpath("//*[@id=\"footer_account_list\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span")).click();
    }

    @And("fills user address data {string}, {string}, {string}, {string}, {string} and clisks Save button")
    public void fillsUserAddressDataAliasAddressZipPostalCodeCityCountryAndClisksSaveButton(String alias, String address, String zipCode, String city, String country) {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")).sendKeys(alias);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")).sendKeys(address);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")).sendKeys(zipCode);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")).sendKeys(city);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }

    @Then("new address is added to account with proper data {string}, {string}, {string}, {string} and {string}")
    public void newAddressIsAddedToAccountWithProperData(String aliasx, String addressx, String zipCodex, String cityx, String countryx) {

        String expectedInfo = "Address successfully added!";
        Assertions.assertEquals(expectedInfo, driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText());

        WebElement xyz = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article"));
        String yzx = xyz.getAttribute("id");

        String aliasm = "//*[@id='" + yzx + "']/div[1]/h4";
        String addressm = "//*[@id='" + yzx + "']/div[1]/address";

        WebElement imieNazwisko = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
        String correctName = imieNazwisko.getText();

        String correctValue = correctName + "\n" + addressx + "\n" + cityx + "\n" + zipCodex + "\n" + countryx;

        Assertions.assertEquals(aliasx, driver.findElement(By.xpath(aliasm)).getText());
        Assertions.assertEquals(correctValue, driver.findElement(By.xpath(addressm)).getText());
    }

    @When("user clicks delete button")
    public void userClicksDeleteButton() {
//        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span")).click();

    }

    @Then("address is deleted")
    public void addressIsDeleted() {

//        String expectedInfo = "Address successfully deleted!";
//        Assertions.assertEquals(expectedInfo, driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText());

    }
}
