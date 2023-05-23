package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class C02_RaporluSoftAssert {

    @Test
    public void test01() throws InterruptedException {
        // 1. Test
        //            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        //            - 1.alert'e tiklayin
        Thread.sleep(3000);
        WebElement ilkAlertElementi = Driver.getDriver().findElement(By.xpath("//*[text()='Click for JS Alert']"));
        ilkAlertElementi.click();

        //            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        Thread.sleep(3000);

        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        SoftAssert softAssert = new SoftAssert();
        // Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        softAssert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"alertteki yazi belirlenenden farkli");

        //            -  OK tusuna basip alert'i kapatin

        Driver.getDriver().switchTo().alert().accept();

        // allert'in kapatildigini test edin

        // Assert.assertTrue(ilkAlertElementi.isEnabled());

        softAssert.assertTrue(ilkAlertElementi.isEnabled(),"alert kapatilamadi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
