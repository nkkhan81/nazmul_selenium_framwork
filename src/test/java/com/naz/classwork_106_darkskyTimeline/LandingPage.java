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

        //List of webElement for darksky.net timeline
        List<WebElement> darkSkyHours = getDriver().findElements(element);
        //List of a String which contains local time hours with am pm
        List<String> localComputerHours = new ArrayList<>();

        //creating a local time instance
        LocalTime time = LocalTime.now();
        //formatting the time as hour with am pm
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ha");

        //this variable will increase with the following for loop for making a timeline for local time
        int addHour = 0;

        //specifying the local timeline length
        for(int i=0; i<12; i++){
            //creating a string(hourWithAmpm) with local time and formatter.
            //adding 2 hour and create a string for every time loop runs.
            String hourWithAmpm = dtf.format(time.plusHours(addHour)).toLowerCase();

            //adding times in a list for every two hour from current time
            localComputerHours.add(i,hourWithAmpm);
            //updating addHour variable
            addHour += 2;
        }

        //Comparing both list. This is the header
        System.out.println("\nLocalTime  ==>  DarkskyTimeline");
        System.out.println("-------------------------------");

        //printing first element from both list manually
        System.out.println(localComputerHours.get(0)+"  ==>   "+darkSkyHours.get(0).getText());

        for (int i=1; i<darkSkyHours.size(); i++){

            //assigned a String variable for the text value of  WebElement list(hourFromWebTimeline)
            String hourFromWebTimeline = darkSkyHours.get(i).getText();

            //assigned a String variable for the value of hourFromLocalTime ArrayList
            String hourFromLocalTime = localComputerHours.get(i);


            //if value of both list are equal than print one element from each list in same line
            if (hourFromWebTimeline.equals(hourFromLocalTime)){
                System.out.println(hourFromWebTimeline+"  ==>   "+hourFromLocalTime);
            }else {
                Assert.fail();
            }
        }
    }
}
