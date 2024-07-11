package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProvider {

    /*
    TASK
    ----
    1-Amazona gidelim.
    2-Java,Selenium,Samsung ve Iphone için arama yapalım.
    3-Sonuçların aradığımız kelimeyi içerdiğini test edelim
     */
    AmazonPage amazonPage = new AmazonPage();

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"}, {"selenium"}, {"samsung"}, {"iphone"}};
    }

    @Test(dataProvider = "aranacakKelimeler",groups = "grup1")
    public void test(String kelimeler) {
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        amazonPage.searchBox.sendKeys(kelimeler, Keys.ENTER);
        String actualData = amazonPage.result.getText();
        Assert.assertTrue(actualData.contains(kelimeler));
    }
}