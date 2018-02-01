package com.naz.classwork_105_amazoneSignIn;

import com.naz.base.DriverWrapperChrome;
import com.naz.facebook.LandingPage;
import com.naz.facebook.LoginPage;
import com.naz.facebook.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/24/18.
 */
public class VerifyInvalidLogin_amazon extends DriverWrapperChrome {


    @Test
    public void verifyLogin() throws InterruptedException {
        LandingPage_Amazon landingPage = new LandingPage_Amazon();
        landingPage.mouseOverSignIn("testcom","sdfsfgfgfg");
        Assert.assertEquals(landingPage.getWarningMessage(),"There was a problem We cannot find an account with that email address");
    }


}
