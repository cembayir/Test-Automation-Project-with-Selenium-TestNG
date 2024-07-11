package tests.Ders11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_DataProviderPractice {

    /*
    TASK
    ----
    1-https://www.bluerentalcars.com/ adresine git.
    2-Login butonuna bas.
    3-Data Provider ile 3 farklı userEmail ve 3 farklı password girelim.
    4-Login butonuna tıklayın.
    5-Değerleri girildiğinde sayfaya başarılı şekilde girilebildiğini test et.
    */

    BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();

    @DataProvider
    public static Object[][] loginTest() {
        return new Object[][]{{"user@gmail.com", "12345"}, {"user1@gmail.com", "12345"}, {"user2@gmail.com", "12345"}};
    }

    @Test(dataProvider = "loginTest")
    public void test(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        bluerentalcarsPage.loginButton.click();
        bluerentalcarsPage.email.sendKeys(email);
        bluerentalcarsPage.password.sendKeys(password);
        bluerentalcarsPage.login.click();
        Assert.assertTrue(bluerentalcarsPage.login.isDisplayed());

    }
}