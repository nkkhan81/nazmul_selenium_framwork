package com.naz.ExpediaDotCom;

import com.naz.base.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/29/18.
 */
public class LandingPageExpedia extends BasePage{

    //locators
    private By flightTab = By.xpath("id('wizard-tabs')/div[1]/ul/descendant::li[1]");
    private By originFlightField = By.xpath("//*[@id='flight-origin-hp-flight']");
    private By autoCompleteList = By.className("results-item");


    //methods
    public void clickOnFlightTab(){
        clickOn(flightTab);
    }

    public void selectAirport(String inputText, String searchText) throws InterruptedException {
        selectFromAutoCompleteMenu(originFlightField,inputText,autoCompleteList,searchText);
        System.out.println(getTextFromElement(originFlightField));
    }
}
