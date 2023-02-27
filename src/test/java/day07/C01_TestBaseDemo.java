package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
    UTILITIES:
    -Utilities tekrar tekrar kullanacağımız methodlari(class)koydugumuz paketin adidir
    -TestBase -> BUGUN
    -Drver->Sonra
    -ExcelUtil ->Sonra
    -Configuration -> Sonra
    -Utilities paketinde Test case ler (@Test) yazilmaz
    -Sadece tekrar kullanilabilecek destek siniflari (support class)olusturur.
    -Bu support claslar test caseslerin yazilmasini hizlandirir

     */
    @Test
    public void test1(){
        //techproeducation ana sayfasina git
        driver.get("https://www.techproeducation.com/");
        //ve titlein 'Bootcamps' kelimesini icerdigini test edelim
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }
}
