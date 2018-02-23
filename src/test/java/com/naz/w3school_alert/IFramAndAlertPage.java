package com.naz.w3school_alert;

import com.naz.base.BasePage;
import com.naz.base.DriverWrapperChrome;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/30/18.
 */
public class IFramAndAlertPage extends BasePage{
    private String frameId = "iframeResult";
    private By tryItButton = By.xpath("/html/body/button");
    private By homeButton = By.xpath("/html[1]/body[1]/div[5]/div[1]/a[1]");


    public void FrameAndVerifyAlert(String testInput) throws InterruptedException {
        getDriver().switchTo().frame(frameId);
        alertHandler(tryItButton, testInput);
    }


    public void additionalAction() throws InterruptedException {

        //just for experiment, navigating driver out of frame(original page)
        getDriver().navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

        //click on home button. That open home page in a new tab
        clickOn(homeButton);
        Thread.sleep(3000);

        //switch the driver to home page in new tab
        switchToWindow(1);
        Thread.sleep(3000);

        //closing current page(home) and switching the driver back to voriginal page
        switchToRootWindowAndCloseCurrentWindow();
        Thread.sleep(3000);
    }
}
