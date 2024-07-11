package tests.Ders10;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_FacebookPageClass {

    /*
    TASK
    ----
    1-https://www.facebook.com adresine gidin.
    2-POM'a uygun olarak email, şifre kutularını ve giriş yap butonunu locate edin.
    3-Faker class'ını kullanarak email ve şifre değerlerini yazdırıp, giriş butonuna basın.
    4-Başarılı giriş yapılmadığını test edin.
     */

    Faker faker;

    @Test
    public void test() {
        FacebookPage facebookPage = new FacebookPage();
        Driver.getDriver().get(ConfigReader.getProperty("facebookURL"));
        faker = new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();
        Assert.assertTrue(facebookPage.failedLogin.isDisplayed());
        Driver.closeDriver();
    }
}