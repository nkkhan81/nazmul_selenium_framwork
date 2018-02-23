package com.naz.base;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import com.naz.base.DriverWrapperChrome;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nkkhan on 1/24/18.
 */
public class BasePage {

/*  List of methods
    ------------------
    1)  void mouseOverAndClick(By hoverLocator,By clickLocator)

    2)  void clickOn(By locator)

    3)  void setValueToInputField(By locator, String value)

    4)  String getTextFromElement(By locator)

    5)  boolean isElementEnabled(By locator)

    6)  boolean isElementDisplayed(By locator)

    7)  boolean isElementSelected(By locator)

    8)  String getAttributeValue(By locator, String attributeName)

    9)  selectDropDownMenuByVisibleText(By locator, String value)

    10) selectDropDownMenuByIndex(By locator, int index)

    11) WebElement findElementByList(By locator, String comparableText)

    12) void selectCurrentDateFromDatePicker(String pattern, By expandDatePicker, By datePicker)

    13) static WebDriver getDriver()

    14) void switchToWindow(int index)

    15) void switchToRootWindowAndCloseCurrentWindow()

    16) void selectFromAutoCompleteMenu(By inputTextFieldLocator, String inputValue, By listLocator, String value)

    17) void alertHandler()

    18) void selectCustomDateFromDatePicker(String inputDate, By dateInput,By calendarHeader,By nextButton, By dates)

    19) void useKey(By locator, Keys keys)
*/


//  private method for fluentWait

    private static WebElement elementWithWait(By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15,TimeUnit.SECONDS)
                .pollingEvery(1,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotFoundException.class)
                .withMessage("WebDriver waited for 15 seconds but still  couldn't find the element, therefore timeout exception has been thrown"+ locator.toString());
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }



