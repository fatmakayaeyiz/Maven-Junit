package practiceErolH_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_TestpagesTest {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        //// Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");



   // Click on  Calculate under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

  //    Type any number in the first input
        WebElement firstNumber = driver.findElement(By.id("number1"));
        firstNumber.sendKeys("30", Keys.TAB,Keys.TAB,"30",Keys.ENTER)  ;
    //    Type any number in the second input
    // Click on Calculate
    // Print the result
        WebElement sonuc= driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println("sonuc = " + sonuc.getText());
        // close driver
        driver.close();
}
 }