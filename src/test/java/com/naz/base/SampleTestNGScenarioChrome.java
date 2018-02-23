package com.naz.base;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 1/24/18.
 */
public class SampleTestNGScenarioChrome extends DriverWrapperChrome {

    //Chrome invocation
    @Test
    public void testScenarioChrome(){
        String currentURL = getChromeDriver().getCurrentUrl();
        Assert.assertEquals(currentURL, getFacebook_url(),"Invalid URL found. please check the URL");
    }

    //Firefox invocation
    @Test
    public void testScenarioFirefox(){
        String currentURL = DriverWrapperFirefox.getFirefoxDriver().getCurrentUrl();
        Assert.assertEquals(currentURL, getFacebook_url(),"Invalid URL found. please check the URL");
    }

    //Safari invocation
    @Test
    public void testScenarioSafari(){
        String currentURL = DriverWrapperSafari.getSafariDriver().getCurrentUrl();
        Assert.assertEquals(currentURL, getFacebook_url(),"Invalid URL found. please check the URL");
    }


    //test for getting the page Title
    @Test
    public void testScenarioGetPageTitle(){
        String pageTitle = DriverWrapperSafari.getSafariDriver().getTitle();
        Assert.assertEquals(pageTitle,"Facebook - Log in","Invalid URL found. please check the URL");
    }
}
