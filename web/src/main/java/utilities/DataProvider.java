package utilities;

import java.util.Random;
import java.util.stream.Collectors;

public class DataProvider extends BasePage {


    public String random() {
        int length = 8;
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
                {"FirstName_" + this.random(), "LastName_" + this.random(), "050555555555", "email_" + this.random() + "@gmail.com", "Aa123456789"},
                {"FirstName_" + this.random(), "LastName_" + this.random(), "050555555555", "email_" + this.random() + "@gmail.com", "Aa123456789"},
                {"FirstName_" + this.random(), "LastName_" + this.random(), "050555555555", "email_" + this.random() + "@gmail.com", "Aa123456789"},

        };

    }

    @org.testng.annotations.DataProvider(name = "users")
    public Object[][] users() throws Exception {
        return new Object[][]{
                {"email_RDF7SPNq@gmail.com", "Aa123456789"},
                {"email_x3r1ixN0@gmail.com", "Aa123456789"},
                {"email_VYhQsoQr@gmail.com", "Aa123456789"},
                {"email_dLdg8in6@gmail.com", "Aa123456789"},
                {"email_iOEWqiCq@gmail.com", "Aa123456789"},
        };
    }


    @org.testng.annotations.DataProvider(name = "conversation")
    public Object[][] conversation() throws Exception {
        return new Object[][]{
                {"my name is : spoti !", " Hello World !!!", "my name is : sp"},
                {"my name is : QA !", " Hello World !!!", "my name is : QA"},
                {"my name is : Automation !", " Hello World !!!", "my name is : Au"},

        };
    }

}

