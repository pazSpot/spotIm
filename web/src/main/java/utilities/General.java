package utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import static java.lang.Math.*;
import static java.lang.Math.pow;
import static java.lang.StrictMath.abs;
import static org.apache.commons.lang3.StringUtils.leftPad;

public class General {
    protected static final Logger log = Logger.getLogger(UiUtilities.class);
    WebDriver driver;

    public General(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String randomCharString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = length; i > 0; i -= 12) {
            int n = min(12, abs(i));
            sb.append(leftPad(Long.toString(round(random() * pow(36, n)), 36), n, '0'));
        }
        return sb.toString();
    }


    public static String randomName() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    /**
     * Create a random Number
     */
    public static int createRandNumber(int minimum, int maximum) throws Exception {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        return randomNum;
    }


    public static String randString(int min, int max) {
        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }

    public static int randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static List<String> errorList = new ArrayList<String>();
    static ExecutorService executor;
    static String pageUrlTocheck;
    static String urlToCheck;
    static int code;

    private static void sendGet(WebElement element) throws Exception {
        urlToCheck = element.getAttribute("href");
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(urlToCheck);

        if (!urlToCheck.contains("mailto:")) {

            HttpResponse response = null;
            try {
                response = client.execute(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            code = response.getStatusLine().getStatusCode();

            if (code != 200)
                throw new Exception("Checking URL (" + urlToCheck + ") on page: " + pageUrlTocheck + " Failed. Url failed to response with 200 OK. Found: " + code);
        }
        System.out.println("href = " + urlToCheck + " - 200 OK");
    }

    public void changeTab(int whatWindowYouNeed) throws Exception {
        Log.info("Changing to tab " + whatWindowYouNeed);
        ArrayList<String> tabs = null;
        try {
            Thread.sleep(2000);
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(whatWindowYouNeed));
        } catch (Exception e) {
            Assert.assertTrue(false, "Was not able to change tab. found " + tabs.size() + " tabs.");
        }
    }

    public void changeWindow(int whatWindowYouNeed) throws Exception {
        Log.info("Changing to window " + whatWindowYouNeed);
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        } catch (Exception e) {
            Assert.assertTrue(false, "Was not able to change window. ");
        }
    }

    public void scrollIntoObjectView(WebElement element) throws Exception {
        Log.info( "Scrolling to view object on page");
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(1000);
        } catch (Exception e) {
            Assert.assertTrue(false, "Error: Scrolling to view object on page - failed. " + e);
        }
    }

    /**
     * Scroll up: negative number
     * Scroll down: positive number
     *
     * @param pixels
     * @throws Exception
     */
    public void scrollPage(String pixels) throws Exception {
        Log.info("Scrolling " + pixels + " on page");
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0," + pixels + ")");
            Thread.sleep(1000);
        } catch (Exception e) {
            Assert.assertTrue(false, "Error: Scrolling on page - failed. " + e);
        }
    }
}


