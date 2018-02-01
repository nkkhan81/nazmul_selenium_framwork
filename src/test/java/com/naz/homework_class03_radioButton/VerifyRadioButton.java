package com.naz.homework_class03_radioButton;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/25/18.
 */
public class VerifyRadioButton extends DriverWrapperChrome {

    FbLandingPageHW fbLandingPage = new FbLandingPageHW();

    @Test
    public void verifyGenderSelection(){
        fbLandingPage.clickOnMaleRadioButton();
    }
}
