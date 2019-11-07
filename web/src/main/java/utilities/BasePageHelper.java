package utilities;

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
}
