package com.naz.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by nkkhan on 2/6/18.
 */
public class Spicejet {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "/Users/nkkhan/Projects/SeleniumUdemy/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://spicejet.com/");

        driver.findElement(By.xpath("//input[@value='OneWay']")).click();
        driver.findElement(By.cssSelector("select[id='ctl00_mainContent_ddl_originStation1']")).click();

        driver.findElement(By.xpath("//div[@id='dropdownGroup1']//div[@class='dropdownDiv']/ul[2]/li[3]/a")).click(); //getting error here
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        driver.quit();
        driver.quit();
    }
}
