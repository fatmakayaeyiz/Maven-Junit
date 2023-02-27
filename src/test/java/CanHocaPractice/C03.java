package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void name() {
//1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.TAB, "secret_sauce");
//4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
//6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String secilenUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        String sepetekiUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(sepetekiUrun, secilenUrun);
//9. Sayfayi kapatin
        driver.close();
    }

}
