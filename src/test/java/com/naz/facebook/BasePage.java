package com.naz.facebook;

import com.naz.browserInvocation.DriverWrapperChrome;
import org.openqa.selenium.By;
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
        DriverWrapperChrome.getChromeDriver().findElement(locator).click();
    }

    public void setValueToInputField(By locator, String value){
        DriverWrapperChrome.getChromeDriver().findElement(locator).sendKeys();
    }

    public String getTextFromElement(By locator){
        return DriverWrapperChrome.getChromeDriver().findElement(locator).getText();
    }

    public String getAttributeValue(By locator, String attributeName){
        WebElement element = DriverWrapperChrome.getChromeDriver().findElement(locator);
        return element.getAttribute(attributeName);
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
