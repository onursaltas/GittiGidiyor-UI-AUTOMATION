package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by onur on 19/02/21.
 */
public class PrimaryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchFıeld = By.xpath("//input[@type='text']");
    private By findButton = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']");
    private By accountNameField = By.xpath("//div[@class='gekhq4-4 egoSnI']");

    String expectedAccountName = "Hesabım\nqquestionanswer";

    public PrimaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void assertAccountName() {

        wait.until(ExpectedConditions.presenceOfElementLocated(accountNameField));
        String actualAccountName = driver.findElement(accountNameField).getText();
        Assert.assertEquals(expectedAccountName, actualAccountName);
    }

    public void SearchArea(String search) {

        wait.until(ExpectedConditions.presenceOfElementLocated(searchFıeld));
        driver.findElement(searchFıeld).sendKeys(search);
    }

    public SelectPage clickFindButton() {

        wait.until(ExpectedConditions.elementToBeClickable(findButton));
        driver.findElement(findButton).click();
        return new SelectPage(driver);
    }


}
