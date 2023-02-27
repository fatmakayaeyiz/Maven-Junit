package homeWork;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_faker extends TestBase {
    @Test
    public void fakerTest() {
        //Faker Kutuphanesi HOMEWORK
//Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
//degerler uretmemize imkan tanir.
//Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
//"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
//“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
//“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        Faker faker=new Faker();
        String mail=faker.internet().emailAddress();
        driver.findElement(By.xpath("//*[@name='firstname']")).
                sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName()
                        ,Keys.TAB,mail);
            waitFor(2);

//“email” onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
        driver.findElement(By.xpath("//*[@name='reg_email_confirmation__']")).sendKeys(Keys.ENTER,mail,
                Keys.TAB,"1234567",
                Keys.TAB,Keys.TAB,"1",Keys.TAB,"Nis",Keys.TAB,"2013",Keys.TAB,Keys.TAB,Keys.SPACE,
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
////Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.


        List<WebElement> radioButtonGrup = driver.findElements(By.xpath("//*[@type='radio']"));
        for (WebElement w : radioButtonGrup){
            System.out.println(w.isSelected());
        }
        Assert.assertTrue(radioButtonGrup.get(0).isSelected());
        Assert.assertFalse(radioButtonGrup.get(1).isSelected());
        Assert.assertFalse(radioButtonGrup.get(2).isSelected());
    }

//Sayfayi kapatin

    }

