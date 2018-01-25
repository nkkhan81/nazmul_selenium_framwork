package com.naz.browserInvocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by nkkhan on 1/24/18.
 */
public class DriverWrapperFirefox {
    private static WebDriver firefoxDriver;
    private static String url = "https://www.facebook.com/";

    public static WebDriver getFirefoxDriver() {
        return firefoxDriver;
    }

    public static String getUrl() {
        return url;
    }

    @BeforeClass
    public void driverInitialization(){
        System.setProperty("webdriver.gecko.driver","/Users/nkkhan/Projects/technoSoft/webDrivers/geckodriver");
        this.firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to(url);
    }

    @AfterClass
    public void tearDown(){
        firefoxDriver.quit();
    }
}
