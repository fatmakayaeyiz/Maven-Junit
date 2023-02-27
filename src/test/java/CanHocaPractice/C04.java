package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04 extends TestBase {
    @Test
    public void name() {
//    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        // ~ http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
//    ~ click on Phones & PDAs
        // ~ Telefonlar ve PDA'lar'a tıklayın
driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

//    ~ get the brandName of phones
        // ~ telefonların markasını al
        List<WebElement> markalar=driver.findElements(By.xpath("(//*[@class='row'])[4]//h4"));
       String count="";
        for (WebElement w:markalar) {
            count=w.getText();
            System.out.println("Marka = " +count);
        }

//    ~ click on add to button for all elements
        // ~ tüm öğeler için ekle düğmesine tıklayın
        List<WebElement> add=driver.findElements(By.xpath("//*[.='Add to Cart']"));
        for (WebElement element : add) {
            element.click();

        }
//    ~ click on black total added cart button
        // ~ siyah toplam eklenen sepet düğmesine tıklayın

        driver.findElement(By.xpath("//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
//    ~ get the names of list from the cart
        // ~ listenin isimlerini sepetten al
       String count2="";
        List<WebElement> sepettekiUrunler =driver.findElements(By.xpath("//*[@class='table table-striped']"));
        for (WebElement w:sepettekiUrunler){
        count2=count+w.getText();
         System.out.println("isimler = "+ count2);
        }



//    ~ compare the names from displaying list and cart list
// ~ görüntüleme listesindeki ve sepet listesindeki adları karşılaştırın
   Assert.assertTrue(count2.contains(count));


        }



    }



