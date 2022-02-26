package pageObjectPatternZadanie2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ItemSelector {

    private WebDriver driver;

    public ItemSelector(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void selectionOfItem(String itemName) {
        List<WebElement> items = driver.findElements(By.className("thumbnail-container"));
        boolean elementFound = false;
        for (WebElement item : items) {
            if (item.getText().contains(itemName)) {
                item.findElement(By.cssSelector("a.product-thumbnail")).click();
                elementFound = true;
                break;
            }
        }

        if (!elementFound)
            throw new NoSuchElementException("Towar o nazwie " + itemName + " nie zostal znaleziony");
    }



}
