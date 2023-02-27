package PracticeBurakH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C07_DropDownOptions {
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


        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
// dropdown'dan "Baby" secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");
// sectiginiz option'i yazdirin
      String sectigimOption=  select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);

// dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
       List<WebElement> tumOptionlar= select.getOptions();
       int actualOptionSayisi=tumOptionlar.size();

       int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);
        }

    @After
    public void after() {
       driver.close();
    }
}
