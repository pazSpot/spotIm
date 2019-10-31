package conversation;

import com.jayway.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.conversation.ConversationApiUtilities;

public class Comment extends ConversationApiUtilities {

    @Test
    public void postMyCommentGuest() throws Exception {


        JsonPath jp = ConversationApiUtilities.oathAuthentication();

        // get from response:
        String token = jp.get("token").toString();
        Reporter.log("token: " + token, true);

        jp = ConversationApiUtilities.postCommentGuest(token);

        // get from response:
        String status = jp.get("status").toString();
        Reporter.log("status: " + status, true);

        String type = jp.get("type").toString();
        Reporter.log("type: " + type, true);

        String contentType = jp.get("content.type[0]").toString();
        Reporter.log("contentType: " + contentType, true);


        Assert.assertEquals(status, "approve_all", "Error: status doesn't match!");
        Assert.assertEquals(type, "comment", "Error: Type doesn't match!");
        Assert.assertEquals(contentType, "text", "Error: contentType doesn't match!");

    }

    @Test
    public void postMyComment() throws Exception {

        JsonPath jp = ConversationApiUtilities.oathAuthentication();

        // get from response:
        String spotid = jp.get("user_id").toString();
        String spotid1 = "sp_" + spotid;

        Reporter.log("user_id: " + spotid, true);

        String token = jp.get("token").toString();
        Reporter.log("token: " + token, true);

        jp = ConversationApiUtilities.postCommentMember(token, spotid1);

        // get from response:
        String status = jp.get("status").toString();
        Reporter.log("status: " + status, true);

        String type = jp.get("type").toString();
        Reporter.log("type: " + type, true);

        String contentType = jp.get("content.type[0]").toString();
        Reporter.log("contentType: " + contentType, true);


        Assert.assertEquals(status, "approve_all", "Error: status doesn't match!");
        Assert.assertEquals(type, "comment", "Error: Type doesn't match!");
        Assert.assertEquals(contentType, "text", "Error: contentType doesn't match!");


    }
}
