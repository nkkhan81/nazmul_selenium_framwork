package com.naz.facebook;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/29/18.
 */
public class VerifySwitchingWindow extends DriverWrapperChrome{
    @Test
    public void switchToWindowAndBackToRoot() throws InterruptedException {
        LandingPage landingPage = new LandingPage();

        landingPage.clickOnDataPolicyLink();
        Thread.sleep(2000);

        landingPage.switchToWindow(1);
        Thread.sleep(2000);

        landingPage.clickOnSignUpButtonOnPrivacyPage();
        Thread.sleep(2000);

        landingPage.switchToRootWindowAndCloseCurrentWindow();
        Thread.sleep(2000);

    }

}
