package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.logging.Level;

import static java.util.concurrent.TimeUnit.SECONDS;
import static utilities.BasePageHelper.chooseBrowser;


public class BasePage {

    public static final String USERNAME = "pazezrati1";
    public static final String AUTOMATE_KEY = "Jr9tqH48u7Au1Up5kdqB";
    public static String browser = System.getProperty("browser");
    public static String browser_version = System.getProperty("browser_version");
    public static String browserName = System.getProperty("browserName");
    public static String currentDate = GetCurrentDateAndTime.getDateAndTime("yyyy-MM-dd");
    public static String brand = System.getProperty("brand");
    public static String GridToRunTests = System.getProperty("GridToRunTests");
    public static final String BS_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static String testName;



    public WebDriver driver = null;
    public WebDriverWait wait = null;


    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;

    @BeforeMethod
    public void BeforeMethod() throws Exception {
        Log.info("setUp - before method ");

        if (GridToRunTests.equals("browserStacks")) {
            Log.info("grid to run  - browserStacks ");

            DesiredCapabilities caps = new DesiredCapabilities();


            if (browser.equals("safari")) {

                caps.setCapability("Name", testName);
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "High Sierra");
                caps.setCapability("browser", "Safari");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");

            } else if (browser.equals("Chrome")) {

                caps.setCapability("Name", testName);
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "62.0");
                caps.setCapability("resolution", "1920x1200");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
            } else if (browser.equals("firefox")) {

                caps.setCapability("Name", testName);
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Sierra");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "66.0");
                caps.setCapability("resolution", "1600x1200");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.10.0");

            } else if (browser.equals("IE")) {

                caps.setCapability("Name", testName);
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "IE");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");

            }


            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            caps.setCapability("browserstack.console", "info");
            caps.setCapability("browserstack.networkLogs", "true");
            caps.setCapability(brand, "brand");
            driver = new RemoteWebDriver(new URL(BS_URL), caps);
            driver.manage().window().maximize();


        } else if (GridToRunTests.equals("myMachine")) {
            Log.info("grid to run  - myMachine ");

            String browserName = chooseBrowser(browser);
            if (browserName.equals("Chrome")) {
                Log.info("Open in CHROME");
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                driver = new ChromeDriver();

            } else if (browserName.equals("firefox")) {
                Log.info("Open in FIREFOX");
                System.setProperty("webdriver.geecko.driver", "geckodriver");
                driver = new FirefoxDriver();

            } else if (browserName.equals("safari")) {
                Log.info("Open in SAFARI");
                driver = new SafariDriver();
            }

            driver.manage().timeouts().implicitlyWait(20, SECONDS);
        }
    }


    @AfterMethod
    public void tearDown() {
        Log.info("tearDown");
        driver.quit();
    }
}

