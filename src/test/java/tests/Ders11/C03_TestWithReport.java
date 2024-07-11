package tests.Ders11;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C03_TestWithReport extends TestBaseReport {

    /*
    TASK
    ----
    1-https://www.bluerentalcars.com/ adresine git.
    2-Login butonuna bas.
    3-Test data user email: yetig89399@atebin.com
    4-Test data user password: 1234
    5-Login butonuna tıklayın.
    6-Değerleri girildiğinde sayfaya başarılı şekilde girilebildiğini test et.
     */

    BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();

    @Test
    public void test() {
        extentTest = extentReports.createTest("Login Test", "Giriş sayfasının doğrulanması.");
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        extentTest.info("Blue Rental Cars sitesine gidildi.");
        bluerentalcarsPage.loginButton.click();
        extentTest.info("Login butonuna tıklandı.");
        bluerentalcarsPage.email.sendKeys(ConfigReader.getProperty("brcUser"));
        extentTest.info("Kullanıcı email adresi girildi.");
        bluerentalcarsPage.password.sendKeys(ConfigReader.getProperty("brcPass"));
        extentTest.info("Kullanıcı şifresi girildi.");
        bluerentalcarsPage.login.click();
        extentTest.info("Login butonuna tıklandı.");
        Assert.assertTrue(bluerentalcarsPage.loginSuccessfully.isDisplayed());
        extentTest.pass("Sayfaya başarılı şekilde giriş yapıldı.");
    }
}