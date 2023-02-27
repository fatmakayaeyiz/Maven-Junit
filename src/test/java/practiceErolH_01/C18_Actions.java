package practiceErolH_01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C18_Actions extends TestBase {
    @Test
    public void name() {
        //        -http://spicejet.com/ sayfasına gidelim
driver.get("http://spicejet.com/");
        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        Actions actions=new Actions(driver);
      WebElement fleet= driver.findElement(By.xpath("//*[text()='Fleet']"));
      actions.moveToElement(fleet).click().perform();

        //        -Sayfa başlığının Fleet içerdiğini test edelim

    }
    }

