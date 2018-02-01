package com.naz.homework_class03_radioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by nkkhan on 1/25/18.
 */
public class LocatorDifferentApproch {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/nkkhan/Projects/technoSoft/webDrivers/chromedriver");
        WebDriver chrome = new ChromeDriver();
        String url = "https://www.linkedin.com/";

        //Navigating to linkedin.com
        chrome.navigate().to(url);

        //attempting to sign in by email, password and clicking Sign in button
        //Email field - locator: by id
        chrome.findElement(By.id("login-email")).sendKeys("test@gmail.com");

        //password field - locator: by name
        chrome.findElement(By.name("session_password")).sendKeys("test123");

        //Sign in button - locator: css by id
        chrome.findElement(By.cssSelector("input#login-submit")).click();

        //Get error msg Text - locator: xpath    //*[@id='control_gen_1']/p/strong
        System.out.println(chrome.findElement(By.xpath("//div[@class='alert error']/p/strong")).getText());

        //Click on forgot password link - locator: linkText
        chrome.findElement(By.linkText("Forgot password?")).click();

        //Enter reset email - locator: css(contains)
        chrome.findElement(By.cssSelector("input[id*='userName']")).sendKeys("afasfasf@sd.sd");

        //click on submit button - locator: css
        chrome.findElement(By.cssSelector("input[name='request']")).click();


        chrome.quit();
    }

}
