package utilities;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static utilities.BasePage.brand;
import static utilities.BasePageHelper.chooseBrand;


public class UiUtilities {
    protected static final Logger log = Logger.getLogger(UiUtilities.class);

    public static String pageUrl;


    WebDriver driver;

    public UiUtilities(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void openBrandHomePage(String brand) throws Exception {

        String brandName = chooseBrand(brand);
        if (brandName.equals("conversation")) {
            pageUrl = ("http://www.spotim.name/lia-username/lia1.html");

        } else if (brandName.equals("conversationNoRobot")) {
            pageUrl = ("http://www.spotim.name/bd-playground/post1.html");

        } else if (brandName.equals("moderation")) {
            pageUrl = ("https://admin.spot.im/");

        } else if (brandName.equals("liveBlog")) {
            pageUrl = ("http://www.spotim.name/lia-playground/liveBlog.html ");

        } else if (brandName.equals("starReviews")) {
            pageUrl = ("https://s3.amazonaws.com/www.spotim.name/bd-playground/social-reviews.html ");

        } else if (brandName.equals("recirculation")) {
            pageUrl = ("https://s3.amazonaws.com/www.spotim.name/lia-playground/pitc-test.html ");

        } else if (brandName.equals("spotlightComment")) {
            pageUrl = ("http://www.spotim.name/lia-playground/lia2.html ");

        } else if (brandName.equals("spotlightEmail")) {
            pageUrl = ("http://www.spotim.name/silo/automation2.html ");

        } else if (brandName.equals("messageCountWidget")) {
            pageUrl = ("http://www.spotim.name/bd-playground/messages-count.html ");

        }

        driver.navigate().to(pageUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        jse.executeScript("javascript:localStorage.clear();");
        Thread.sleep(100);
        jse.executeScript("sessionStorage.setItem('CURRENT_LOCATION','{}');");
        System.out.println("*************************************************************");
        System.out.println("Brand name = " + brandName);
        System.out.println("*************************************************************");


        System.out.println(brand + "home page Opened successfully.");
    }

}

