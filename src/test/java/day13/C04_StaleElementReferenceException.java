package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    StateElementReferenceException
StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
Sayfayı yenilediğimizde,
sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
Elemanı tekrar bulmak.
     */

    @Test
    public void staleElementReferenceExceptionTest1(){
        driver.get("http://www.techproeducation.com");
        //LMS LOGIN linkine tıkla ve o sayfanin URL inin lms icerdigini test et

        WebElement lmsLoginLink=driver.findElement(By.linkText("LMS LOGIN"));
        lmsLoginLink.click();
        waitFor(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(3);
        //Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar don
        driver.navigate().back();//Tekrar ana sayfaya gittik
        waitFor(3);
        lmsLoginLink.click();//LMS e git
        /*
        lmsLoginLink linkini sayfa yenilendikden(back()) sonra kullandigim icin StateElementReferenceException aldim
         */
    }
        @Test
        public void staleElementReferenceExceptionTest2(){
            driver.get("http://www.techproeducation.com");
            //LMS LOGIN linkine tıkla ve o sayfanin URL inin lms icerdigini test et

            WebElement lmsLoginLink=driver.findElement(By.linkText("LMS LOGIN"));
            lmsLoginLink.click();
            waitFor(3);
            driver.navigate().refresh();
            waitFor(5);
         //SAYFA YENİLENMEDEN ONCE BULDUGUM ELEMENTİ, SAYFA YENİLENDİKTEN SONRA KULLANMMAK İSTEDİM
            lmsLoginLink.click();//org.openqa.selenium.StaleElementReferenceException

            //COZUM ESKI(STALE EELEMENT) ELEMENTİ TEKRAR LOCATE ET
            //            WebElement lmsLoginLink=driver.findElement(By.linkText("LMS LOGIN"));

}}