//  Actions: List all actions that you are going to perform on elements
//  eg. click, insert text in a field, get text from an element etc

    //  1) To hover over an element and expand it for next action
    public static void mouseOverAndClick(By hoverElementLocator,By clickLocator) throws InterruptedException {

        WebElement element = getDriver().findElement(hoverElementLocator);

        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);

        clickOn(clickLocator);
        Thread.sleep(2000);
    }


    //  2) To click an element
    public static void clickOn(By locator){
            elementWithWait(locator).click();
    }



    //  3) To set value to an input field
    public void setValueToInputField(By locator, String value){
            elementWithWait(locator).sendKeys(value);
    }



    //  4) To get text value from an element
    public String getTextFromElement(By locator){

            return elementWithWait(locator).getText();

    }


    //  5) To check an element is enabled or not(eg. a link). Return true or false
    public boolean isElementEnabled(By locator){

            return elementWithWait(locator).isEnabled();

    }



    //  6) To check an element is displayed or not. Return true or false
    public boolean isElementDisplayed(By locator){

            return elementWithWait(locator).isDisplayed();

    }



    //  7) To check an element is selected or not(eg. a radio button). Return true or false
    public boolean isElementSelected(By locator){

            return elementWithWait(locator).isSelected();

    }

    //  8) To get text value from an attribute of an element
    public String getAttributeValue(By locator, String attributeName){

            WebElement element = elementWithWait(locator);
            return element.getAttribute(attributeName);

    }


    //  9)  To select a dropdown menu and select a valu by visible text
    public void selectDropDownMenuByVisibleText(By locator, String value){
        Select dropDown = new Select(elementWithWait(locator));
        dropDown.selectByVisibleText(value);
    }


    //  10) To select a dropdown menu and select a value by index no
    public void selectDropDownMenuByIndex(By locator, int index){
        Select dropDown = new Select(elementWithWait(locator));
        dropDown.selectByIndex(index);
    }


    //  11) To select an element by creating list of elements
    public WebElement findElementByList(By locator, String comparableText){
        List<WebElement> lisOfLinks = getDriver().findElements(locator);
        WebElement foundElement = null;
        try {
            for (WebElement element : lisOfLinks) {
                if (element.getText().equals(comparableText)){
                    foundElement = element;
                    break;
                }
            }
            return foundElement;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found in the list");
            System.out.println("Screen shot taken");
            e.printStackTrace();
            return null;
        }
    }


    //  12) to select current date from a  date picker
    public void selectCurrentDateFromDatePicker(String pattern, By expandDatePicker, By datePicker) throws InterruptedException {
        //SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        LocalDate date = LocalDate.now();
        String currentDate = date.format(DateTimeFormatter.ofPattern(pattern));

        elementWithWait(expandDatePicker).click();
        List<WebElement> days = getDriver().findElements(datePicker);
        for (WebElement day : days) {
            String expectedDay = day.getText();
            if (expectedDay.equals(currentDate)){
                day.click();
                Thread.sleep(3000);
            }
        }
    }


    //  13) simplified the driver instance
    public static WebDriver getDriver(){
        return DriverWrapperChrome.getChromeDriver();
    }


    //  14) switches to windows based on index
    public void switchToWindow(int index){
        List<String> listOfWindows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(listOfWindows.get(index));
    }


    //  15) closes current window and switches back to root window
    public void switchToRootWindowAndCloseCurrentWindow(){
        List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
        for (int i = 1; i < listOfWindows.size(); i++){
            getDriver().switchTo().window(listOfWindows.get(i));
            getDriver().close();
        }
        getDriver().switchTo().window(listOfWindows.get(0));
    }


    //  16) select an item from AutoComplete menu
    public void selectFromAutoCompleteMenu(By inputTextFieldLocator, String inputValue, By listLocator, String value) throws InterruptedException {

        setValueToInputField(inputTextFieldLocator,inputValue);
        Thread.sleep(3000);

        List<WebElement> autoCompleteLists = new ArrayList<>(getDriver().findElements(listLocator));
        try {
            for (WebElement listElement : autoCompleteLists){
                if (listElement.getText().contains(value)){
                    listElement.click();
                    Thread.sleep(2000);
                    break;
                }
            }
        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
        }
    }


    //  17) to perform various alert actions
    public void alertHandler(By alertPopupElement, String inputText) throws InterruptedException {
        clickOn(alertPopupElement);
        Thread.sleep(2000);
        switchAction().sendKeys(inputText);
        switchAction().accept();
        Thread.sleep(2000);
        clickOn(alertPopupElement);
        Thread.sleep(2000);
        System.out.println(switchAction().getText());
        switchAction().dismiss();
        Thread.sleep(2000);
    }

    private Alert switchAction(){
        Alert alert = getDriver().switchTo().alert();
        return alert;
    }


    // 18)  To select a custom date from date picker
    public void selectCustomDateFromDatePicker(String inputDate, By dateInput,By calendarHeader,By nextButton, By dates) throws ParseException {
        SimpleDateFormat simpleDF = new SimpleDateFormat("M-d-yyyy");
        Date date = simpleDF.parse(inputDate);

        SimpleDateFormat sdfDay = new SimpleDateFormat("d");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        String day = sdfDay.format(date);
        String month = sdfMonth.format(date);
        String year = sdfYear.format(date);
        String monthAndYear = (month+" "+year);

        clickOn(dateInput);

        while(!elementWithWait(calendarHeader).getText().contains(monthAndYear)){

            elementWithWait(nextButton).click();
        }


        List<WebElement> days = getDriver().findElements(dates);

        for(WebElement element : days){
            String expectedDate = element.getText();
            if(expectedDate.equals(day)){
                element.click();
                break;
            }
        }
    }


    //  19)  method for press any key
    public void useKey(By locator, Keys key){
        elementWithWait(locator).sendKeys(key);
    }

    //  20)  method for typing upper case text in a input field.
    public void useUpperCaseForInputField(By locator, String text){

        //WebElement to which keyboard action is performed
        WebElement element = elementWithWait(locator);

        //creating object of actions class
        Actions builder = new Actions(getDriver());

        //Generating an action to type a text in caps
        Action typeInCaps = builder.keyDown(element,Keys.SHIFT)
                .sendKeys(element,text)
                .keyDown(element,Keys.SHIFT)
                .build();
        typeInCaps.perform();
    }


//DIFFERENT WAIT MECHANISM

    //implicit wait
    public static void implicitWait(){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().get("some URL");
        WebElement myDynamicElement = getDriver().findElement(By.id("some element id"));
    }

    //expected wait
    public static void witUntilElementClickable(){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someID")));
    }

    //page load wait
    public static void pageLoadWait(){
        getDriver().manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    //Script Timeout
    public static void synchronousScript(){
        getDriver().manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
    }
}
