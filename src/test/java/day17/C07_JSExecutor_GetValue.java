package day17;

import org.junit.Test;
import utilities.TestBase;

public class C07_JSExecutor_GetValue extends TestBase {


    //      1)getValueTest metotu olustur
//  2)https://www.priceline.com/ a git
//            3)Tarih kısmındaki Yazili metinleri al ve yazdır
    @Test
    public void getValueTest(){
        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");
    }
}
