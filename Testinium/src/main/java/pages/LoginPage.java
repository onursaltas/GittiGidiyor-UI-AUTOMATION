package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by onur on 19/02/21.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.id("L-UserNameField");
    private By passwordField = By.id("L-PasswordField");
    //private By captcha= By.id("recaptcha-anchor-label");
    private By loginButton = By.id("gg-login-enter");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    //Name girilir.
    public void Username(String name) {

        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        ;
        driver.findElement(nameField).sendKeys(name);
    }

    //Şifre girilir
    public void Password(String password) {

        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    //Gerekli durumda buradaki yorum satırı kullanılabilir.
    /*public void setCaptcha(){
        driver.findElement(captcha).click();
    }*/

    //"Giriş Yap" butonuna tıklanır.
    public PrimaryPage LoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        return new PrimaryPage(driver);
    }
}
