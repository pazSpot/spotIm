package spotTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.conversation.ConversationPage;
import pageObject.conversation.StarReviewsPage;
import utilities.BasePage;
import utilities.DataProvider;
import utilities.UiUtilities;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class conversation extends BasePage {


    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postCommentAsGuestConversation(String userType,String nickName, String comment, String actualName) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);
        ConversationPage.clickOnComment(userType);
        ConversationPage.enterComment(userType,comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(userType), comment, "Error comment not equal data provider");

        ConversationPage.clickOnPost();

        // need to add assert for the comment !!!

    }

    @Test(alwaysRun = true, dataProvider = "commentAsUser", dataProviderClass = DataProvider.class)
    public void postCommentAsLoginUserConversation(String userType, String email, String password, String actualName, String comment) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnLogInHomePageButton();
        ConversationPage.insertUserEmail(email);
        ConversationPage.insertUserPassword(password);
        ConversationPage.clickOnLoginButton();
        Assert.assertEquals(ConversationPage.getUserNameAfterLogin(), actualName, "Error: user name doesn't matching to DP");

        ConversationPage.clickOnComment(userType);
        Assert.assertEquals(ConversationPage.getCommentPlaceholder(), "Add a comment...", "Error comment not equal data provider");

        ConversationPage.enterComment(userType,comment);

        Assert.assertEquals(ConversationPage.getComment(userType), comment, "Error comment not equal data provider");

        ConversationPage.clickOnPost();

    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postGIFCommentAsGuestInConversation(String userType,String nickName, String comment, String actualName) throws Exception {

        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage ConversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment(userType);
        ConversationPage.enterComment(userType,comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(userType), comment, "Error comment not equal data provider");

        ConversationPage.clickOnGifButton();
        ConversationPage.clickOnOneOfTheGifs();

        ConversationPage.clickOnPost();
    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postPhotoCommentAsGuestInConversation(String userType,String nickName, String comment, String actualName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage ConversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment(userType);
        ConversationPage.enterComment(userType,comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(userType), comment, "Error comment not equal data provider");

        File file = new File("/Users/pazezrati/IdeaProjects/spotIm/web/giphy.gif");
        String path = file.getAbsolutePath();
        ConversationPage.sendPhoto(path);

        wait.until(ExpectedConditions.visibilityOf(ConversationPage.getPic()));

        ConversationPage.clickOnPost();
    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void removePhotoCommentAsGuestInConversation(String userType, String nickName, String comment, String actualName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage ConversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment(userType);
        ConversationPage.enterComment(userType,comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(userType), comment, "Error comment not equal data provider");

        File file = new File("/Users/pazezrati/IdeaProjects/spotIm/web/giphy.gif");
        String path = file.getAbsolutePath();
        ConversationPage.sendPhoto(path);

        wait.until(ExpectedConditions.visibilityOf(ConversationPage.getPic()));

        ConversationPage.clickOnRemovePic();

        wait.until(ExpectedConditions.invisibilityOf(ConversationPage.getPic()));

        ConversationPage.clickOnPost();
    }

    @Test(alwaysRun = true, dataProvider = "sortList", dataProviderClass = DataProvider.class)
    public void clickOnSortBy(String sortName) throws Exception {
        StarReviewsPage starReviewsPage = new StarReviewsPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");
        starReviewsPage.clickOnSortBy();
        starReviewsPage.chooseSortByFromList(sortName);

        Assert.assertEquals(starReviewsPage.getSortName(), sortName, "Error: sort name doesn't match to DP");
    }

    @Test(alwaysRun = true, dataProvider = "conversationLogin", dataProviderClass = DataProvider.class)
    public void logInProfileConversation(String email, String password, String actualName) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnLogInHomePageButton();
        ConversationPage.insertUserEmail(email);
        ConversationPage.insertUserPassword(password);
        ConversationPage.clickOnLoginButton();

        Assert.assertEquals(ConversationPage.getUserNameAfterLogin(), actualName, "Error: user name dosn't matching to DP");
    }

    @Test(alwaysRun = true, dataProvider = "conversationLogin", dataProviderClass = DataProvider.class)
    public void logOutProfileConversation(String email, String password, String actualName) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnLogInHomePageButton();
        ConversationPage.insertUserEmail(email);
        ConversationPage.insertUserPassword(password);
        ConversationPage.clickOnLoginButton();

        Assert.assertEquals(ConversationPage.getUserNameAfterLogin(), actualName, "Error: user name doesn't matching to DP");

        ConversationPage.clickOnHandlerAfterLogin();
        ConversationPage.chooseUserOptionsFromHandlerList("Log Out");
        Assert.assertEquals(ConversationPage.getUserNameBeforeLogin(), "Log In", "Error: user name doesn't matching to DP");
    }

    @Test(alwaysRun = true, dataProvider = "conversationSignUp", dataProviderClass = DataProvider.class)
    public void joinProfileConversation(String userName, String email, String password) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnLogInHomePageButton();
        ConversationPage.clickOnJoinFormButton();

        ConversationPage.insertUserName(userName);
        ConversationPage.insertUserEmail(email);
        ConversationPage.insertUserPassword(password);

        Thread.sleep(6000); // waiting for login button will be enable
        ConversationPage.clickOnLoginButton();
        Thread.sleep(6000); // waiting for loader

        Assert.assertEquals(ConversationPage.getUserNameAfterLogin(), userName, "Error: user name dosn't matching to DP");
    }

    @Test(alwaysRun = true, dataProvider = "forgotPassword", dataProviderClass = DataProvider.class)
    public void forgotPasswordConversation(String email, String forgotPassword) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnLogInHomePageButton();
        ConversationPage.clickOnForgotPasswordButton();
        ConversationPage.insertUserEmail(email);
        ConversationPage.clickOnLoginButton();

        Assert.assertEquals(ConversationPage.getForgotPasswordSuccessMessage(), forgotPassword, "Error: forgot password doesn't match DP");
    }

    @Test(alwaysRun = true, dataProvider = "userOptions", dataProviderClass = DataProvider.class)
    public void profileMyActivityConversation(String email, String password, String actualName,String option,String header) throws Exception {

        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnLogInHomePageButton();
        ConversationPage.insertUserEmail(email);
        ConversationPage.insertUserPassword(password);
        ConversationPage.clickOnLoginButton();

        Assert.assertEquals(ConversationPage.getUserNameAfterLogin(), actualName, "Error: user name dosn't matching to DP");

        ConversationPage.clickOnHandlerAfterLogin();
        ConversationPage.chooseUserOptionsFromHandlerList(option);

        Assert.assertEquals(ConversationPage.getHeaderAfterHandler(),header,"Error: header does not match DP");
    }
}
