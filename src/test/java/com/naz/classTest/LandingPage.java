package com.naz.classTest;

import com.naz.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by nkkhan on 2/3/18.
 */
public class LandingPage extends BasePage{
    private By foodName = By.xpath("//span[@class='title ng-binding']");
    private By foodServingDesk = By.xpath("//span[@class='description ng-binding']");

    /*a)	Display the third and fifth item from the above list. Your output should be:
Applesauce, unsweetened
Juice, Cranberry-apple drink
b)	Fetch each food name and its servings and store them in a Map.
Iterate through all the entries in the Map and print them.*/

    public void listOfFoodItem(){
        List<WebElement> listFoodName = getDriver().findElements(foodName);

        System.out.println("Item 3 = "+listFoodName.get(2).getText());
        System.out.println("Item 5 = "+listFoodName.get(4).getText());

    }



    public void listOfFoodAndServingDesk(){
        List<WebElement> listFoodName = getDriver().findElements(foodName);
        List<WebElement> listServingDesk = getDriver().findElements(foodServingDesk);


        HashMap<String, String> technoFood = new HashMap<>();

        for (int i=0; i<listFoodName.size(); i++){
            technoFood.put(listFoodName.get(i).getText(), listServingDesk.get(i).getText());
        }

        Set s  = technoFood.keySet();
        Iterator iterator = s.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = (String) technoFood.get(key);
            System.out.println("Food name: "+key+", Serving = "+value);
        }
    }

}
