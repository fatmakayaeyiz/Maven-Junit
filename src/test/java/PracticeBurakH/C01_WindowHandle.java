package PracticeBurakH;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {
    @Test
    public void Test01() {
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String ilkWindow=driver.getWindowHandle();
        // 2- nutella icin arama yapın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        // 3- yeni bir tab'da ilk urunun resmine tıklayınız

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        // 4- yeni tab'da acilan urunun basligini yazdirin

        WebElement baslik=driver.findElement(By.xpath("//span[@id='productTitle']"));
        String baslikStr=baslik.getText();
        System.out.println("BASLİK: " + baslikStr);

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(ilkWindow);
        System.out.println("İlk sayfa url"+driver.getCurrentUrl());
    }
}
