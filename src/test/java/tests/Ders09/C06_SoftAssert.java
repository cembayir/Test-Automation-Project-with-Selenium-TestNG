package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C06_SoftAssert extends TestBaseCross {

    /*
    TASK
    ----
    1-Amazon sayfasına gidin.
    2-Title'ın Amazon içerdiğini test edin.
    3-Arama kutusunun erişilebilir olduğunu test edin.
    4-Arama kutusuna Iphone yazıp aratın.
    5-Arama yapıldığını test edin.
    6-Arama sonucunun Iphone içerdiğini test edin.
     */

    @Test
    public void test() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.amazon.com.tr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

        softAssert.assertTrue(driver.getTitle().contains("Amazon"), "Girdiğiniz kelimeyi içermemektedir.");
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "Aradığınız WebElement'e erişilememektedir.");
        aramaKutusu.sendKeys("Iphone" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(), "Arama yapılamadı.");
        softAssert.assertTrue(sonuc.getText().contains("Iphone"), "Iphone içermemektedir.");
        softAssert.assertAll(); //<-- Soft Assert'ü bu şekilde bitirmezsek çalışmayacaktır.
    }
}