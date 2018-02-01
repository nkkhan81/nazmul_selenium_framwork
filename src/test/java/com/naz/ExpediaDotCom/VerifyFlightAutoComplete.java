package com.naz.ExpediaDotCom;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/29/18.
 */
public class VerifyFlightAutoComplete extends DriverWrapperChrome{

    //verifying "select a value from autoComplete field
    @Test
    public void verifyAutoComplete() throws InterruptedException {
        LandingPageExpedia landingPageExpedia = new LandingPageExpedia();

        landingPageExpedia.clickOnFlightTab();
        Thread.sleep(2000);

        landingPageExpedia.selectAirport("new york", "(JFK) John F. Kennedy Intl.");
        Thread.sleep(2000);
    }
}
