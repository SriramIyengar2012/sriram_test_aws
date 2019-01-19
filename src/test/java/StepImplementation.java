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

    private HashSet<Character> vowels;
    WebDriver driver;


    @BeforeSuite
    public void getBrowser() throws Exception
    {
        if(System.getenv("browser").equals("chrome"))
        {
           System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Chrome/chromedriver");
           DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
           capabilities.setCapability("version", "");
           capabilities.setPlatform(Platform.LINUX);

            driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
            driver.manage().window().maximize();



        }
        if(System.getenv("browser").equals("firefox"))
        {
           System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Firefox/geckodriver");
            // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Chrome/chromedriver");
            DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
            capabilities.setCapability("version", "");
            capabilities.setPlatform(Platform.LINUX);

            driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
            driver.manage().window().maximize();
        }

    }

    @Step("Vowels in English language are <vowelString>.")
    public void setLanguageVowels(String vowelString) {
        vowels = new HashSet<>();
        for (char ch : vowelString.toCharArray()) {
            vowels.add(ch);
        }
    }

    @Step("The word <word> has <expectedCount> vowels.")
    public void verifyVowelsCountInWord(String word, int expectedCount) {
        int actualCount = countVowels(word);
      //  assertThat(expectedCount).isEqualTo(actualCount);
    }

    @Step("Almost all words have vowels <wordsTable>")
    public void verifyVowelsCountInMultipleWords(Table wordsTable) {
        for (TableRow row : wordsTable.getTableRows()) {
            String word = row.getCell("Word");
            int expectedCount = Integer.parseInt(row.getCell("Vowel Count"));
            int actualCount = countVowels(word);

           // assertThat(expectedCount).isEqualTo(actualCount);
        }
    }

    @Step("Test <value> <value2> <value3>")
    public void test(String value, String value2, String value3) throws Exception
    {

   /*     FileUtils.copyFile(new File("test2.csv"), new File ("test.csv"));
        Reader reader = Files.newBufferedReader(Paths.get("test.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord csvRecord : csvParser) {*/
            System.out.println("1" + value);
            System.out.println("2" + value2);
            System.out.println("3" + value3);
       // }
    }

    @Step("Navigate to Google")
    public void navigatetogoogle()
    {

        driver.get("http://www.google.com");
        driver.quit();

    }

    @Step("Print <value>")
    public void test2(String value)
    {

    }

    @BeforeSpec
    public void copy(ExecutionContext e) throws Exception
    {
        System.out.println(e.getCurrentScenario().getName());
/*       if(e.getCurrentScenario().getName().equals("sce2")) {
           File f = new File("test2.csv");
           FileUtils.copyFile(f, new File("test.csv"));
       }
       else if(e.getCurrentScenario().getName().equals("sce3"))
       {
           File f = new File("test3.csv");
           FileUtils.copyFile(f, new File("test.csv"));
       }*/
    }

    private int countVowels(String word) {
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (vowels.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}
