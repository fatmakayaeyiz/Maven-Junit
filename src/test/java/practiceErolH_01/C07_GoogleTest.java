package practiceErolH_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_GoogleTest {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void name() {
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
//        3- cookies uyarisini kabul ederek kapatin
//        4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String title= driver.getTitle();
        String googlemi="Google";
        Assert.assertTrue(title.contains(googlemi));
//        5 Arama cubuguna “Nutella” yazip aratin
        WebElement nutella =driver.findElement(By.className("gLFyf"));
        nutella.sendKeys("Nutella",Keys.ENTER);
//        6 Bulunan sonuc sayisini yazdirin.
        WebElement buluunan = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonuc= buluunan.getText().split(" ")[1].replaceAll("\\D","");
        System.out.println("sonuc = " + sonuc);
//        7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        Integer sayi=Integer.valueOf(sonuc);
        int onMl=10000000;
        Assert.assertTrue(sayi >onMl);
//        8 Sayfayi kapatin
    }
}
