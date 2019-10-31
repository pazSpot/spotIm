package utilities;

import java.util.Random;
import java.util.stream.Collectors;

public class DataProvider extends BasePage {


    public String random() {
        int length = 3;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String str = new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
        return str;
    }

    public DataProvider() throws Exception {
    }


    @org.testng.annotations.DataProvider(name = "data")
    public Object[][] data() throws Exception {
        return new Object[][]{
                {"FirstName_" + this.random(), "LastName_" + this.random(), "050555555555", "email_" + this.random() + "@gmail.com", "Aa123456789"},
                {"FirstName_" + this.random(), "LastName_" + this.random(), "050555555555", "email_" + this.random() + "@gmail.com", "Aa123456789"},
        };

    }

    @org.testng.annotations.DataProvider(name = "users")
    public Object[][] users() throws Exception {
        return new Object[][]{
                {"email_RDF7SPNq@gmail.com", "Aa123456789"},
                {"email_x3r1ixN0@gmail.com", "Aa123456789"},
        };
    }


    @org.testng.annotations.DataProvider(name = "conversation")
    public Object[][] conversation() throws Exception {
        return new Object[][]{
                {"Guest", "my name is : spoti !", "Hello World !!!", "my name is : sp"},
                {"Guest", "my name is : QA !", "Hello World !!!", "my name is : QA"},
                {"Guest", "my name is : Automation !", "Hello World !!!", "my name is : Au"},

        };
    }

    @org.testng.annotations.DataProvider(name = "commentAsUser")
    public Object[][] commentAsUser() throws Exception {
        return new Object[][]{
                {"User", "automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", " Hello World !!!"},
                {"User", "automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", " Hello Spot IM "},
        };
    }

    @org.testng.annotations.DataProvider(name = "conversationLogin")
    public Object[][] conversationLogin() throws Exception {
        return new Object[][]{
                {"automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl"},
                {"automation_gas@spot.im", "Abc123456789!", "Automation_OPV"},
                {"automation_hGr@spot.im", "Abc123456789!", "Automation_faV"},


        };
    }

    @org.testng.annotations.DataProvider(name = "userOptions")
    public Object[][] userOptions() throws Exception {
        return new Object[][]{
                {"automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", "Profile", "My Activity"},
                {"automation_gas@spot.im", "Abc123456789!", "Automation_OPV", "Settings", "My Settings"},
                {"automation_hGr@spot.im", "Abc123456789!", "Automation_faV", "Privacy", "My Privacy"},
//                {"automation_hGr@spot.im", "Abc123456789!", "Automation_faV","Log Out",""},
        };
    }

    @org.testng.annotations.DataProvider(name = "conversationSignUp")
    public Object[][] conversationSignUp() throws Exception {
        return new Object[][]{
                {"Automation_" + random(), "automation_" + random() + "@spot.im", "Abc123456789!"},
                {"Automation_" + random(), "automation_" + random() + "@spot.im", "Abc123456789!"},
                {"Automation_" + random(), "automation_" + random() + "@spot.im", "Abc123456789!"},
                {"Automation_" + random(), "automation_" + random() + "@spot.im", "Abc123456789!"},
        };
    }

    @org.testng.annotations.DataProvider(name = "forgotPassword")
    public Object[][] forgotPassword() throws Exception {
        return new Object[][]{
                {"Automation_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Automation_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Automation_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Automation_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Automation_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
        };
    }

    @org.testng.annotations.DataProvider(name = "fullStarRating")
    public Object[][] fullStarRating() throws Exception {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
        };
    }

    @org.testng.annotations.DataProvider(name = "sortList")
    public Object[][] sortList() throws Exception {
        return new Object[][]{
                {"Best"},
                {"Newest"},
                {"Oldest"},
        };
    }

}

