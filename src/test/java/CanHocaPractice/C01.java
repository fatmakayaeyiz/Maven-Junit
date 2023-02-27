package CanHocaPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class C01  {

    @Test
    public void name() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //titled
        //
        //    //1-Test01 isimli bir class olusturun
        //    //2- https://www.amazon.com/ adresine gidin
driver.get("https://www.amazon.com/");
        //    //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //    //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //    //5-”Salesforce Apex Questions Bank” icin arama yapiniz
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Salesforce Apex Questions Bank", Keys.ENTER);
        //    //6- Kac sonuc bulundugunu yaziniz
        String [] sonuc=driver.findElement(By.xpath("//*[.='4 results for']")).getText().split(" ");
        System.out.println("sonuc----> "+sonuc[0]+" bulundu");

        //    //7-Sayfayi kapatin
        driver.close();
    }

}
