package practiceErolH_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AmazonTest {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void amazon() {
        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com/");
        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("actualUrl = " + actualUrl);

        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("spend") && actualUrl.contains("spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com");
        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));
        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        //-sayfayi yenileyelim
        driver.navigate().refresh();
        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();// Birden fazla sayfada calisilmissa quit() methodu kullanilir.
    }

}
