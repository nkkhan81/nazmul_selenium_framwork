package com.naz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Created by nkkhan on 1/24/18.
 */
public class BasicTestScenario {
    public static void main(String[] args) {

        //set chrome driver
        System.setProperty("webdriver.chrome.driver","/Users/nkkhan/Projects/technoSoft/webDrivers/chromedriver");

        //initializing driver
        WebDriver chromeDriver = new ChromeDriver();

        String url = "http://www.facebook.com/";
        chromeDriver.navigate().to(url);


        String currentURL = chromeDriver.getCurrentUrl();

        Assert.assertEquals(currentURL, url,"invalid URL found. please check the url");

        chromeDriver.quit();




        //        List<WebElement> lisOfLinks = chromeDriver.findElements(By.linkText("Developers"));
//        for (WebElement element : lisOfLinks) {
//            if (element.getText().equals("Developers")){
//                element.click();
//                break;
//            }
//            else {
//                System.out.println("Screen shot taken");
//                Assert.fail("Element not found by the list method");
//                }
//        }



//        chromeDriver.findElement(By.xpath("input[@name='btnk']/following-sibling::input[2]")).click();
//        chromeDriver.findElement(By.xpath("//div[@class='jsb']/descendant::input[position()=2]")).click();


    }
}
