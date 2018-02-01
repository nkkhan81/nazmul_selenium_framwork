package com.naz.TargetDotCom_MouseOver;

import com.naz.base.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/30/18.
 */
public class LandingPageTarget extends BasePage{

    //locators
    private By shoppingCartElement = By.xpath("//a[@id='js-toggleMiniCartLg']");
    private By signInLink = By.linkText("sign in");


    //methods
    public void mouseOverAndClickSignIn() throws InterruptedException {
        mouseOverAndClick(shoppingCartElement,signInLink);
    }


}
