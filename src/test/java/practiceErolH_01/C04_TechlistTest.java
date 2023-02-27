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

public class C04_TechlistTest {
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
    //go to url : https://www.techlistic.com/p/selenium-practice-form.html
    driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
//fill the firstname// soyadını doldur

//fill the lastname//check the gender//cinsiyeti kontrol et
//check the experience//deneyimi kontrol et
//fill the date// tarihi doldur
//choose your profession -> Automation Tester//mesleğinizi seçin -> Otomasyon Test Cihazı
//choose your tool -> Selenium Webdriver// aracınızı seçin -> Selenium Webdriver
//choose your continent -> Antartica//kıtanızı seçin -> Antarktika
//choose your command  -> Browser Commands//komutunuzu seçin -> Tarayıcı Komutları
//click submit button//gönder düğmesine tıklayın
    WebElement firstname = driver.findElement(By.xpath("//*[@name='firstname']"));
    firstname.sendKeys("Erol",Keys.TAB,"Evren",Keys.TAB,Keys.ARROW_RIGHT,Keys.TAB,
            Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.TAB,"12/12/2022",Keys.TAB,Keys.TAB
            ,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,"Africa",Keys.TAB,Keys.LEFT_CONTROL,
            Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);

}
}

