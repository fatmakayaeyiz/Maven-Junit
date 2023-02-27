package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C08 extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //   // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.xpath("//*[.='Alert with OK ']")).click();
        driver.findElement(By.id("OKTab")).click();

        //    accept Alert(I am an alert box!) and print alert on console
//Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
//"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("//a[.='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//*[.='click the button to display a confirm box ']")).click();
        //    cancel Alert  (Press a Button !)
//Alert'ü kapatın
        driver.switchTo().alert().dismiss();
        //"Alert with Textbox" and click 'click the button to demonstrate the prompt box'
//"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//*[.='click the button to demonstrate the prompt box ']")).click();

        //    and then sendKeys 'TechProEducation' (Please enter your name)
//Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("TechproEducation");

        driver.switchTo().alert().accept();
        waitFor(3);
//Gönderdiğiniz metnin isminizi içerdiğini doğrulayın


        String actualResult = driver.findElement(By.id("demo1")).getText();

        String expectedResult = "TechproEducation";
        Assert.assertTrue(actualResult.contains(expectedResult));
        //    finally print on console this mesaaje "Hello TechproEducation How are you today"
        System.out.println(driver.findElement(By.xpath("//*[.='Hello TechproEducation How are you today']")).getText());
    }


}
