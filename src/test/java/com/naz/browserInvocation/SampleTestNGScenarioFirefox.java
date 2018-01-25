package com.naz.browserInvocation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/24/18.
 */
public class SampleTestNGScenarioFirefox extends DriverWrapperFirefox {

    @Test
    public void testScenario(){
        String currentURL = getFirefoxDriver().getCurrentUrl();
        Assert.assertEquals(currentURL,getUrl(),"Invalid URL found. please check the URL");
    }
}
