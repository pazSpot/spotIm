package spotTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.conversation.ConversationPage;
import utilities.BasePage;
import utilities.DataProvider;
import utilities.UiUtilities;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class conversation extends BasePage {


    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postCommentAsGuestConversation(String userType, String nickName, String comment, String actualName) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnNickName();
        conversationPage.enterNickName(nickName);
        conversationPage.clickOnComment(userType);
        conversationPage.enterComment(userType, comment);

        Assert.assertEquals(conversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(conversationPage.getComment(userType), comment, "Error comment not equal data provider");

        conversationPage.clickOnPost();

        Assert.assertEquals(conversationPage.getTheFirstComment(),comment,"Error: the comment doesn't match DP");
    }

    @Test(alwaysRun = true, dataProvider = "commentAsUser", dataProviderClass = DataProvider.class)
    public void postCommentAsLoginUserConversation(String userType, String email, String password, String actualName, String comment) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnLogInHomePageButton();
        conversationPage.insertUserEmail(email);
        conversationPage.insertUserPassword(password);
        conversationPage.clickOnLoginButton();
        Assert.assertEquals(conversationPage.getUserNameAfterLogin(), actualName, "Error: user name doesn't matching to DP");

        conversationPage.clickOnComment(userType);
        Assert.assertEquals(conversationPage.getCommentPlaceholder(), "Add a comment...", "Error comment not equal data provider");

        conversationPage.enterComment(userType, comment);

        Assert.assertEquals(conversationPage.getComment(userType), comment, "Error comment not equal data provider");

        conversationPage.clickOnPost();

        Assert.assertEquals(conversationPage.getTheFirstComment(),comment,"Error: the comment doesn't match DP");
    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postGIFCommentAsGuestInConversation(String userType, String nickName, String comment, String actualName) throws Exception {

        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage conversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnNickName();
        conversationPage.enterNickName(nickName);

        conversationPage.clickOnComment(userType);
        conversationPage.enterComment(userType, comment);

        Assert.assertEquals(conversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(conversationPage.getComment(userType), comment, "Error comment not equal data provider");

        conversationPage.clickOnGifButton();
        conversationPage.clickOnOneOfTheGifs();

        conversationPage.clickOnPost();
        Assert.assertEquals(conversationPage.getTheFirstComment(),comment,"Error: the comment doesn't match DP");

    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postPhotoCommentAsGuestInConversation(String userType, String nickName, String comment, String actualName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage conversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnNickName();
        conversationPage.enterNickName(nickName);

        conversationPage.clickOnComment(userType);
        conversationPage.enterComment(userType, comment);

        Assert.assertEquals(conversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(conversationPage.getComment(userType), comment, "Error comment not equal data provider");

        File file = new File("/Users/pazezrati/IdeaProjects/spotIm/web/giphy.gif");
        String path = file.getAbsolutePath();
        conversationPage.sendPhoto(path);

        wait.until(ExpectedConditions.visibilityOf(conversationPage.getPic()));

        conversationPage.clickOnPost();
        Assert.assertEquals(conversationPage.getTheFirstComment(),comment,"Error: the comment doesn't match DP");

    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void removePhotoCommentAsGuestInConversation(String userType, String nickName, String comment, String actualName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage conversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnNickName();
        conversationPage.enterNickName(nickName);

        conversationPage.clickOnComment(userType);
        conversationPage.enterComment(userType, comment);

        Assert.assertEquals(conversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(conversationPage.getComment(userType), comment, "Error comment not equal data provider");

        File file = new File("/Users/pazezrati/IdeaProjects/spotIm/web/giphy.gif");
        String path = file.getAbsolutePath();
        conversationPage.sendPhoto(path);

        wait.until(ExpectedConditions.visibilityOf(conversationPage.getPic()));

        conversationPage.clickOnRemovePic();

        wait.until(ExpectedConditions.invisibilityOf(conversationPage.getPic()));

        conversationPage.clickOnPost();
        Assert.assertEquals(conversationPage.getTheFirstComment(),comment,"Error: the comment doesn't match DP");
    }

    @Test(alwaysRun = true, dataProvider = "sortList", dataProviderClass = DataProvider.class)
    public void clickOnSortBy(String sortName) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");
        conversationPage.clickOnSortBy();
        conversationPage.chooseSortByFromList(sortName);

        Assert.assertEquals(conversationPage.getSortName(), sortName, "Error: sort name doesn't match to DP");

        conversationPage.getTheCommentsTimeStamp(sortName);
    }

    @Test(alwaysRun = true, dataProvider = "conversationLogin", dataProviderClass = DataProvider.class)
    public void logInProfileConversation(String email, String password, String actualName) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnLogInHomePageButton();
        conversationPage.insertUserEmail(email);
        conversationPage.insertUserPassword(password);
        conversationPage.clickOnLoginButton();

        Assert.assertEquals(conversationPage.getUserNameAfterLogin(), actualName, "Error: user name dosn't matching to DP");
    }

    @Test(alwaysRun = true, dataProvider = "conversationLogin", dataProviderClass = DataProvider.class)
    public void logOutProfileConversation(String email, String password, String actualName) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnLogInHomePageButton();
        conversationPage.insertUserEmail(email);
        conversationPage.insertUserPassword(password);
        conversationPage.clickOnLoginButton();

        Assert.assertEquals(conversationPage.getUserNameAfterLogin(), actualName, "Error: user name doesn't matching to DP");

        conversationPage.clickOnHandlerAfterLogin();
        conversationPage.chooseUserOptionsFromHandlerList("Log Out");
        Assert.assertEquals(conversationPage.getUserNameBeforeLogin(), "Log In", "Error: user name doesn't matching to DP");
    }

    @Test(alwaysRun = true, dataProvider = "conversationSignUp", dataProviderClass = DataProvider.class)
    public void joinProfileConversation(String userName, String email, String password) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnLogInHomePageButton();
        conversationPage.clickOnJoinFormButton();

        conversationPage.insertUserName(userName);
        conversationPage.insertUserEmail(email);
        conversationPage.insertUserPassword(password);

        Thread.sleep(6000); // waiting for login button will be enable
        conversationPage.clickOnLoginButton();
        Thread.sleep(6000); // waiting for loader

        Assert.assertEquals(conversationPage.getUserNameAfterLogin(), userName, "Error: user name dosn't matching to DP");
    }

    @Test(alwaysRun = true, dataProvider = "forgotPassword", dataProviderClass = DataProvider.class)
    public void forgotPasswordConversation(String email, String forgotPassword) throws Exception {
        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnLogInHomePageButton();
        conversationPage.clickOnForgotPasswordButton();
        conversationPage.insertUserEmail(email);
        conversationPage.clickOnLoginButton();

        Assert.assertEquals(conversationPage.getForgotPasswordSuccessMessage(), forgotPassword, "Error: forgot password doesn't match DP");
    }

    @Test(alwaysRun = true, dataProvider = "userOptions", dataProviderClass = DataProvider.class)
    public void profileMyActivityConversation(String email, String password, String actualName, String option, String header) throws Exception {

        ConversationPage conversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        conversationPage.clickOnLogInHomePageButton();
        conversationPage.insertUserEmail(email);
        conversationPage.insertUserPassword(password);
        conversationPage.clickOnLoginButton();

        Assert.assertEquals(conversationPage.getUserNameAfterLogin(), actualName, "Error: user name dosn't matching to DP");

        conversationPage.clickOnHandlerAfterLogin();
        conversationPage.chooseUserOptionsFromHandlerList(option);

        Assert.assertEquals(conversationPage.getHeaderAfterHandler(), header, "Error: header does not match DP");
    }
}
