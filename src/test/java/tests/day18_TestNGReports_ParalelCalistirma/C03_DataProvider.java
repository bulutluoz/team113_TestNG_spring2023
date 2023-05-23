package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    /*
        dataProvider testNG'nin test method'u disindan
        test'e data saglamak icin olusturdugu ozel bir yapidir

        bu yapi iki katli bir array dondurur
     */
    @DataProvider
    public static Object[][] aranacaklarListesi() {

        String[][] aranacaklarArrayi = {{"Java"}, {"Apple"}, {"Samsung"}, {"Faker"}, {"Cracker"}};

        return aranacaklarArrayi;
    }

    @Test(dataProvider = "aranacaklarListesi")
    public void test01(String aranacakKelime){

        // amazon anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // bize test method'u disindan list olarak verilen urunlerin hepsi icin
        // arama kutusuna yazip arama yapin

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);


        // ve sonuc yazisinin arattiginiz element'i icerdigini test edin
        String actualAramaSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik = aranacakKelime;

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();

    }
}
