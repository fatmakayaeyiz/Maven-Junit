package CanHocaPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C06_Shadow extends TestBase {
    @Test
    public void name() {
//        1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");
//        2-"BOOKS" başlığının görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()='BOOKS']")).isDisplayed();
//        3-Arama çubuğunda "Selenium" u aratın.
        driver.findElement(By.id("input")).sendKeys("Selenium", Keys.ENTER);

//        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.

    }

}
