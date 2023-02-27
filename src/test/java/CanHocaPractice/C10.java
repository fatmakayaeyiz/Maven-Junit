package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C10 extends TestBase {
    @Test
    public void name() {
//        url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
//        ilk pencereyi al
        String ilkPencere = driver.getWindowHandle();

//        "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
//        setteki tüm pencereyi al
        String ikincePencere = driver.getWindowHandle();
//        diğer pencereye geç
        driver.switchTo().window(ilkPencere);
//        e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //        Gönder düğmesine tıklayarak

        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));


            driver.findElement(By.name("emailid")).sendKeys("somepne@gmail.com", Keys.ENTER);


//        ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula

            String actualResult = driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();
            String expectedResult = "This access is valid only for 20 days.";
            Assert.assertEquals(expectedResult, actualResult);
//        Tekrar ilk pencereye geç
            driver.switchTo().window(ilkPencere);

//        İlk pencerede olduğunu doğrula
            Assert.assertEquals("https://demo.guru99.com/popup.php",driver.getCurrentUrl());
        }

    }

