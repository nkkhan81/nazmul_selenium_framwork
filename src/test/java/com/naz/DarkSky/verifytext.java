package com.naz.DarkSky;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/31/18.
 */
public class verifytext extends DriverWrapperChrome {

    @Test
    public void verifyTimeText(){
        LandingPage landingPage = new LandingPage();
        landingPage.printElement();
    }
    @Test
    public void verifyLocalTime(){
        LandingPage landingPage = new LandingPage();
        landingPage.compareElement();
    }
}
