package com.naz.TargetDotCom_MouseOver;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/30/18.
 */
public class VerifyMouseOverElement extends DriverWrapperChrome{

    @Test
    public void verifyMouseOver() throws InterruptedException {
        LandingPageTarget landingPageTarget = new LandingPageTarget();
        landingPageTarget.mouseOverAndClickSignIn();
    }
}
