package com.naz.browserInvocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by nkkhan on 1/24/18.
 */
public class DriverWrapperSafari {
    private static WebDriver safariDriver;
    private static String url = "https://www.facebook.com/";

    public static WebDriver getSafariDriver() {
        return safariDriver;
    }

    public static String getUrl() {
        return url;
    }

    @BeforeClass
    public void driverInitialization(){
//        System.setProperty("webdriver.chrome.driver","/Users/nkkhan/Projects/technoSoft/webDrivers/chromedriver");
        this.safariDriver = new SafariDriver();
        safariDriver.navigate().to(url);
    }

    @AfterClass
    public void tearDown(){
        safariDriver.quit();
    }
}
