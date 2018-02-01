package com.naz.facebook;

import com.naz.base.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/24/18.
 */
public class LandingPage extends BasePage {

    //LandingPage is basically the home page
    //it contains element locator and methods for utilizing those elements

    //Locators
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    private By signUpLink = By.linkText("Sign Up");
    private By forgotAccountLink = By.linkText("Forgot account?");
    private By createPageForCelebrity = By.linkText("Create a Page");
    private By dataPolicyLink = By.cssSelector("a#privacy-link");
    private By signUpButtonOnPrivacyPage = By.linkText("Sign Up");

    //individual method
    public void clickOnDataPolicyLink(){
        clickOn(dataPolicyLink);
    }

    public void clickOnSignUpButtonOnPrivacyPage(){
        clickOn(signUpButtonOnPrivacyPage);
    }

    public void insertEmail(String email){
        setValueToInputField(emailField,email);
    }

    public void insertPassword(String password){
        setValueToInputField(passwordField,password);
    }

    public void clickOnLogin(){
        clickOn(loginButton);
    }

    public void clickOnSignUpLink(){
        clickOn(signUpLink);
    }

    public void clickOnForgotAccountLink(String comparableText){
        findElementByList(forgotAccountLink,comparableText).click();
    }

    //combine method for login facebook
    public void loginFacebook(String email, String password){
        insertEmail(email);
        insertPassword(password);
        clickOnLogin();
    }



}
