package practiceErolH_01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C19_Actions extends TestBase {
    @Test
    public void name() {
       //http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi =driver.findElement(By.xpath("//canvas"));
        Actions actions=new Actions(driver);
        //    - Çizimden sonra clear butonuna basalım
        actions.moveToElement(yaziTahtasi).clickAndHold(yaziTahtasi);
        for (int i = 0; i< 10 ;i ++) {

            actions.moveByOffset(5,0);
        }
        for (int i = 0; i< 10 ;i ++) {

            actions.moveByOffset(5,5);
        }
        for (int i = 0; i< 10 ;i ++) {

            actions.moveByOffset(0,5);
        }
        actions.release().build().perform();


        //    - Son olarak sayfayı temizleyiniz
        driver.findElement(By.xpath("//*[@class='button clear']")).click();
    }
}
