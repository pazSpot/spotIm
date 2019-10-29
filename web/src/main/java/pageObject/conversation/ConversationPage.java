package pageObject.conversation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConversationPage {

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]/input")
    @CacheLookup
    WebElement nickName;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
    @CacheLookup
    WebElement addComment;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/span/div[2]/button")
    @CacheLookup
    WebElement gifButton;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/span/div[1]")
    @CacheLookup
    WebElement photoButton;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/button")
    @CacheLookup
    WebElement postButton;

    WebDriver driver;

    public ConversationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnNickName() {
        System.out.println("Clicking on Nick Name");
        try {
            nickName.click();
        } catch (Exception e) {
            System.out.println("Error clicking on nick name");
        }
    }

    public void clickOnGifButton() {
        System.out.println("Clicking on GIF Button");
        try {
            gifButton.click();
        } catch (Exception e) {
            System.out.println("Error clicking on GIF Button");
        }
    }

    public void clickOnPhotoButton() {
        System.out.println("Clicking on photo Button");
        try {
            photoButton.click();
        } catch (Exception e) {
            System.out.println("Error clicking on photo Button");
        }
    }

    public void enterNickName(String myNickName) {
        System.out.println("Entering nick name");
        try {
            nickName.sendKeys(myNickName);
        } catch (Exception e) {
            System.out.println("Error Entering first name");
        }
    }

    public void sendPhoto(String photo) {
        System.out.println("Entering photo");
        try {
            photoButton.sendKeys(photo);
        } catch (Exception e) {
            System.out.println("Error Entering photo");
        }
    }

    public void clickOnComment() {
        System.out.println("Clicking on Comment");
        try {
            addComment.click();
        } catch (Exception e) {
            System.out.println("Error clicking on Comment");
        }
    }

    public void clickOnPost() {
        System.out.println("Clicking on Post");
        try {
            postButton.click();
        } catch (Exception e) {
            System.out.println("Error clicking on Post");
        }
    }


    public void enterComment(String myComment) {
        System.out.println("Entering Comment");
        try {
            addComment.sendKeys(myComment);
        } catch (Exception e) {
            System.out.println("Error Entering Comment");
        }
    }


    public String getNickName() {
        String fullNickName = null;
        System.out.println("Getting full name");
        try {
            fullNickName = nickName.getAttribute("value");
            System.out.println("The nick name is: " + fullNickName);
        } catch (Exception e) {
            System.out.println("Error getting nick name");
        }
        return fullNickName;
    }

    public String getComment() {
        String fullComment = null;
        System.out.println("Getting comment");
        try {
            fullComment = addComment.getText();
            System.out.println("The comment is: " + fullComment);
        } catch (Exception e) {
            System.out.println("Error getting the comment");
        }
        return fullComment;
    }

    public void clickOnOneOfTheGifs() {
        try {
            List<WebElement> gifs = driver.findElements(By.xpath("//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/span/div[2]/div/div/div/div/div"));
            for (int x = 0; x < gifs.size(); x++) {
                gifs.get(x).click();
            }
        } catch (Exception e) {
            System.out.println("Error clicking on one of the GIFs");
        }
    }

}
