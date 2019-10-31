package utilities;


import jdk.javadoc.doclet.Reporter;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Logger;


public class General {
    protected static final Logger log = Logger.getLogger(String.valueOf(General.class));
    public static SecureRandom random = new SecureRandom();

    /**
     * Create a random Number
     */
    public static int createRandNumber(int len, int max) throws Exception {
        int Number;
        final String AB = "1234567890";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        Number = Integer.parseInt(sb.toString());
        if (Number <= max) {
            return Number;
        } else {
            return max;
        }
    }


    public static String randomString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    public static String randomName() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    public static String randomSession() {
        return new BigInteger(130, random).toString(32);
    }

    public static String randString(int min, int max) {
        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }

    public static int randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String convertLowerToUpper(String value) {
        StringBuilder sb = new StringBuilder(value);
        for (int index = 0; index < sb.length(); index++) {
            char c = sb.charAt(index);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(index, Character.toUpperCase(c));
            } else {
                sb.setCharAt(index, Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * @param format like: 10d = That's for 1 digits precision. The number of zeros indicate the number of decimals.
     *               like: 100d = That's for 2 digits precision. The number of zeros indicate the number of decimals.
     *               like: 1000d = That's for 3 digits precision. The number of zeros indicate the number of decimals.
     * @return
     */
    public static double roundNumber(double format, double numberToRound) {
        double v = (double) Math.round(numberToRound * format) / format;
        return v;
    }


}
