package tests.day14_TestNGFrameworkOlusturma;

import org.testng.annotations.Test;

public class C01_Priority {
    /*
        JUnit framework'de testlerin calisma sirasi
        ONGORULEMEZ ve DUZENLENEMEZ

        TestNG testleri harf sirasina gore calistirir (ONGORULEBILIR)

        Ayrica priority degeri girerek testleri istedigimiz sira ile de calistirabiliriz
        (KONTROL EDILEBILIR SIRALAMA)

        priority sayisal olarak kucukten buyuge dogru testleri calistirir
        eger priority degeri ayni olan birden fazla test varsa, yine harf sirasina bakar
     */

    @Test
    public void youtubeTesti(){
        System.out.println("Youtube");
    }

    @Test(priority = 3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test
    public void amazonTesti(){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon");
    }


}
