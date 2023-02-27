package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_KeyboardActions2 extends TestBase {
    @Test
    public void test() {
        //Bir Class olusturalim KeyboardActions2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //video’yu gorecek kadar asagi inin
        new Actions(driver).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


        //videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='ytp-progress-bar']")).isDisplayed());

    }

}
