package tests.Ders10;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_AmazonPageClass {

    /*
    TASK
    ----
    1-Amazon ana sayfasına gidelim.
    2-Selenium aratalım.
    3-Sonuç yazısının Selenium içerdiğini test edelim.
     */

    @Test
    public void test() throws InterruptedException {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        Thread.sleep(1000);
        amazonPage.cookie.click();
        amazonPage.searchBox.sendKeys("Selenium" + Keys.ENTER);
        String expectedData = "Selenium";
        String actualData = amazonPage.result.getText();
        Assert.assertTrue(actualData.contains(expectedData));
        Driver.closeDriver();
    }
}