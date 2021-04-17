package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by onur on 19/02/21.
 */
public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public static String productPrice;

    private By addBasket = By.id("add-to-basket");
    private By productPriceId = By.id("sp-price-highPrice");
    private By basketXpath = By.xpath("//a[@class='header-cart-hidden-link']");
    private By basketLinkPath = By.className("dIB");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /*public void hoverBasket() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(basketXpath)).build().perform();
    }*/

    public void clickAddBasket() {

        wait.until(ExpectedConditions.presenceOfElementLocated(addBasket));
        /* Sepete tıklarken reklam , butonu kapattığı için böyle bir yol izledim.*/
        WebElement webElement = driver.findElement(addBasket);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);

        wait.until(ExpectedConditions.presenceOfElementLocated(productPriceId));
        productPrice = driver.findElement(productPriceId).getText();
    }

    public BasketPage clickBasketPage() {

        wait.until(ExpectedConditions.elementToBeClickable(basketLinkPath));
        driver.findElement(basketLinkPath).click();
        return new BasketPage(driver);


    }
}
