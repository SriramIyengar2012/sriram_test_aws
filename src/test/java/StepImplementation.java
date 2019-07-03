import Utilities.Objectrepository.Employeepage;
import Utilities.Selenium.Browserinteraction;
import Utilities.VariableDefinitions;
import com.thoughtworks.gauge.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Assert;

import java.io.File;

import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {



    @Step("Navigate to employee application")
    public void navigateToEmployeeApplication()
    {
        VariableDefinitions.getDriver().get(System.getenv("url"));
        System.out.println("IN");
    }



    @Step("Verify if employee list is displayed")
    public void verifyIfEmployeeDisplayed()
    {

        Boolean element =Browserinteraction.elementOperationByXpath(Employeepage.link1).isDisplayed();
        Assert.isTrue(element, "Employee Visible successfully");


    }


    @Step("Create an Employee")
    public void createEmployee()
    {
       Browserinteraction.elementOperationByXpath(Employeepage.addbutton).click();
       Browserinteraction.elementOperationByXpath(Employeepage.enterEmployeeName).clear();
        Browserinteraction.elementOperationByXpath(Employeepage.enterEmployeeName).sendKeys("Testing");
        Browserinteraction.elementOperationByXpath(Employeepage.savebutton).click();
        System.out.println("IN");
    }


    @Step("Verify if employee is added")
    public void verifyEmployeeAddedd()
    {
       Boolean employeeaddedd = Browserinteraction.dynamicLink("Testing").isDisplayed();
        Assert.isTrue(employeeaddedd, "Employee created successfully");
        System.out.println("IN");




    }



}
