package tests.Ders09;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    @Test(priority = 1)
    public void testAmazon() {
        driver.get("https://www.amazon.com.tr");
    }

    @Test(priority = 2)
    public void testbestbuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = 3)
    public void testHepsiburada() {
        driver.get("https://www.hepsiburada.com");
    }
}