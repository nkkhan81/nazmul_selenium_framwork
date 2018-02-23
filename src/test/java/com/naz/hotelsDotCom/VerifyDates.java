package com.naz.hotelsDotCom;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

import java.text.ParseException;

/**
 * Created by nkkhan on 1/29/18.
 */
public class VerifyDates extends DriverWrapperChrome {

    @Test
    public void verifyCurrentDateFromDatePicker() throws InterruptedException {
        LandingPageHotels landingPageH = new LandingPageHotels();
        landingPageH.selectDateFromCheckInField();
    }

    @Test
    public void verifyCustomDate() {
        LandingPageHotels landingPageH = new LandingPageHotels();
        try {
            landingPageH.selectCustomDate("2-3-2019");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
