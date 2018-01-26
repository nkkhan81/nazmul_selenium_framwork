package com.naz.fbRegistration_classwork_104;

import com.naz.browserInvocation.DriverWrapperChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/26/18.
 */
public class verifyRegistration extends DriverWrapperChrome{

/*  Feature: Registration
    Scenario: User should not be able to register without gender selection
    Step 1: Enter First Name
    Step 2: Enter Last Name
    Step 3: Enter Mobile Number
    Step 4: Enter Password
    Step 5: Select Birthday
    Step 6: Click on Create Account button
    Step 7: Assertion = Verify missing gender error message displays as
"Please choose a gender. You can change who can see this later."*/

    @Test
    public void verifyRegistration() throws InterruptedException {
        LandingPageForFbReg landingPageFb = new LandingPageForFbReg();

        landingPageFb.insertInputField("john","doe","2344567456","Faceoff2233");
        Thread.sleep(1000);

        landingPageFb.selectDoB("Mar","26","1990");
        Thread.sleep(2000);

        Assert.assertEquals(landingPageFb.getErrorMsgGender(),"Please choose a gender. You can change who can see this later.");
    }

    //sometimes the error message popup for another field, in that case test test fails because
    //locator unable to find the element.

}
