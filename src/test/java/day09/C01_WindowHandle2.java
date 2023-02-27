package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void windowHandle(){
//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle=driver.getWindowHandle();
//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);
//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

//        Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);
        //İKİNCİ PENCERE ACILIR VE İKİNCİ PENCEREDE İŞLEM YAPMAK İSTEDİGİMDEN, O PENCEREYE SWİTCH-GECİS- YAPMALİYİZ
        switchToWindow(1);

//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
           String actualwindow2Title= driver.getTitle();
            String expectedWindow2Title= "New Window";
            Assert.assertEquals(expectedWindow2Title, actualwindow2Title);
    }
}
