package tests.Ders11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ResourceBundle;

public class C02_WindowHandleReusableMethod {

    /*
    TASK
    ----
    1-https://the-internet.herokuapp.com/windows adresine gidin.
    2-Click Here butonuna basın.
    3-Açılan yeni tab'ın başlığının "New Window" olduğunu test edin.
     */

    @Test
    public void test() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        ReusableMethods.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Driver.quitDriver();
    }
}