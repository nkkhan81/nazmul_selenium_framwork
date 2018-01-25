package com.naz.facebook;

import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/24/18.
 */
public class LoginPage extends BasePage {

    //Locators
    By recoverAccountLink = By.linkText("Recover Your Account");

    //Methods
    public String getRecoverAccountLinkText(){
        return getTextFromElement(recoverAccountLink);
    }
}
