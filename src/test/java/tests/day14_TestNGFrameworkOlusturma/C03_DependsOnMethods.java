package tests.day14_TestNGFrameworkOlusturma;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C03_DependsOnMethods {

    /*
        DependsOnmethods oncelik sirasina karismaz

        dependsOnMethods bir test method'un calismasini
        baska bir method'un calisip passed olmasina baglar

        baglanilan method calismaz veya calisr ama failed olursa
        baglanan method hic calismaz

        @Test sayesinde her test bagimsiz olarak calistirilabilir

        Ancak bir test dependsOnMethods ile baska bir method'a baglanmis ise
        tek basina calismasi istendiginde, once bagli oldugu test method'unu calistirir
        o method calisip passed olursa asil calistirmak istedigimiz method'da calisir

        bu baglanti 3 veya daha fazla method arasinda olursa
        yani calistirmak istedigimiz method baska bir method'a,
        o da baska bir method'a bagli ise
        3'u birden calismaz
        "No tests were found" yazar ve hic bir test method'u calismaz
     */

    @Test(dependsOnMethods = "wiseTesti")
    public void youtubeTesti(){
        System.out.println("Youtube");

    }

    @Test(priority = 3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test(dependsOnMethods = "youtubeTesti")
    public void amazonTesti(){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon");
    }
}
