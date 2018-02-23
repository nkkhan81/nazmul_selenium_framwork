package com.naz.misc;

import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 2/7/18.
 */
public class FluentWaitDemo extends DriverWrapperChrome{


    @Test
    public void verifyFluentWait() throws InterruptedException {
        LandingPageAlaska alaska = new LandingPageAlaska();
        alaska.inputTextOnCityInputField("nyc",1);
    }
}
