package com.naz.classTest;

import com.naz.base.DriverWrapperChrome;
import com.naz.facebook.*;
import org.testng.annotations.Test;

/**
 * Created by nkkhan on 2/3/18.
 */

/*Question 2:

Use your knowledge of WebDriver to fetch the following:

a)	Display the third and fifth item from the above list. Your output should be:
Applesauce, unsweetened
Juice, Cranberry-apple drink

b)	Fetch each food name and its servings and store them in a Map.
Iterate through all the entries in the Map and print them.

*/
public class Test2 extends DriverWrapperChrome{

    @Test
    public void displayThirdAndFifthFoodItem(){
        LandingPage landingPage = new LandingPage();
        landingPage.listOfFoodItem();
    }

    @Test
    public void displayTheListOfFoodAndServingDesk(){
        LandingPage landingPage = new LandingPage();
        landingPage.listOfFoodAndServingDesk();
    }

}
