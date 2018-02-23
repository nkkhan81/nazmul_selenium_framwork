package com.naz.hotelsDotCom;

import com.naz.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.ParseException;

/**
 * Created by nkkhan on 1/29/18.
 */
public class LandingPageHotels extends BasePage{

    //Locators
    private By checkInField = By.cssSelector("input.query-localised-check-in");
    private By daysFieldInDatePicker = By.xpath("//div[@class='widget-datepicker-bd']/descendant::a");
    private String dayPattern = "d";
    private By dateInput = By.name("q-localised-check-in");
    private By calendarHeader = By.xpath("//div[@class='widget-daterange-cont']/div[1]/div/div");
    private By nextButton = By.xpath("/html/body/div[7]/div[1]/div[2]/div[1]/button[2]");
    private By noOfNight = By.xpath("//span[@class='widget-query-num-nights']");


    //method
    public void selectDateFromCheckInField() throws InterruptedException {
        selectCurrentDateFromDatePicker(dayPattern,checkInField, daysFieldInDatePicker);
    }

    public void selectCustomDate(String dateMdyyyy) throws ParseException {
        selectCustomDateFromDatePicker(dateMdyyyy,dateInput,calendarHeader,nextButton, daysFieldInDatePicker);
        Assert.assertTrue(Integer.parseInt(getTextFromElement(noOfNight))>0);
    }
}
