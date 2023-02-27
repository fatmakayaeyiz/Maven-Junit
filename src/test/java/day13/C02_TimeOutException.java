package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
TimeOutException:
Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
Explicit wait & yanlis locator-> timeout
Explicit wait & doğru locator & sure yeterli degil -> timeout
Explicit wait & dogru locator & sure yeterli & iframe var ->  time out
Solution:
-Sureyi arttirmak
-Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated. Yada
javascript executor da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
-Locatori tekrar kontrol etmek
-Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda
ızlıca o metotlar yardımıyla problemi cozebiliyoruz
     */
/*
TimeOutException explicit wait kullandigimda ve locator bulunamadiginda alirim
 */
    @Test
    public void timeOutExceptionTest() {
        driver.get("http://www.techproeducation.com");
        //Explicit wait icin olusturdugumuz methodlardan birini kullanalim.
        //Parametre 1: beklemek istedgim element, Parametre 2 o element icin beklenecek max sure
//        waitForVisibility((By.xpath("//input[@type='Search... ']")),15).//org.openqa.selenium.TimeoutException:
//        sendKeys("qa", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:

    }
}
