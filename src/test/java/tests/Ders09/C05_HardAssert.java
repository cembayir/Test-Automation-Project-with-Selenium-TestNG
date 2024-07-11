package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C05_HardAssert extends TestBaseCross {

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
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        aramaKutusu.sendKeys("Iphone" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonuc.isDisplayed());
        Assert.assertTrue(sonuc.getText().contains("Iphone"));
    }
}