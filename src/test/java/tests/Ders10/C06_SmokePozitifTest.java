package tests.Ders10;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_SmokePozitifTest {

    /*
    TASK
    ----
    1-https://www.bluerentalcars.com adresine git ve login butonuna bas.
    2-Email,Password ve Login butonlarını locate et.
    3-Değerler girildiğinde sayfaya başarılı bir şekile girildiğini test et.
     */

    BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();

    @Test(groups = "grup1")
    public void pozitifTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        Thread.sleep(1000);
        bluerentalcarsPage.loginButton.click();
        bluerentalcarsPage.email.sendKeys(ConfigReader.getProperty("brcUser"));
        bluerentalcarsPage.password.sendKeys(ConfigReader.getProperty("brcPass"));
        bluerentalcarsPage.login.click();
        Assert.assertTrue(bluerentalcarsPage.loginSuccessfully.isDisplayed());
        Driver.closeDriver();
    }
}