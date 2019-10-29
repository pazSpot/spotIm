package utilities.conversation;

import com.jayway.restassured.path.json.JsonPath;
import jdk.javadoc.doclet.Reporter;
import org.testng.SkipException;

import static com.jayway.restassured.RestAssured.given;

public class ConversationApiUtilities {


    public static JsonPath oathAuthentication()
            throws Exception {

        String url = null;

        url = "https://www.spot.im/api/me/network-token/spotim";
        org.testng.Reporter.log("Api: " + url, true);

        String response =
                given()
                        .given().header("User-Agent", "PostmanRuntime/7.18.0")
                        .when()
                        .post(url).peek()
                        .then()
                        .extract()
                        .asString();
        JsonPath jp = new JsonPath(response);
        String code;
        try {
            code = jp.get("actionResult.code").toString();

        } catch (Exception e) {
        }
        return jp;
    }


    public static JsonPath postCommentGuest(String token
    ) throws Exception {

        String url = null;
        String payload = null;
        try {

            url = "https://www.spot.im/api/moderation/conversation/sp_Xloo0oKp_lia1/comment";
            org.testng.Reporter.log("Api: " + url, true);


            payload = "{\"content\":[{\"id\":\"bd69d104b2fea8df36477d1f1e9ccd45\"," +
                    "\"type\":\"text\"," +
                    "\"text\":\"hey\"}]," +
                    "\"stars\":0," +
                    "\"metadata\":{}}";

            org.testng.Reporter.log("Api Body to POST: " + payload, true);

            String response =
                    given()
                            .contentType("application/json")
                            .given().header("x-spotim-token", token)
                            .body(payload)
                            .when()
                            .post(url).peek()
                            .then()
                            .extract()
                            .asString();
            JsonPath jp = new JsonPath(response);
            org.testng.Reporter.log(response.toString(), true);
            String code = null;
            return jp;
        } catch (Exception e) {
            throw new Exception("create comment failed.");
        }
    }

    public static JsonPath postCommentMember(String token, String spotId
    ) throws Exception {

        String url = null;
        String payload = null;
        try {

            url = "https://www.spot.im/api/moderation/conversation/sp_Xloo0oKp_lia1/comment";
            org.testng.Reporter.log("Api: " + url, true);


            payload = "{\"content\":[{\"id\":\"bd69d104b2fea8df36477d1f1e9ccd45\"," +
                    "\"type\":\"text\"," +
                    "\"text\":\"hey\"}]," +
                    "\"stars\":0," +
                    "\"metadata\":{}}";

            org.testng.Reporter.log("Api Body to POST: " + payload, true);

            String response =
                    given()
                            .contentType("application/json")
                            .given().header("x-spotim-token", token)
                            .given().header("x-spotim-spotid", spotId)
                            .body(payload)
                            .when()
                            .post(url).peek()
                            .then()
                            .extract()
                            .asString();
            JsonPath jp = new JsonPath(response);
            org.testng.Reporter.log(response.toString(), true);
            String code = null;
            return jp;
        } catch (Exception e) {
            throw new Exception("create comment failed.");
        }
    }

    public static JsonPath getConversationFirstTestApi(String spotid, String contentLanguage,
                                                       String Authorization
    ) throws Exception {

        String url = null;
        try {
            url = "https://www.spot.im/api/moderation/conversation/sp_Xloo0oKp_lia1/comment";

            org.testng.Reporter.log("<p><strong><u>Complete token:", true);

            String response =
                    given()
                            .contentType("application/json")
                            .given().header("Content-Language", contentLanguage)
                            .given().header("Authorization", Authorization)
                            .when()
                            .get(url).peek()
                            .then().assertThat().statusCode(200)
                            .extract()
                            .asString();
            JsonPath jp = new JsonPath(response);
            String code;
            try {
                code = jp.get("actionResult.code").toString();

            } catch (Exception e) {

            }
            return jp;
        } catch (Exception e) {
            org.testng.Reporter.log("Found 204", true);
            throw new SkipException("Found '204'");
        }
    }


}

