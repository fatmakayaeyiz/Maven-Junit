package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Collections;
import java.util.Set;

public class C02 extends TestBase {
    @Test
    public void name() {

    //https://testcenter.techproeducation.com/index.php?page=multiple-windows
driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        //Title in ‘Windows’ oldugunu test edin
 String actualResult=driver.getTitle();
 String expectedResult="Windows";
        Assert.assertTrue(actualResult.equals(expectedResult));
        //Click here a tiklayin
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        switchToWindow(1);
        String newWindow=driver.getTitle();
        Assert.assertEquals("New Window",newWindow);
        }
    }


