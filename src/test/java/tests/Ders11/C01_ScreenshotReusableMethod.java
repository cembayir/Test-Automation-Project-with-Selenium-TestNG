package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenshotReusableMethod {

    /*
    TASK
    ----
    1-Hepsiburada sayfasına gidiniz.
    2-Sayfanın resmini alınız.
    3-Sayfayı kapatınız.
     */

    @Test
    public void testAll() throws IOException {
        Driver.getDriver().get("https://www.hepsiburada.com");
        ReusableMethods.getScreenshot("Tüm ekran resmi");
        Driver.closeDriver();
    }

    /*
    TASK
    ----
    1-Amazon sayfasına gidiniz.
    2-Iphone aratınız.
    3-Arama sonuç yazısı WebElement'inin resmini alınız.
     */

    @Test
    public void testWE() throws IOException {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        ReusableMethods.waitFor(1);
        amazonPage.searchBox.sendKeys("Iphone", Keys.ENTER);
        ReusableMethods.getScreenshotWebElement("Web elementin ekran görüntüsü", amazonPage.result);
        Driver.closeDriver();
    }
}