package extenstions;

import org.openqa.selenium.WebElement;
import utilities.BasePage;
import utilities.Log;

public class Click extends BasePage {

    public static void go(WebElement element) throws InterruptedException {
        Thread.sleep(2000);
        try{
            element.click();
            Log.info("Element clicked successfully ");
        }catch (Exception e){
            Log.info("Error");
        }

    }

    public static void sending(WebElement element,String whatToSend){
        try {
            element.sendKeys(whatToSend);
        }catch (Exception e){
            Log.info("");
        }
    }




}
