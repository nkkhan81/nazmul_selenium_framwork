package com.naz.browserInvocation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/24/18.
 */
public class SampleTestNGScenarioPageTitle extends DriverWrapperSafari {

    @Test
    public void testScenario(){
        String pageTitle = getSafariDriver().getTitle();
        Assert.assertEquals(pageTitle,"Facebook - Log in","Invalid URL found. please check the URL");
    }
}
