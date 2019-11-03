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

    @FindBy(xpath = "//*[@class=\"spcv_sort-by\"]/span")
    @CacheLookup
    WebElement sortByName;

    @FindBy(xpath = "//*[@data-testid=\"close-button\"]")
    @CacheLookup
    WebElement createYourProfileCloseButton;

    @FindBy(xpath = "//*[@data-testid=\"username-input\"]")
    @CacheLookup
    WebElement createYourProfileUsernameInput;

    @FindBy(xpath = "//*[@data-testid=\"close-button\"]")
    @CacheLookup
    WebElement createYourProfileNextButton;

    @FindBy(xpath = "//*[@data-spot-im-class=\"message-timestamp\"]")
    @CacheLookup
    WebElement commentsTimeStamp;

    @FindBy(xpath = "class=\"spcv_droplist\"")
    @CacheLookup
    WebElement sortByList;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]/input")
    @CacheLookup
    WebElement nickName;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
    @CacheLookup
    WebElement addCommentGuest;

    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]")
    @CacheLookup
    WebElement clickCommentUser;

    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]/div/div[1]/div[1]")
    @CacheLookup
    WebElement addCommentUser;

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

    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-panel\"]/div/div/button")
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

    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]/div/div[1]/div[1]")
    @CacheLookup
    WebElement commentPlaceholder;

    @FindBy(xpath = "//*[@data-spot-im-class=\"message-view\"]/div/div/div/div[2]/div[1]")
    @CacheLookup
    WebElement allOnlyComments;

    @FindBy(xpath = "//*[@data-spot-im-class=\"message-view\"]/div/div/div/div[2]/div[2]")
    @CacheLookup
    WebElement allOnlyPicGifComments;

    @FindBy(xpath = "//*[@class=\"spcv_title\"]")
    @CacheLookup
    WebElement createYourProfileTitle;

    @FindBy(xpath = "//*[@class=\"spcv_droplist-container\"]/ul/li")
    @CacheLookup
    WebElement suggestionNameList;

    @FindBy(xpath = "//input[@data-testid=\"username-input\"]")
    @CacheLookup
    WebElement userNameSuggestionInput;

    @FindBy(xpath = "//input[@data-testid=\"email-input\"]")
    @CacheLookup
    WebElement createProfileEmailInput;

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

    public void clickOnNextButton() {
        Log.info("Clicking on Create your profile next button");
        try {
            createYourProfileNextButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on Create your profile next button");
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

    public void clickOnCreateYourProfileCloseButton() {
        Log.info("Clicking on create your profile close Button");
        try {
            createYourProfileCloseButton.click();
        } catch (Exception e) {
            Log.info("Error clicking on create your profile close Button");
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
        Log.info("Entering user email " + userEmail);
        try {
            userEmailForm.sendKeys(userEmail);
        } catch (Exception e) {
            Log.info("Error Entering user email");
        }
    }

    public void insertUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(integrationBox));
        Log.info("Entering user name " + userName);
        try {
            userNameForm.sendKeys(userName);
        } catch (Exception e) {
            Log.info("Error Entering user name");
        }
    }

    public void insertUserPassword(String userPassword) {
        Log.info("Entering user password " + userPassword);
        try {
            userPasswordForm.sendKeys(userPassword);
        } catch (Exception e) {
            Log.info("Error Entering user password");
        }
    }

    public void enterNickName(String myNickName) {
        Log.info("Entering nick name " + myNickName);
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

    public void createYourProfileUserNameInput(String userName) {
        Log.info("Insert user name photo - create you profile");
        try {
            createYourProfileUsernameInput.sendKeys(userName);
        } catch (Exception e) {
            Log.info("Error Insert user name photo - create you profile");
        }
    }

    public void createYourProfileUserEmailInput(String userName) {
        Log.info("Insert user email - create you profile");
        try {
            createYourProfileUsernameInput.sendKeys(userName);
        } catch (Exception e) {
            Log.info("Error Insert email - create you profile");
        }
    }

    public void clickOnComment(String userType) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.withTimeout(10, TimeUnit.SECONDS);
        Log.info("Clicking on Comment");
        try {
            if (userType.equals("Guest")) {
                addCommentGuest.click();
            } else if (userType.equals("User")) {
                clickCommentUser.click();
            }
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

    public void enterComment(String userType, String myComment) {
        Log.info("Entering Comment");
        try {
            if (userType.equals("Guest")) {
                addCommentGuest.sendKeys(myComment);
            } else if (userType.equals("User")) {
                addCommentUser.sendKeys(myComment);
            }
        } catch (Exception e) {
            Log.info("Error Entering Comment");
        }
    }

    public String getUserNameAfterLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.withTimeout(10, TimeUnit.SECONDS);
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

    public String getCommentPlaceholder() {
        String title = null;
        Log.info("Getting Comment placeHolder");
        try {
            title = commentPlaceholder.getAttribute("data-placeholder");
            Log.info("Comment placeHolder is : " + title);
        } catch (Exception e) {
            Log.info("Error getting Comment placeHolder");
        }
        return title;
    }

    public String getCreateYourProfilePlaceholder() {
        String title = null;
        Log.info("Getting Create your profile title");
        try {
            title = createYourProfileTitle.getText();
            Log.info("Create your profile title is : " + title);
        } catch (Exception e) {
            Log.info("Error getting Create your profile title");
        }
        return title;
    }

    public void clickOnSortBy() {
        Log.info("Clicking on SortBy");
        try {
            sortByName.click();
        } catch (Exception e) {
            Log.info("Error clicking on SortBy");
        }
    }

    public void chooseSortByFromList(String sortByOption) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Log.info("Choosing sort by");
        try {
            List<WebElement> sortBy = driver.findElements(By.xpath("//*[@class=\"spcv_droplist\"]/li"));
            for (int x = 0; x < sortBy.size(); x++) {
                if (sortBy.get(x).getText().contains(sortByOption)) {
                    Log.info("Clicking on " + sortBy.get(x).getText() + " from sort by list");
                    sortBy.get(x).click();
                    wait.until(ExpectedConditions.invisibilityOf(sortByList));
                    break;
                }
            }
        } catch (Exception e) {
            Log.info("Error choosing sort by "+sortByOption);
        }
    }

    public String getSortName() {
        String fullSortName = null;
        Log.info("Getting sort name");
        try {
            fullSortName = sortByName.getText();
            Log.info("The sort name is: " + fullSortName);
        } catch (Exception e) {
            Log.info("Error getting sort name");
        }
        return fullSortName;
    }

    public String getUserNameBeforeLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.withTimeout(10, TimeUnit.SECONDS);
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

    public String getComment(String userType) {
        String fullComment = null;
        Log.info("Getting comment as " + userType);
        try {
            if (userType.equals("Guest")) {
                fullComment = addCommentGuest.getText();
            } else if (userType.equals("User")) {
                fullComment = addCommentUser.getText();
            }
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
                break;
            }
        } catch (Exception e) {
            Log.info("Error clicking on one of the GIFs");
        }
    }

    public String getTheFirstComment() {
        String firstComment = null;
        Log.info("Getting the first comment");
        try {
            List<WebElement> comments = driver.findElements(By.xpath("//*[@data-spot-im-class=\"message-view\"]/div/div/div/div[2]/div[1]"));
            for (int x = 0; x < comments.size(); x++) {
                firstComment=comments.get(x).getText();
                Log.info("The first comment is "+firstComment);
                comments.get(x).click();
                break;
            }
        } catch (Exception e) {
            Log.info("Error Getting the first comment");
        }return firstComment;
    }

    public String getTheCommentsTimeStamp(String sortName) {
        String firstCommentTimeStamp = null;
        Log.info("Getting the first comment time stamp");
        try {
            List<WebElement> commentsTimeStamps = driver.findElements(By.xpath("//*[@data-spot-im-class=\"message-timestamp\"]"));
            for (int x = 0; x < commentsTimeStamps.size(); x++) {
                firstCommentTimeStamp=commentsTimeStamps.get(x).getText();
                Log.info("The first comment time stamp is "+firstCommentTimeStamp+ " this is the "+sortName+" comment");
                commentsTimeStamps.get(x).click();
                break;
            }
        } catch (Exception e) {
            Log.info("Error Getting the first comment time stamp");
        }return firstCommentTimeStamp;
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
        System.out.println("Choosing option " + option);
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

    public void chooseNameFromSuggestionsList(String suggest) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(suggestionNameList));
        System.out.println("Choosing suggest that contains: " + suggest);
        try {
            List<WebElement> suggestionList = driver.findElements(By.xpath("//*[@class=\"spcv_droplist-container\"]/ul/li/span"));
            for (int x = 1; x < suggestionList.size(); x++) {
                if (suggestionList.get(x).getText().contains(suggest)) {
                    System.out.println("Clicking on " + suggestionList.get(x).getText() + " from suggestions list");
                    suggestionList.get(x).click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error choosing suggest name");
        }
    }

    public String getSuggestNameFromInput() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf(suggestionNameList));
        String inputName = null;
        Log.info("Getting the suggest name from input");
        try {
            inputName = userNameSuggestionInput.getAttribute("value");
            Log.info("the suggest name from input is: " + inputName);
        } catch (Exception e) {
            Log.info("Error getting suggest name from input");
        }
        return inputName;
    }

    public String getCreateYourProfileEmailPlaceholder() {
        String emailPlaceholder = null;
        Log.info("Getting Create your profile email placeholder");
        try {
            emailPlaceholder = createProfileEmailInput.getText();
            Log.info("Create your profile title is : " + emailPlaceholder);
        } catch (Exception e) {
            Log.info("Error getting Create your profile email placeholder");
        }
        return emailPlaceholder;
    }

}