import com.thoughtworks.gauge.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;

import java.io.File;

import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
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

        System.out.println("IN");
    }



    @Step("Verify if employee list is displayed")
    public void verifyIfEmployeeDisplayed()
    {

        System.out.println("IN");

    }


    @Step("Create an Employee")
    public void createEmployee()
    {

        System.out.println("IN");
    }


    @Step("Verify if employee is added")
    public void verifyEmployeeAddedd()
    {
        System.out.println("IN");




    }



}
