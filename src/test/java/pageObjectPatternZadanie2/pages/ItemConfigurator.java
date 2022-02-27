package pageObjectPatternZadanie2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemConfigurator {

    private WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement sizeWanted;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityWanted;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement confirmationCart;

    public ItemConfigurator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void selectSize(String size) {
        Select drpSize = new Select(sizeWanted);
        drpSize.selectByVisibleText(size);
    }

    public void selectQuantity(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(quantityWanted)).click();
                quantityWanted.clear();
                quantityWanted.sendKeys(quantity);
    }

    public void addToCart() {
        addToCartButton.click();
        confirmationCart.click();
    }

}
