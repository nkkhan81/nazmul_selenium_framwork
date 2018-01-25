package com.naz.browserInvocation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/24/18.
 */
public class SampleTestNGScenarioChrome extends DriverWrapperChrome {

    @Test
    public void testScenario(){
        String currentURL = getChromeDriver().getCurrentUrl();
        Assert.assertEquals(currentURL,getUrl(),"Invalid URL found. please check the URL");
    }
}
