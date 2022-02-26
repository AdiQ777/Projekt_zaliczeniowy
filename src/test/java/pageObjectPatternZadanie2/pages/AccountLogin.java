package pageObjectPatternZadanie2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class AccountLogin {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement signInButtonFirst;

    @FindBy(className = "form-control")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement signInButtonSecond;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement realMessage;

    public AccountLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginAs(String email, String password) {
        signInButtonFirst.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButtonSecond.click();
    }

    public String loginConfirmed() {
        return realMessage.getText();
    }

}
