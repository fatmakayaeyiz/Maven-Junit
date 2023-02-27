package practiceErolH_01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C17_Actions extends TestBase {
    @Test
    public void Actions() {
        //    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");
        //    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
       WebElement maviKutu= driver.findElement(By.id("div2"));
        Actions action = new Actions(driver);
        action.moveToElement(maviKutu).perform();
        waitFor(3);
        //    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClicked = driver.findElement(By.xpath("//*[@name='dblClick']"));
        action.doubleClick(doubleClicked).build().perform();

       Assert.assertEquals("Double Clicked !!",driver.switchTo().alert().getText());
        //    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
        //    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda
        //    "Dropped!" yazildigini dogrulayin
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        action.dragAndDrop(drag,drop).perform();
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }

}
