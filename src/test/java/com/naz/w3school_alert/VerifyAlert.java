package com.naz.w3school_alert;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/30/18.
 */
public class VerifyAlert extends DriverWrapperChrome{

    @Test
    public void verifyFrameAndAlert() throws InterruptedException {
        IFramAndAlertPage iFramAlert = new IFramAndAlertPage();
        iFramAlert.FrameAndVerifyAlert("test data");

        iFramAlert.additionalAction();
    }
}
