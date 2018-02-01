package com.naz.facebook;

import com.naz.base.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/24/18.
 */
public class SignUpPage extends BasePage {

    //locators
    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.xpath("//input[@name='lastname']");
    private By mobileOrEmailField = By.xpath("//*[@id='u_0_r']");
    private By newPasswordField = By.xpath("//input[contains(@autocomplete,'new')]");
    private By createAccountButton = By.xpath("//button[@name='websubmit']");
    private By firstNameFieldDefaultText = By.name("firstname");

    //Methods
    public  void insertFirstName(String firstName){
        setValueToInputField(firstNameField,firstName);
    }
    public void insertLastName(String lastName){
        setValueToInputField(lastNameField,lastName);
    }
    public void insertMobileNumber(String mobileNumber){
        setValueToInputField(mobileOrEmailField,mobileNumber);
    }
    public void insertNewPassword(String newPassword){
        setValueToInputField(newPasswordField,newPassword);
    }
    public void clickOnCreateAccountButton(){
        clickOn(createAccountButton);
    }
    public void getDefaultTextFirstNameField(String attributeName){
        System.out.println(getAttributeValue(firstNameFieldDefaultText,attributeName));
    }

    public void signUpFacebook(String firstName,String lastName, String mobileNumber, String newPassword){
        insertFirstName(firstName);
        insertLastName(lastName);
        insertMobileNumber(mobileNumber);
        insertNewPassword(newPassword);
        clickOnCreateAccountButton();
    }
}
