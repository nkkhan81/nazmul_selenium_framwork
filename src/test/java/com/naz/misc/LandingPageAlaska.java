package com.naz.misc;

import com.naz.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created by nkkhan on 2/7/18.
 */
public class LandingPageAlaska extends BasePage {

    //locators
    private By hotelTab = By.id("tab-hotels");
    private By cityInputField = By.xpath("//input[@id='hotelOnlyToLocation']");
    private By checkInField = By.xpath("//input[@id='hotelFromDate']");
    private By firstHotelField = By.xpath("//article[@id='6284']");
    private By reserveButton = By.xpath("//button[@id='mock-book-button']");




    //methods
    public void inputTextOnCityInputField(String input, int switchIndexNo) throws InterruptedException {
        clickOn(hotelTab);
        setValueToInputField(cityInputField,input);
        Thread.sleep(3000);
        useKey(cityInputField,Keys.TAB);
        useKey(checkInField,Keys.ENTER);
        clickOn(firstHotelField);
        switchToWindow(switchIndexNo);
        clickOn(reserveButton);
        switchToRootWindowAndCloseCurrentWindow();

    }
}
