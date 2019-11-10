package spotTests;

import com.jayway.restassured.path.json.JsonPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.conversation.ConversationPage;
import utilities.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;

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

        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");
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

        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");
    }

    @Test(alwaysRun = true, dataProvider = "replyCommentAsUser", dataProviderClass = DataProvider.class)
    public void postHierarchyReplayCommentAsLoginUserConversation(String userType, String email, String password, String actualName, String comment, String replyPlaceholder, String reply) throws Exception {
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

        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");
        conversationPage.clickTheFirstCommentReply();
        Assert.assertTrue(conversationPage.gettingReplyCommentPlaceholder("Reply to", reply).contains(replyPlaceholder), "Error: reply place holder doesn't equal tp DP");
        conversationPage.clickOnPostReply();

        Assert.assertEquals(conversationPage.getTheReplayComment(reply), reply, "Error: the comment doesn't match DP");

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
        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");

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
        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");

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
        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");
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

    @Test(alwaysRun = true, dataProvider = "createProfileConversation", dataProviderClass = DataProvider.class)
    public void createYourProfileConversation(String userType, String nickName, String comment, String actualName, String placeHolderName, String nameSuggest, String placeHolderEmail, String email) throws Exception {
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

        Assert.assertEquals(conversationPage.getTheFirstComment(), comment, "Error: the comment doesn't match DP");

        Assert.assertEquals(conversationPage.getCreateYourProfilePlaceholder(), placeHolderName, "Error: the place holder doesn't match DP");

        conversationPage.createYourProfileUserNameInput("automation");

        conversationPage.chooseNameFromSuggestionsList(nameSuggest);
        Assert.assertTrue(conversationPage.getSuggestNameFromInput().contains(nameSuggest), "Error: suggest name from input doesn't contain the name from DP");

        conversationPage.clickOnNextButton();

        // There is current issue about the next steps ...

//        Assert.assertEquals(conversationPage.getCreateYourProfileEmailPlaceholder(),placeHolderEmail,"Error: the place holder doesn't match DP");
//
//        conversationPage.createYourProfileUserEmailInput(email);
    }

    @Test(alwaysRun = true)
    public void foxNewsCommentsUiApiTest() throws Exception {
        UiUtilities uiUtilities = new UiUtilities(driver);
        Actions actions = new Actions(driver);
        General general = new General(driver);
        ElementWait elementWait = new ElementWait(driver);

        uiUtilities.openBrandHomePage("conversationFoxNewsProduction");

        Thread.sleep(5000);

        List<WebElement> foxArticles = driver.findElements(By.xpath("//*[@class=\"collection collection-article-list\"]/div/article/div[1]"));
        Log.info("The amount of articles are " + foxArticles.size());
        for (int i = 0; i < foxArticles.size(); i++) {
            Log.info("Clicking on one of the articles");
            foxArticles.get(i).click();
            List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
            if (browserTabs.size() > 1) {
                Log.info("Changing tab");
                general.changeTab(1);

            }
            if (browser.equals("iPad")) {
                foxArticles.get(i).sendKeys(Keys.ENTER);
                actions.click(foxArticles.get(i)).perform();
            }
            break;
        }

        Thread.sleep(5000);

        String foxArticleHeader = driver.findElement(By.xpath("//*[@class=\"headline\"]")).getText();
        Log.info("The header of the article is " + foxArticleHeader);

        Thread.sleep(3000);

        if (browser.equals("iPad")) {
            Log.info("Scrolling down");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,3700)");
            Log.info("Finished Scrolling down - ipad");
            Thread.sleep(3000);
        } else if (browser.equals("Chrome")) {
            general.scrollPage("3150");
            Log.info("Finished Scrolling down - chrome");

            elementWait.waitForElementToAppear_xpth("//*[@data-spot-im-class='conversation-header']", 20);

            WebElement spotImHeader = driver.findElement(By.xpath("//*[@data-spot-im-class=\"header-text\"]"));

            actions = new Actions(driver);
            actions.moveToElement(spotImHeader);
            actions.perform();

            Thread.sleep(3000);

            // API testing
            String url = null;
            String payload = null;


            url = "https://api-2-0.spot.im/v1.0.0/conversation/realtime/read";
            org.testng.Reporter.log("Api: " + url, true);

            payload = "{\"timestamp\":1573044400,\"data\":{\"conversation/new-messages\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\"}],\"conversation/count-messages\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\"}],\"online/users\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\"}],\"conversation/updated-messages\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\"}],\"conversation/deleted-messages\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\",\"message_ids\":[]}],\"conversation/typing-v2-users\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\",\"message_ids\":[]}],\"conversation/notifications-count\":[{\"conversation_id\":\"sp_ANQXRpqH_urn$3Auri$3Abase64$3Afb100796-a4ce-5d67-8050-cd5cfa28fadc\"}]}}";

            org.testng.Reporter.log("Api Body to POST: " + payload, true);

            List<WebElement> id = driver.findElements(By.xpath("//*[@data-message-id]"));
            String fullSpotId = null;
            for (int i = 0; i < id.size(); i++) {
                fullSpotId = id.get(i).getAttribute("data-message-id");
                Log.info("The full spot id from css is : " + fullSpotId);
                break;
            }

            // Starting with API

            String xSpotId = "sp_ANQXRpqH";
            String xSpotIdRequest = fullSpotId.substring(0, 11);
            Log.info("The spotId sub " + xSpotIdRequest);
            String forRequest = fullSpotId.substring(0, fullSpotId.length() - 9);
            Log.info("The forRequest sub " + forRequest);
            String xPostIdFirst = fullSpotId.replace("sp_ANQXRpqH_urn$3Auri$3A", "").replace("$3A", ":");
            Log.info("The first sub " + xPostIdFirst);
            String xPostIdlAST = xPostIdFirst.substring(0, xPostIdFirst.length() - 9);
            Log.info("The second sub " + xPostIdlAST);
            String xPostId = "urn:uri:" + xPostIdlAST;
            Log.info("The LAST sub " + xPostId);

            String response =
                    given()
                            .contentType("application/json")
                            .given().header("x-spot-id", xSpotId)
                            .given().header("x-post-id", xPostId)
                            .body(payload)
                            .when()
                            .post(url).peek()
                            .then()
                            .extract()
                            .asString();
            JsonPath jp = new JsonPath(response);
            org.testng.Reporter.log(response.toString(), true);
            String code = null;


            String replies = jp.get("data.conversation/count-messages." + forRequest + ".Replies").toString();
            String comments = jp.get("data.conversation/count-messages." + forRequest + ".Comments").toString();

            String newReplies = replies.replace("[", "").replace("]", "");
            String newComments = comments.replace("[", "").replace("]", "");

            Log.info("REPLIES: " + newReplies);
            Log.info("comments: " + newComments);

            int repliesBack = Integer.parseInt(newReplies);
            int commentsBack = Integer.parseInt(newComments);

            String allCommentsFromBack = String.valueOf(repliesBack + commentsBack);
            Log.info("The number of comments from API : " + allCommentsFromBack);

            // Refreshing the page
            driver.navigate().refresh();
            Thread.sleep(2000);
            // Getting UI comments
            String spotComments = driver.findElement(By.xpath("//*[@data-spot-im-class=\"comments-count\"]")).getText().replace("(", "").replace(")", "").replace(",", "");
            Log.info("The number of comments from FRONT : " + spotComments);

            Assert.assertEquals(spotComments, allCommentsFromBack, "Error: does not match !");
        }
    }
}