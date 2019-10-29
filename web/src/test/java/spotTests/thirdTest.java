package spotTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.conversation.ConversationPage;
import utilities.BasePage;
import utilities.DataProvider;

import java.util.concurrent.TimeUnit;

public class thirdTest extends BasePage {


    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postCommentInConversation(String nickName, String comment,String actualName) throws InterruptedException {

        ConversationPage ConversationPage = new ConversationPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment();
        ConversationPage.enterComment(comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(), comment, "Error comment not equal data provider");

        ConversationPage.clickOnPost();

    }

    @Test(alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataProvider.class)
    public void postGIFCommentInConversation(String nickName, String comment,String actualName) throws InterruptedException {

        ConversationPage ConversationPage = new ConversationPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
    public void postPhotoCommentInConversation(String nickName, String comment,String actualName) throws InterruptedException {

        String photo = null;

        ConversationPage ConversationPage = new ConversationPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        ConversationPage.clickOnNickName();
        ConversationPage.enterNickName(nickName);

        ConversationPage.clickOnComment();
        ConversationPage.enterComment(comment);

        Assert.assertEquals(ConversationPage.getNickName(), actualName, "Error nickName not equal data provider");
        Assert.assertEquals(ConversationPage.getComment(), comment, "Error comment not equal data provider");

        ConversationPage.clickOnPhotoButton();



        ConversationPage.sendPhoto("Macintosh HD//users//pazezrati//Desktop//giphy");



        ConversationPage.clickOnPost();

    }
    }