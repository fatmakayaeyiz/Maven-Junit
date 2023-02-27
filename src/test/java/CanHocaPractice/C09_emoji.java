package CanHocaPractice;

import org.junit.Test;
import utilities.TestBase;

public class C09_emoji extends TestBase {
    @Test
    public void name() {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
//maximize the web side

// ikinci emojiye tıklayın
        driver.switchTo().frame(0);

// ikinci emoji altındaki tüm öğelere tıklayın
// ana iframe'e geri dön
//formu doldurun,(Formu istediğiniz metinlerle doldurun)
// uygula butonuna tıklayın
    }

}
