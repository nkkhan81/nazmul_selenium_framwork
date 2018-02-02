package com.naz.classwork_106_darkskyTimeline;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/31/18.
 */
public class verifytext extends DriverWrapperChrome {

    @Test
    public void verifyTimelineText(){
        LandingPage landingPage = new LandingPage();
        landingPage.printTimelineText();
    }
    @Test
    public void verifyTimeLine(){
        LandingPage landingPage = new LandingPage();
        landingPage.compareTimeLineWithLocalTime();
    }
}
