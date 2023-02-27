package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Action extends TestBase {
    @Test
    public void ActionsClassHomeWork() {
        //Keyboard Base Actions
        //Homework
        //Yeni Class olusturun ActionsClassHomeWork

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[.='Hover Over Me First!']"))).perform();

        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[.='Link 1'])[1]")).click();
        //Popup mesajini yazdirin
        driver.switchTo().alert().getText();

        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        actions.clickAndHold().perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHold=driver.findElement(By.xpath("//*[.='Click and Hold!']"));
        System.out.println("click  = " +clickAndHold.getText()) ;
        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.id("double-click"))).perform();
    }

}
