package practiceErolH_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_EbayTest {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {

        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");
        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();
        //- Her sayfanın sayfa başlığını yazdıralım
        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        for (int i =0 ; i <24; i++) {
            List<WebElement> urunler= driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

            urunler.get(i).click();
            System.out.println(i+". baslik  :"+ driver.getTitle());
        driver.navigate().back();
        }


        //- sayfayı kapatalım
    }

    @After
    public void close() {

    }
}
