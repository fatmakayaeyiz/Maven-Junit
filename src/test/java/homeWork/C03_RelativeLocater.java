package homeWork;

import com.beust.ah.A;
import io.netty.resolver.AbstractAddressResolver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_RelativeLocater extends TestBase {


    @Test
    public void test1() {
        //Test01 :  1- amazon gidin

        driver.get("https://amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for (WebElement w : select.getOptions()) {
            System.out.println(w.getText());
        }

        //dropdown menude 28 eleman olduğunu doğrulayın
        List<WebElement> eleman = select.getOptions();
        System.out.println("Menudeki toplam eleman sayisi = " + eleman.size());
        Assert.assertTrue(eleman.size() == 28);

        //Test02


        //dropdown menuden elektronik bölümü seçin
        driver.findElement(By.xpath("(//*[text()='Electronics'])[1]")).click();

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        String[] Iphonesonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("sonuc= " + Iphonesonuc[3]);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin

        WebElement birinciUrun = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("//img[@data-image-index='3']"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("span")).toRightOf(birinciUrun).toLeftOf(ucuncuUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String iphoneTitle = driver.getTitle();
        System.out.println("iphoneTitle = " + iphoneTitle);


        String iphonefiyat = driver.findElement(By.xpath("//*[@class='a-price aok-align-center']")).getText()
                .replaceAll("\\W", "");

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();


        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select option = new Select(ddm);
        option.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bebek puset", Keys.ENTER);
        //sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText().contains("puset"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinci = driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        WebElement dorduncu = driver.findElement(By.xpath("(//img[@class='s-image'])[4]"));
        WebElement ucuncu = driver.findElement(with(By.tagName("span")).below(ikinci).above(dorduncu));
        ucuncu.click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String pusetTitle = driver.getTitle();
        System.out.println(pusetTitle);
        String pusetfiyat = driver.findElement(By.id("corePrice_feature_div")).getText().replaceAll("\\W", "");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();


        // Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


        // FİYAT DOGRULAMASI
        driver.findElement(By.id("nav-cart-count-container")).click();
        String sepettekiIphoneFiyat = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]")).
                getText().replaceAll("\\W", "");

        Assert.assertEquals(sepettekiIphoneFiyat, iphonefiyat);
        String sepettekiPusetFiyat = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")).
                getText().replaceAll("\\W", "");
        Assert.assertEquals(sepettekiPusetFiyat, pusetfiyat);


        // TITLE DOGRULAMASI

        String sepettekiIphoneTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-full a-offscreen'])[6]")).getText();
        System.out.println("sepettekiIphoneTitle = " + sepettekiIphoneTitle);
        Assert.assertTrue(iphoneTitle.contains(sepettekiIphoneTitle));

        String sepettekiPusetTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-full a-offscreen'])[5]")).getText();
        Assert.assertTrue(pusetTitle.contains(sepettekiPusetTitle));
    }
}
