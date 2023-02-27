package CanHocaPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C12 extends TestBase {
    @Test
    public void name() {
        //   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
 driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //  #Ülkeye göre başkentleri doldurun
       WebElement roma= driver.findElement(By.xpath("(//div[text()='Rome'])[2]"));
       WebElement italya= driver.findElement(By.xpath("//*[text()='Italy']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(roma,italya).perform();

        WebElement madrid= driver.findElement(By.xpath("(//*[text()='Madrid'])[2]"));
        WebElement Spain= driver.findElement(By.xpath("//*[text()='Spain']"));
        actions.dragAndDrop(madrid,Spain).perform();

        WebElement Seoul= driver.findElement(By.xpath("(//*[text()='Seoul'])[2]"));
        WebElement SouthKorea= driver.findElement(By.xpath("//*[text()='South Korea']"));
        actions.dragAndDrop(Seoul,SouthKorea).perform();


        WebElement Oslo= driver.findElement(By.xpath("(//*[text()='Oslo'])[2]"));
        WebElement Norway= driver.findElement(By.xpath("//*[text()='Norway']"));
        actions.dragAndDrop(Oslo,Norway).perform();


        WebElement Copenhagen= driver.findElement(By.xpath("(//*[text()='Copenhagen'])[2]"));
        WebElement Denmark= driver.findElement(By.xpath("//*[text()='Denmark']"));
        actions.dragAndDrop(Copenhagen,Denmark).perform();


        WebElement Stockholm= driver.findElement(By.xpath("(//*[text()='Stockholm'])[2]"));
        WebElement Sweden= driver.findElement(By.xpath("//*[text()='Sweden']"));
        actions.dragAndDrop(Stockholm,Sweden).perform();


        WebElement Washington= driver.findElement(By.xpath("(//*[text()='Washington'])[2]"));
        WebElement UnitedStates= driver.findElement(By.xpath("//*[text()='United States']"));
        actions.dragAndDrop(Washington,UnitedStates).perform();

    }


}
