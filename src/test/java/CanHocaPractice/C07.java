package CanHocaPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C07 extends TestBase {
    @Test
    public void name() {
        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
WebElement ddm =driver.findElement(By.id("dropdown-class-example"));
ddm.isDisplayed();
        //3-Option3 ü seçin.
        Select select=new Select(ddm);
        select.selectByVisibleText("Option3");

        //4-Option3 ün seçili olduğunu doğrulayın.
        String option3 =select.getFirstSelectedOption().getText();
        Assert.assertTrue(option3.contains("Option3"));

    }



}
