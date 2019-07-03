package Utilities.Selenium;

import Utilities.VariableDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Browserinteraction {


    public static WebElement elementOperationByXpath(String xpath)
    {
        return VariableDefinitions.getDriver().findElement(By.xpath(xpath));
    }

    public static WebElement elementOperationById(String id)
    {
        return VariableDefinitions.getDriver().findElement(By.id(id));
    }

    public static WebElement dynamicLink(String value)
    {
        return VariableDefinitions.getDriver().findElement(By.xpath("//img[@alt='"+value+"']"));
    }

    public static WebElement clickEmployee(String value)
    {
        return VariableDefinitions.getDriver().findElement(By.xpath("//span[contains(text(),'"+value+"')]/.."));
    }


}
