package com.naz.facebook;

import com.naz.base.DriverWrapperChrome;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/24/18.
 */
public class VerifyInvalidLogin extends DriverWrapperChrome {

    LandingPage landingPage = new LandingPage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();

    @Test
    public void verifyLogin(){
        landingPage.loginFacebook("test@gmail.com","test123");
        Assert.assertEquals(loginPage.getRecoverAccountLinkText(),"Recover Account");
    }

    @Test
    public void verifySignUp() throws InterruptedException {
        landingPage.clickOnSignUpLink();
        signUpPage.signUpFacebook("John","Doe","2222222222","test222");
        signUpPage.getDefaultTextFirstNameField("aria-label");
        signUpPage.verifyGenderErrorMessage();
    }


    @Test
    public void getDefaultText(){

    }

    @Test
    public void clickOnForgotAccount(){
        landingPage.clickOnForgotAccountLink("Forgot account?");
    }
}
