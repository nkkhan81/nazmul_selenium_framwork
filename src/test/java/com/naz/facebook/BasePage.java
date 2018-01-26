package com.naz.facebook;

import com.naz.browserInvocation.DriverWrapperChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by nkkhan on 1/24/18.
 */
public class BasePage {

    //Actions: List all actions that you are going to perform on elements
    //eg. click, insert text in a field, get text from an element

    public void clickOn(By locator){
        try {

            DriverWrapperChrome.getChromeDriver().findElement(locator).click();

        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
            System.out.println("Screenshot taken");
            Assert.fail("Element not found with this locator "+locator.toString());
        }
    }

    public void setValueToInputField(By locator, String value){
        try {

            DriverWrapperChrome.getChromeDriver().findElement(locator).sendKeys();

        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
            System.out.println("Screenshot taken");
            Assert.fail("Element not found with this locator "+locator.toString());
        }
    }

    public String getTextFromElement(By locator){
        try {

            return DriverWrapperChrome.getChromeDriver().findElement(locator).getText();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Element not found with this locator "+locator.toString());
            return "Screenshot taken";
        }
    }

    public boolean isElementEnabled(By locator){
        try {

            return DriverWrapperChrome.getChromeDriver().findElement(locator).isEnabled();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Element not found with this locator "+locator.toString());
            return false;
        }
    }

    public boolean isElementDisplayed(By locator){
        try {

            return DriverWrapperChrome.getChromeDriver().findElement(locator).isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Element not found with this locator "+locator.toString());
            return false;
        }
    }

    public boolean isElementSelected(By locator){
        try {

            return DriverWrapperChrome.getChromeDriver().findElement(locator).isSelected();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Element not found with this locator "+locator.toString());
            return false;
        }
    }

    public String getAttributeValue(By locator, String attributeName){
        try {

            WebElement element = DriverWrapperChrome.getChromeDriver().findElement(locator);
            return element.getAttribute(attributeName);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Element not found with this locator "+locator.toString());
            return "Screenshot taken";
        }
    }

    public WebElement findElementByList(By locator, String comparableText){
        List<WebElement> lisOfLinks = DriverWrapperChrome.getChromeDriver().findElements(locator);
        WebElement foundElement = null;
        for (WebElement element : lisOfLinks) {
            if (element.getText().equals(comparableText)){
                foundElement = element;
                break;
            }
            else {
                System.out.println("Screen shot taken");
                Assert.fail("Element not found by the list method"+locator.toString());
                }
        }
        return foundElement;
    }
}
