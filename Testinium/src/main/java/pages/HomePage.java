package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by onur on 19/02/21.
 */
public class HomePage {

    private WebDriver driver;

    //private By loginLink=By.linkText("Giriş Yap");
    //private By hoverLogin= By.xpath("//div[@class='sc-3wdx43-0 bAxXdY']");
    /*GittiGidiyor sitesinde giriş yap butonu için gizli bir sınıf oluşturulmuş
    bu yüzden div içine girip oradan tıklayamıyor.
    bu nedenle anasayfa kontrol edildikten sonra login sayfasına direkt geçiyorum.
     */

    String loginUrl = "https://www.gittigidiyor.com/uye-girisi";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /*public void hoverLogin(){
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(loginLink)).build().perform();
     }*/

    public LoginPage clickLogin() {
        driver.get(loginUrl);
        return new LoginPage(driver);
    }
}
