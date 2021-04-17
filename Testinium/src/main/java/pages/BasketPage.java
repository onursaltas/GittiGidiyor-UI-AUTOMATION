package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.ProductPage.productPrice;
/**
 * Created by onur on 19/02/21.
 */
public class BasketPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By deleteProduct = By.xpath("//a[@title='Sil']");
    private By productAdd = By.xpath("//select[@class='amount']");
    private By productUpSelect = By.xpath("//select[@class='amount']//child::option[@value='2']");
    private By productCount = By.xpath("//select[@class='amount']//child::option[@value='2']");
    String expectedProductCount = "2";
    private By basketStatus = By.xpath("//div[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']");
    String expectedbasketStatus = "Sepetinizde ürün bulunmamaktadır.";
    private By basketTotalPrice = By.xpath("//p[@class='new-price']");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void assertPrice() {

        wait.until(ExpectedConditions.presenceOfElementLocated(basketTotalPrice));
        String totalPrice = driver.findElement(basketTotalPrice).getText(); // eğer indirim olmasaydı buradaki ProductPage içerisindeki totalPrice'i kullanarak eşleştirme yapıcaktım.
        Assert.assertEquals("4.199,00 TL", totalPrice); //expected değerini manuel girdim , çünkü bir indirim tanımlıyor ürüne. Sadece siparişi tamamla bölümünde.
        //Assert.assertEquals(productPrice, totalPrice);
    }

    public void assertProductCount() {

        wait.until(ExpectedConditions.presenceOfElementLocated(productCount));
        String actualProductCounts = driver.findElement(productCount).getAttribute("value");
        Assert.assertEquals(expectedProductCount, actualProductCounts);
    }

    public void assertBasketSituation() {

        wait.until(ExpectedConditions.presenceOfElementLocated(basketStatus));
        String actualBasketStatus = driver.findElement(basketStatus).getText();
        Assert.assertTrue(expectedbasketStatus.contains(actualBasketStatus));
    }

    public void clickProductAdd() {

        wait.until(ExpectedConditions.elementToBeClickable(productAdd));
        driver.findElement(productAdd).click();
        wait.until(ExpectedConditions.elementToBeClickable(productUpSelect));
        driver.findElement(productUpSelect).click();
    }

    public void clickDeleteProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(deleteProduct));
        driver.findElement(deleteProduct).click();

    }
}
