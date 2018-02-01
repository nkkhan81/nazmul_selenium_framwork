package com.naz.DarkSky;

import com.naz.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by nkkhan on 1/31/18.
 */
public class LandingPage extends BasePage {

    private By element = By.xpath("id(\"timeline\")/div[1]/div[3]/span");

    public void printElement(){
        List<WebElement> lists = getDriver().findElements(element);
        for (WebElement ele : lists){
            System.out.println(ele.getText());
        }
    }

    public void compareElement(){
        List<String> hours = new ArrayList<>();

//        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
//        String currentTime = sdf2.format(Calendar.getInstance().getTime());

        LocalTime time = LocalTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat("a");
        SimpleDateFormat sdfHour = new SimpleDateFormat("hh");

        String ampm = sdf.format(time.getHour()).toLowerCase();

        int hour = Calendar.getInstance().get(Calendar.HOUR);

        int updatedHour = hour;

        System.out.println(hour);

        for (int i=0; i<=12; i++){
            String hourWitAmpm = updatedHour+ampm;
            hours.add(i,hourWitAmpm);
            updatedHour += 2;
        }

        for (int i=0; i<12; i++){
            System.out.println(i+" = "+hours.get(i));
        }

    }
}
