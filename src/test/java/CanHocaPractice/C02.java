package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void name() {

//1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
//3. Login alanine  "username" yazdirin
        //4. Password alanine "password" yazdirin
        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)

        driver.findElement(By.id("user_login")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.navigate().back();
//6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina "2020-09-10" yazdirin
//9. Pay buttonuna tiklayin
        driver.findElement(By.id("sp_amount")).sendKeys("100",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);



//10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        Assert.assertEquals("The payment was successfully submitted.",driver.findElement(By.id("alert_content")).getText());
    }

}
