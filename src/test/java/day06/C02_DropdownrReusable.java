package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownrReusable {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //REUSABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim.
    public void selectFromDropdown(WebElement dropdown, String secenek) {
        //WebElement year=driver.findElement(By.xpath("//*[@id='year']")),"2005");
        //WebElement ay =driver.findElement(By.xpath("//*[@id='month']")),"Janvary");
        //WebElement gun=driver.findElement(By.xpath("//*[@id='day']")),"12");

       //Gonderilen dropdown elementinin tum optionslari alinir
        List<WebElement> options= dropdown.findElements(By.tagName("option"));//tum option tagli elementleri aliyorum
        for (WebElement eachOption : options){
            if (eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }


    }
    @Test
    public void selectFromDropdown(){

    }
}
