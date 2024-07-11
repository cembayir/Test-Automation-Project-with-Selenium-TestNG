package tests.Ders10;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlotechPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SmokeNegatifTest {

    /*
    TASK
    ----
    1-https://demo1.alo-tech.com/ adresine git.
    2-Email,Password,Login elementlerini locate ediniz.
    3-Değerler girildiğinde sayfaya girilemediğini test ediniz.
    4-Sayfayı kapatınız.
     */

    AlotechPage alotechPage = new AlotechPage();

    @Test(groups = "grup1")
    public void yanlisKullanici() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        alotechPage.email.sendKeys(ConfigReader.getProperty("wrongUser"));
        alotechPage.password.sendKeys(ConfigReader.getProperty("Password"));
        Thread.sleep(1000);
        alotechPage.loginButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(alotechPage.failedLogin.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisSifre() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        alotechPage.email.sendKeys(ConfigReader.getProperty("User"));
        alotechPage.password.sendKeys(ConfigReader.getProperty("wrongPass"));
        Thread.sleep(1000);
        alotechPage.loginButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(alotechPage.failedLogin.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisKullaniciSifre() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        alotechPage.email.sendKeys(ConfigReader.getProperty("wrongUser"));
        alotechPage.password.sendKeys(ConfigReader.getProperty("wrongPass"));
        Thread.sleep(1000);
        alotechPage.loginButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(alotechPage.failedLogin.isDisplayed());
        Driver.closeDriver();
    }
}