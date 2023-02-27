package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C11 extends TestBase {
    @Test
    public void name() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        String window1Handle =driver.getWindowHandle();
//Alerts, Frame & Windows Butonuna click yap
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();

//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement gorunurluk=driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']"));
Assert.assertTrue(gorunurluk.isDisplayed());
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap

     actions.sendKeys(Keys.PAGE_DOWN).perform();
     WebElement browserWin=   driver.findElement(By.xpath("//span[text()='Browser Windows']"));
browserWin.click();

//New Tab butonunun görünür olduğunu doğrula
        WebElement newTab=driver.findElement(By.id("tabButton"));
        newTab.isDisplayed();
//New Tab butonuna click yap
        newTab.click();
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> windowhandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowhandles.get(1));

        driver.findElement(By.id("sampleHeading")).isDisplayed();
//İlk Tab'a geri dön
        driver.switchTo().window(window1Handle);
////New Tab butonunun görünür olduğunu doğrula
        newTab.isDisplayed();
    }

}
