package CanHocaPractice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05 extends TestBase {
    @Test
    public void name() {
        //Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");
        //    Then new butonuna basar
        driver.findElement(By.xpath("//*[text()='New']")).click();
        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        //    When Create tusuna basar
        Faker faker=new Faker();
        String isim=faker.name().firstName();
        String soyisim=faker.name().lastName();
        driver.findElement(By.id("DTE_Field_first_name")).sendKeys(isim,Keys.TAB,soyisim,Keys.TAB,
                "QA",Keys.TAB,"TURKEY",Keys.TAB,"Hi!",Keys.TAB,"2023-01-11",Keys.TAB,"120000",Keys.TAB,Keys.ENTER);

        //    Then Kullanıcının eklendiğini doğrular.


      driver.findElement(By.xpath("//*[text()='Search:']")).sendKeys(isim," ",soyisim);

    WebElement kullaniciAdi= driver.findElement(By.xpath("//*[@class='sorting_1']"));
            Assert.assertTrue(kullaniciAdi.isDisplayed());
//
//
//        //    And Eklediği kullanıcı kaydını siler
        kullaniciAdi.click();
        driver.findElement(By.xpath("//span[.='Delete']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        //    Then Kullanıcinin silindiğini doğrular.



        String noUserText = driver.findElement(By.xpath("//*[@class='dataTables_empty']")).getText();
        String search=driver.findElement(By.xpath("//input[@type='search']")).getText();
        Assert.assertFalse(search.contains(noUserText));
        }


    }


