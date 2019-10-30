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


public class conversation extends BasePage {


    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postCommentInConversation(String nickName, String comment, String actualName) throws Exception {
        ConversationPage ConversationPage = new ConversationPage(driver);
        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);
        ConversationPage.clickOnComment();
        ConversationPage.enterComment(comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(), comment, "Error comment not equal data provider");

        ConversationPage.clickOnPost();

    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postGIFCommentInConversation(String nickName, String comment, String actualName) throws Exception {

        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage ConversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment();
        ConversationPage.enterComment(comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(), comment, "Error comment not equal data provider");

        ConversationPage.clickOnGifButton();
        ConversationPage.clickOnOneOfTheGifs();

        ConversationPage.clickOnPost();

    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postPhotoCommentInConversation(String nickName, String comment, String actualName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage ConversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment();
        ConversationPage.enterComment(comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(), comment, "Error comment not equal data provider");

        File file = new File("/Users/pazezrati/IdeaProjects/spotIm/web/giphy.gif");
        String path = file.getAbsolutePath();
        ConversationPage.sendPhoto(path);

        wait.until(ExpectedConditions.visibilityOf(ConversationPage.getPic()));

        ConversationPage.clickOnPost();
    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void removePhotoCommentInConversation(String nickName, String comment, String actualName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        UiUtilities uiUtilities = new UiUtilities(driver);
        ConversationPage ConversationPage = new ConversationPage(driver);

        uiUtilities.openBrandHomePage("conversation");

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment();
        ConversationPage.enterComment(comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(), comment, "Error comment not equal data provider");

        File file = new File("/Users/pazezrati/IdeaProjects/spotIm/web/giphy.gif");
        String path = file.getAbsolutePath();
        ConversationPage.sendPhoto(path);

        wait.until(ExpectedConditions.visibilityOf(ConversationPage.getPic()));

        ConversationPage.clickOnRemovePic();

        wait.until(ExpectedConditions.invisibilityOf(ConversationPage.getPic()));

        ConversationPage.clickOnPost();
    }
}
