package tests;

import org.junit.Test;
import pages.*;
/**
 * Created by onur on 19/02/21.
 */

public class MainTest extends InıtıalTest {

    @Test
    public void Testinium_Project_Test_Scenario_1() {


        LoginPage loginPage = homePage.clickLogin();            //InıtıalTest : BeforeClass ve AfterClass tanımlamaları yapıldı.

        loginPage.Username("qquestionanswerr@gmail.com");       //Kullanıcı adı girildi.
        loginPage.Password("asdf1?");                           //Şifre girildi.
        //loginPage.setCaptcha();                               //Eğer güvenlik onayı çıkarsa kullanılabilir.


        PrimaryPage primaryPage = loginPage.LoginButton();      //"Giriş Yap" butonuna tıklandı ve primaryPage tarafına atandı.
        primaryPage.assertAccountName();                        //Login işlemi kontrol edildi.
        primaryPage.SearchArea("bilgisayar");                   //TextBox'a "bilgisayar" girildi.

        SelectPage selectPage = primaryPage.clickFindButton();  //"BUL" butonuna tıklandı.
        selectPage.clickSecondPageButton();                     //Sayfa olarak 2 seçildi.
        selectPage.assertPageNumber();                          //Sayfanın "2" olduğu kontrol edildi.

        ProductPage productPage = selectPage.selectProduct();   //Sayfa 2 de ki ürünler tanımlanır.
        productPage.clickAddBasket();                           //Ürün sepete eklendi



        BasketPage basketPage = productPage.clickBasketPage();  //Sepetime Tıklandı
        basketPage.assertPrice();                               //Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        basketPage.clickProductAdd();                            //Ürün adedi 2' ye çıkartılır.
        basketPage.assertProductCount();                        //Ürün adedinin 2 olduğu doğrulanır
        basketPage.clickDeleteProduct();                        //Ürün sepetten silinir.
        basketPage.assertBasketSituation();                     //Sepetin boş olduğu kontrol edilir.


    }

}
                                                            //CASE SENARYO
/*
- www.gittigidiyor.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
- Login işlemi kontrol edilir.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
 */