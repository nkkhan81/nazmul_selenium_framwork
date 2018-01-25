package com.naz.browserInvocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by nkkhan on 1/24/18.
 */
public class DriverWrapperChrome {
    private static WebDriver chromeDriver;
    private static String url = "https://www.facebook.com/";

    public static WebDriver getChromeDriver() {
        return chromeDriver;
    }

    public static String getUrl() {
        return url;
    }

    @BeforeClass
    public void driverInitialization(){
        System.setProperty("webdriver.chrome.driver","/Users/nkkhan/Projects/technoSoft/webDrivers/chromedriver");
        this.chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(url);
    }

    @AfterClass
    public void tearDown(){
        chromeDriver.quit();
    }
}
