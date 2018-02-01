package com.naz.classwork_105_amazoneSignIn;

import com.naz.base.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/27/18.
 */
public class LandingPage_Amazon extends BasePage {

    /*Classwork:
1. Goto Amazon.com
2. Hover over hello sign in header
3. Click on Sign in button
4. Enter invalid email
5. Enter invalid password
6. Verify error message "There was a problem
We cannot find an account with that email address"*/

    //Locators
    private By accountAndList = By.xpath("//*[@id='nav-tools']/descendant::a[2]");
    private By mouseOverSignInButton = By.id("nav-flyout-ya-signin");
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");
    private By warningHeader = By.className("a-alert-heading");
    private By warningBody = By.className("a-list-item");


    //individual method
    public void mouseOverOnAccount() throws InterruptedException {
        mouseOverAndClick(accountAndList,mouseOverSignInButton);
    }

    public void insertEmail(String email){
        setValueToInputField(emailField,email);
    }

    public void insertPassword(String password){
        setValueToInputField(passwordField,password);
    }

    public void clickOnSignIn(){
        clickOn(signInButton);
    }

    //combineMethod
    public void mouseOverSignIn(String email, String password) throws InterruptedException {
        mouseOverOnAccount();
        insertEmail(email);
        Thread.sleep(1000);
        insertPassword(password);
        Thread.sleep(1000);
        clickOnSignIn();
        Thread.sleep(1000);
    }

    public String getWarningMessage(){
        String header = getTextFromElement(warningHeader);
        String body = getTextFromElement(warningBody);
        return header+" "+body;
    }
}
