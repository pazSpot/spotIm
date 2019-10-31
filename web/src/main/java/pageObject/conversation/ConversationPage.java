package pageObject.conversation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//*[@class='spcv_file-input']")
    @CacheLookup
    WebElement photoUpload;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/a")
    @CacheLookup
    WebElement picUpload;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/button")
    @CacheLookup
    WebElement postButton;

    @FindBy(xpath = "//*[@class='spcv_button-text']")
    @CacheLookup
    WebElement removePicButton;

    @FindBy(xpath = "//*[@class='spcv_login-button']")
    @CacheLookup
    WebElement logInHomePageButton;

    @FindBy(xpath = "//*[@data-spot-im-class=\"registration-buttons\"]/span/span")
    @CacheLookup
    WebElement logInHomePageTitle;

    @FindBy(xpath = "//*[@data-testid='input-email']")
    @CacheLookup
    WebElement userEmailForm;

    @FindBy(xpath = "//*[@data-testid='input-password']")
    @CacheLookup
    WebElement userPasswordForm;

    @FindBy(xpath = "//*[@data-testid='input-username']")
    @CacheLookup
    WebElement userNameForm;

    @FindBy(xpath = "//*[@data-testid='big-button']")
    @CacheLookup
    WebElement loginFormButton;

    @FindBy(xpath = "//*[@data-testid='chevronButton']")
    @CacheLookup
    WebElement joinButton;

    @FindBy(xpath = "//*[@data-spot-im-class='handler']/span")
    @CacheLookup
    WebElement userNameAfterLogin;

    @FindBy(xpath = "//*[@data-testid=\"button\"]")
    @CacheLookup
    WebElement forgotPassword;

    @FindBy(xpath = "//*[@data-testid=\"registration-modal\"]")
    @CacheLookup
    WebElement integrationBox;

    @FindBy(xpath = "//*[@class=\"sc-cLQEGU gRGlKa\"]")
    @CacheLookup
    WebElement forgotPasswordSuccess;

    @FindBy(xpath = "//*[@data-spot-im-class=\"handler\"]")
    @CacheLookup
    WebElement handlerAfterLogin;

    @FindBy(xpath = "//*[@class='styles__Header-sc-1wa2pv7-2 eYhViq']")
    @CacheLookup
    WebElement headerFromProfileForm;

    WebDriver driver;

    public ConversationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogInHomePageButton() {
        Log.info("Clicking on Login Home page button");
        try {
            logInHomePageButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on login Home page button");
        }
    }

    public void clickOnHandlerAfterLogin() {
        Log.info("Clicking on handler After Login button");
        try {
            handlerAfterLogin.click();
        } catch (Exception e) {
            Log.info("Error clicking on handler After Login button");
        }
    }


    public void clickOnForgotPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(integrationBox));
        Log.info("Clicking on forgot password button");
        try {
            forgotPassword.click();
        } catch (Exception e) {
            Log.info("Error clicking on forgot password button");
        }
    }

    public void clickOnJoinFormButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(integrationBox));
        Log.info("Clicking on Join button");
        try {
            joinButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on join button");
        }
    }

    public void clickOnLoginButton() {
        Log.info("Clicking on Login button");
        try {
            loginFormButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on login button");
        }
    }

    public void clickOnNickName() {
        Log.info("Clicking on Nick Name");
        try {
            nickName.click();
        } catch (Exception e) {
            Log.info("Error clicking on nick name");
        }
    }

    public void clickOnGifButton() {
        Log.info("Clicking on GIF Button");
        try {
            gifButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on GIF Button");
        }
    }

    public void insertUserEmail(String userEmail) {
        Log.info("Entering user email "+userEmail);
        try {
            userEmailForm.sendKeys(userEmail);
        } catch (Exception e) {
            Log.info("Error Entering user email");
        }
    }

    public void insertUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(integrationBox));
        Log.info("Entering user name "+ userName);
        try {
            userNameForm.sendKeys(userName);
        } catch (Exception e) {
            Log.info("Error Entering user name");
        }
    }

    public void insertUserPassword(String userPassword) {
        Log.info("Entering user password "+userPassword);
        try {
            userPasswordForm.sendKeys(userPassword);
        } catch (Exception e) {
            Log.info("Error Entering user password");
        }
    }

    public void enterNickName(String myNickName) {
        Log.info("Entering nick name "+myNickName);
        try {
            nickName.sendKeys(myNickName);
        } catch (Exception e) {
            Log.info("Error Entering first name");
        }
    }

    public void sendPhoto(String path) {
        Log.info("Entering photo");
        try {
            photoUpload.sendKeys(path);
        } catch (Exception e) {
            Log.info("Error Entering photo");
        }
    }

    public void clickOnComment() {
        Log.info("Clicking on Comment");
        try {
            addComment.click();
        } catch (Exception e) {
            Log.info("Error clicking on Comment");
        }
    }

    public void clickOnPost() {
        Log.info("Clicking on Post");
        try {
            postButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on Post");
        }
    }

    public void clickOnRemovePic() {
        Log.info("Clicking on Remove pic");
        try {
            removePicButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on Remove pic");
        }
    }

    public void enterComment(String myComment) {
        Log.info("Entering Comment");
        try {
            addComment.sendKeys(myComment);
        } catch (Exception e) {
            Log.info("Error Entering Comment");
        }
    }

    public String getUserNameAfterLogin() {
        String fullNickName = null;
        Log.info("Getting user name after login");
        try {
            fullNickName = userNameAfterLogin.getText();
            Log.info("user name after login is: " + fullNickName);
        } catch (Exception e) {
            Log.info("Error getting user name after login");
        }
        return fullNickName;
    }

    public String getUserNameBeforeLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.withTimeout(5, TimeUnit.SECONDS);
        String fullNickName = null;
        Log.info("Getting user name before login");
        try {
            fullNickName = logInHomePageTitle.getText();
            Log.info("user name before login is: " + fullNickName);
        } catch (Exception e) {
            Log.info("Error getting user name before login");
        }
        return fullNickName;
    }


    public String getNickName() {
        String fullNickName = null;
        Log.info("Getting full name");
        try {
            fullNickName = nickName.getAttribute("value");
            Log.info("The nick name is: " + fullNickName);
        } catch (Exception e) {
            Log.info("Error getting nick name");
        }
        return fullNickName;
    }

    public String getForgotPasswordSuccessMessage() {
        String fullSuccess = null;
        Log.info("Getting Forgot password message ");
        try {
            fullSuccess = forgotPasswordSuccess.getText();
            Log.info("Forgot password is: " + fullSuccess);
        } catch (Exception e) {
            Log.info("Error getting Forgot password message");
        }
        return fullSuccess;
    }

    public String getComment() {
        String fullComment = null;
        Log.info("Getting comment");
        try {
            fullComment = addComment.getText();
            Log.info("The comment is: " + fullComment);
        } catch (Exception e) {
            Log.info("Error getting the comment");
        }
        return fullComment;
    }

    public void clickOnOneOfTheGifs() {
        Log.info("Clicking on one of the GIF's");
        try {
            List<WebElement> gifs = driver.findElements(By.xpath("//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/span/div[2]/div/div/div/div/div"));
            for (int x = 0; x < gifs.size(); x++) {
                gifs.get(x).click();
            }
        } catch (Exception e) {
            Log.info("Error clicking on one of the GIFs");
        }
    }

    public WebElement getPic() {
        Log.info("Getting pic ..");
        WebElement pic = null;
        try {
            pic = picUpload;
        } catch (Exception e) {
            Log.info("Error: Didn't wait enoth for the Picture ");
        }
        return pic;
    }


    public void chooseUserOptionsFromHandlerList(String option) {
        System.out.println("Choosing option "+option);
        try {
            List<WebElement> options = driver.findElements(By.xpath("//*[@class='spcv_item']"));
            for (int x = 0; x < options.size(); x++) {
                if (options.get(x).getText().contains(option)) {
                    System.out.println("Clicking on " + options.get(x).getText() + " from options list");
                    options.get(x).click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error choosing user option");
        }
    }

    public String getHeaderAfterHandler() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(headerFromProfileForm));
        String fullHeader = null;
        Log.info("Getting the header after handler option");
        try {
            fullHeader = headerFromProfileForm.getText();
            Log.info("header after handler option is: " + fullHeader);
        } catch (Exception e) {
            Log.info("Error getting header after handler option");
        }
        return fullHeader;
    }

}