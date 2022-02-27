package pageObjectPatternZadanie2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderConfirmation {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    private WebElement addressConfirmationButton;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement shippingTypeConfirmationButton;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditionsButton;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement confirmationButton;

    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public void addressConfirmation() {
        addressConfirmationButton.click();
    }
    public void shippingSelection(String shippingType) {
        List<WebElement> items = driver.findElements(By.cssSelector(".row.delivery-option"));
        boolean elementFound = false;
        for (WebElement item : items) {
            if (item.getText().contains(shippingType)) {
                item.findElement(By.cssSelector(".custom-radio.float-xs-left")).click();
                elementFound = true;
                break;
            }
        }
        shippingTypeConfirmationButton.click();
    }

    public void paymentSelection(String paymentType) {
        List<WebElement> items = driver.findElements(By.cssSelector(".payment-option.clearfix"));
        boolean elementFound = false;
        for (WebElement item : items) {
            if (item.getText().contains(paymentType)) {
                item.findElement(By.cssSelector(".custom-radio.float-xs-left")).click();
                elementFound = true;
                break;
            }
        }

        termsAndConditionsButton.click();
    }

    public void orderConfirmation() {
        confirmationButton.click();
    }


}
