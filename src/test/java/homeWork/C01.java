package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {
    @Test
    public void iframe() {
        //    Bir class olusturun: IframeOdev
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
//    sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.tagName("iframe"));
        System.out.println("Toplam iframe Sayisi= "+iframeSayisi.size());
//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.

        String actualResult = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(actualResult.contains("Editor"));
//    Paragrafdaki yaziyi silelim
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();


//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("iframein icindeyim");
//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String byPowered = driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText();
        Assert.assertTrue(byPowered.contains("Elemental Selenium"));
    }


}
