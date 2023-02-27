package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C13 extends TestBase {
    @Test
    public void name() {
        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");
//anasayfada oldugunuzu dogrulayin
      Assert.assertEquals(driver.getCurrentUrl(),"https://www.sahibinden.com/");
//detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();
//detayli arama sayfasina geldiginizi dogrulatin
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.sahibinden.com/arama/detayli");
//emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//*[text()='Emlak']")).click();
        driver.findElement(By.xpath("//*[.='Konut']")).click();
        driver.findElement(By.xpath("//*[text()='Satılık']")).click();

//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin

        driver.findElement(By.xpath("//*[@data-address='city']")).click();
        waitFor(2);
        driver.findElement(By.xpath("(//input[@class='js-address-filter'])[2]")).sendKeys("izmir");
        driver.findElement(By.xpath("//*[text()='İzmir']")).click();

        driver.findElement(By.xpath("//li[@data-address='town']")).click();
        driver.findElement(By.xpath("//*[text()='Bayraklı']")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();

        driver.findElement(By.xpath("//li[@data-address='quarter']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//li[@data-id='24123']")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();



//filtreler için sağıdakilere benzer methodlar oluşturun
//        detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
//        detayli_Arama_Fiyat("4.000","4.000.000","USD");
//        detayli_Arama_Brut("180","400");
//        detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
//.
//.
//...
//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }
}
