 package com.naz.classwork_104_fbRegistration;

import com.naz.base.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/24/18.
 */
public class LandingPageForFbReg extends BasePage {

    //LandingPage is basically the home page
    //it contains element locator and methods for utilizing those elements

    //Locators
    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.cssSelector("input[name='lastname']");
    private By mobileNumberField = By.cssSelector("input[name='reg_email__']");
    private By newPasswordField = By.cssSelector("input[aria-label='New password']");
    private By selectMonthField = By.cssSelector("select#month");
    private By selectDayField = By.cssSelector("select#day");
    private By selectYearField = By.cssSelector("select#year");
    private By createAccountButton = By.cssSelector("button[name='websubmit']");
    private By errorMsgGender = By.xpath("//*[@class='uiContextualLayer uiContextualLayerLeft']/descendant::div[2]");
//    private By errorMsgGender = By.tagName("div");

    //individual method
    public void insertFirstName(String firstName){
        setValueToInputField(firstNameField,firstName);
    }

    public void insertLastname(String lastName){
        setValueToInputField(lastNameField,lastName);
    }

    public void insertMobileNumber(String mobileNumber){
        setValueToInputField(mobileNumberField,mobileNumber);
    }

    public void insertNewPassword(String password){
        setValueToInputField(newPasswordField,password);
    }

    public void selectMonthFromDropdown(int monthIndexNo){
        selectDropDownMenuByIndex(selectMonthField, monthIndexNo);
    }

    public void selectDayFromDropdown(String day){
        selectDropDownMenuByVisibleText(selectDayField, day);
    }

    public void selectYearFromDropdown(String year){
        selectDropDownMenuByVisibleText(selectYearField, year);
    }

    public void clickOnCreateAccount(){
        clickOn(createAccountButton);
    }


    //combine method for login facebook
    public void insertInputField(String firstName, String lastName, String mobileNumber, String password){
        insertFirstName(firstName);
        insertLastname(lastName);
        insertMobileNumber(mobileNumber);
        insertNewPassword(password);
    }

    public void selectDoB(int monthIndexNo, String day, String year){
        selectMonthFromDropdown(monthIndexNo);
        selectDayFromDropdown(day);
        selectYearFromDropdown(year);
        clickOnCreateAccount();
    }

    public String getErrorMsgGender(){
        if (!isElementDisplayed(errorMsgGender)){
            return "Error message not displayed";
        }else {
            return getTextFromElement(errorMsgGender);
        }
    }

//    public String getErrorMsgGender(){
//        return findElementByList(errorMsgGender,"Please choose a gender. You can change who can see this later.").getText();
//    }



}
