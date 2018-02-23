package com.naz.misc;

import com.naz.base.BasePage;
import com.naz.base.DriverWrapperChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by nkkhan on 2/11/18.
 */
public class SauceLabDemo extends BasePage {
    private static final String USER_NAME = "koushiktec";
    private static final String ACCESS_KEY = "ec28ec96-c9e2-493c-ad25-57dcabbcf6ca";
    private static final String SAUCE_URL = "https://"+USER_NAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

    private static By emailField = By.xpath("//input[@id='email']");
    private static By passField = By.xpath("//input[@id='pass']");
    private static By loginButton = By.xpath("//label[@id='loginbutton']");




    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "64.0");

        WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL),caps);

        driver.get("https://www.facebook.com/");
        driver.findElement(emailField).sendKeys("sdfd@sdfd.dfg");
        driver.findElement(passField).sendKeys("test123");
        driver.findElement(loginButton).click();

        String buttonText = driver.findElement(By.xpath("//a[@role='button'][contains(text(),'Recover Your Account')]")).getText();
        Assert.assertEquals(buttonText,"Recover Your Account","Verification failed");
        driver.quit();

    }
}
