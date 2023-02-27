package Day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class odev {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // 3- cookies uyarisini kabul ederek kapatin

        //4Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslik= driver.getTitle();
        String GoogleMi="Google";
        if (baslik.equals(GoogleMi)){
            System.out.println("Title testi Passed");
        }else System.out.println("Title testi Failed");
        //5Arama cubuguna “Nutella” yazip aratin
         driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella",Keys.ENTER);

        //6Bulunan sonuc sayisini yazdirin
        WebElement sonuc =driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Bulunan sonuc"+ sonuc.getText());
        //7sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String  sayi = sonuc.getText().split(" ")[1].replaceAll("\\D","");
        System.out.println("sayi = " + sayi);
        Integer sayiInt=Integer.valueOf(sayi);
        int onMl=10000000;
        if (sayiInt>onMl){
            System.out.println("Rakam kontrolu Passed");
        }else System.out.println("Rakam kontrolu Failed");
        //8Sayfayi kapatin
        driver.close();
    }
}
