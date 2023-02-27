package PracticeBurakH;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C09_FileDownload extends TestBase {
    @Test
    public void test02() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();



        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

        //                      "C:\Users\BURAK                        \Downloads\some-file.txt"

        String farklıKısım=System.getProperty("user.home");
        String ortakKısım="\\Downloads\\some-file.txt";

        String dosyaYolu2=farklıKısım+ortakKısım;



        // String dosyaYolu="C:\\Users\\BURAK\\Downloads\\some-file.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));


    }
}