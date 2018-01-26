 package com.naz.fbRegistration_classwork_104;

import com.naz.facebook.BasePage;
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
    private By errorMsgGender = By.xpath("/*[@class='uiContextualLayer uiContextualLayerLeft']/descendant::div[2]");
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

    public void selectMonthFromDropdown(String month){
        selectDropDownMenu(selectMonthField).selectByVisibleText(month);
    }

    public void selectDayFromDropdown(String day){
        selectDropDownMenu(selectDayField).selectByValue(day);
    }

    public void selectYearFromDropdown(String year){
        selectDropDownMenu(selectYearField).selectByVisibleText(year);
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

    public void selectDoB(String month, String day, String year){
        selectMonthFromDropdown(month);
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
