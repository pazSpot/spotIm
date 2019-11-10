package utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Random;

public class BasePageHelper extends BasePage {

    public static String chooseBrowser(String browser) {
        if (browser.equals("firefox") || browser.equals("IE") || browser.equals("Chrome") || browser.equals("safari") || browser.equals("iPad") || browser.equals("Edge")) {
            return browser;
        } else if (browser.equals("randomize")) {
            String[] arr = {"firefox", "Chrome", "Edge"};
            Random random = new Random();
            int result = random.nextInt(arr.length);
            String stringResult = arr[result].toString();
            browser = stringResult;
            return browser;
        }
        return null;
    }

    public static String chooseBrand(String brand) {
        if (brand.equals("conversation") || brand.equals("conversationFoxNewsProduction") || brand.equals("moderation") || brand.equals("liveBlog") || brand.equals("starReviews") ||
                brand.equals("recirculation") || brand.equals("spotlightComment") || brand.equals("spotlightEmail") || brand.equals("messageCountWidget")) {
            return brand;
        }
        return null;
    }


    public static Dimension returnCapDimensions() {
        Dimension a, b, c, d, e, f;
        //smallest - mobile
        a = new Dimension(320, 568);
        //small - mobile
        b = new Dimension(600, 960);
        //large - tablet
        c = new Dimension(800, 1280);
        //largest - tablet
        d = new Dimension(1024, 768);
        //full - desktop
        e = new Dimension(1366, 768);
        //biggest - desktop
        f = new Dimension(1920, 1080);

        Dimension[] arr = {a, b, c, d, e, f};


        /**
         * 0->smallest
         * 1->small
         * 2->large
         * 3->largest
         * 4->full
         * 5->biggest
         */
        Random random = new Random();
        int result;
        if (System.getProperty("environment").equals("www")) {
            result = 5;
        } else {
            result = Integer.parseInt(System.getProperty("screenSize")); //for specific
        }
        return arr[result];
    }

    public static void setDimensions(WebDriver driver, int dimension) throws Exception {
        switch (dimension) {
            case 0:
                //smallest - mobile
                Dimension a = new Dimension(320, 568);
                driver.manage().window().setSize(a);
                break;
            case 1:
                //small - mobile
                Dimension b = new Dimension(600, 960);
                driver.manage().window().setSize(b);
                break;
            case 2:
                //large - tablet
                Dimension c = new Dimension(800, 1280);
                driver.manage().window().setSize(c);
                break;
            case 3:
                Dimension d = new Dimension(1070, 970);
                driver.manage().window().setSize(d);
                break;
            case 4:
                Dimension e = new Dimension(1366, 768);
                driver.manage().window().setSize(e);
                break;
            case 5:
                //biggest - desktop
                Dimension f = new Dimension(1920, 1080);
                driver.manage().window().setSize(f);
                break;
        }
    }

}
