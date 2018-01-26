package com.naz.homework_class03_radioButton;

import com.naz.facebook.BasePage;
import org.openqa.selenium.By;

/**
 * Created by nkkhan on 1/25/18.
 */
public class FbLandingPageHW extends BasePage {

/*  Homework Assignment # 1:
    Description: Select male radio button if its not selected by default
    Step 1: Select your gender if its not selected
    Step 2: Verify that your gender is selected  */

    //Locator
    By maleRadioButton = By.xpath("//span[@data-name='gender_wrapper']/span[2]/input[1]");

    //method
    public void clickOnMaleRadioButton(){
        //checking if the radio button is already selected
        boolean isSelected = isElementSelected(maleRadioButton);

        //if not selected than only select the male option
        if (isSelected == false){
            clickOn(maleRadioButton);
        }

        //verifying it is selected or not. return true if selected
        System.out.println("Radio button selected = "+isElementSelected(maleRadioButton));
    }
}
