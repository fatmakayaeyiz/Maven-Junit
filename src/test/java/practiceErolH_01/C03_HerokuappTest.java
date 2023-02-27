package practiceErolH_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_HerokuappTest {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() {
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
// Add Element butonuna 100 defa basınız
        WebElement addElement = driver.findElement(By.xpath("//*[@onclick='addElement()']"));

// 100 defa basıldığını test ediniz
        for (int i = 1; i < 101; i++) {
            addElement.click();
        }
      List<WebElement> deleteButton =driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(deleteButton.size(),100);

// 90 defa delete butonuna basınız

        for (int i = 1; i < 91; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }
// 90 defa basıldığını doğrulayınız
     List<WebElement> deleteButtonList=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int count= deleteButton.size()-90;
        Assert.assertEquals(count,deleteButtonList.size());
// Sayfayı kapatınız
        driver.close();


    }

}
