package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by onur on 19/02/21.
 */
public class SelectPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productsList = By.xpath("//ul[@class='catalog-view clearfix products-container']");
    private String secondPage = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
    private By actualPageNumberXpath = By.xpath("//a[@class='current']");
    private String expectedPageNumber = "2";

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void assertPageNumber() {

        wait.until(ExpectedConditions.presenceOfElementLocated(actualPageNumberXpath));
        String actualPageNumber = driver.findElement(actualPageNumberXpath).getText();
        Assert.assertEquals(expectedPageNumber, actualPageNumber);
    }

    public void clickSecondPageButton() {
        driver.get(secondPage);
    }

    public ProductPage selectProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(productsList));
        List<WebElement> productList = driver.findElements(productsList);
        productList.get(0).click();
        return new ProductPage(driver);

    }
}
