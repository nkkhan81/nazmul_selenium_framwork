package com.naz.classwork_106_darkskyTimeline;

import com.naz.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkkhan on 1/31/18.
 */
public class LandingPage extends BasePage {

    private By element = By.xpath("id('timeline')/div[1]/div[3]/span/span");

    public void printTimelineText(){
        List<WebElement> lists = getDriver().findElements(element);
        for (WebElement ele : lists){
            System.out.println(ele.getText());
        }
    }

    public void compareTimeLineWithLocalTime(){

        List<WebElement> darkSkyHours = getDriver().findElements(element);


        List<String> localComputerHours = new ArrayList<>();

        LocalTime time = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ha");

        int addHour = 0;

        for(int i=0; i<12; i++){
            String hourWithAmpm = dtf.format(time.plusHours(addHour)).toLowerCase();
            localComputerHours.add(i,hourWithAmpm);
            addHour += 2;
        }
        for (int i=1; i<darkSkyHours.size(); i++){
            String webHour = darkSkyHours.get(i).getText();
            String localHour = localComputerHours.get(i);
            if (webHour.equals(localHour)){
                System.out.println(webHour+" = "+localHour);
            }else {
                Assert.fail();
            }
        }
    }
}
