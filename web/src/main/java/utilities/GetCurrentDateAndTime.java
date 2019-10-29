package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;


public class GetCurrentDateAndTime {
    public static final Logger log = Logger.getLogger(String.valueOf(GetCurrentDateAndTime.class));

    /**
     * @return current date and time
     * format can be any "MM/dd/yy HH:m" combination
     */
    public static String getDateAndTimeNoFormatGmt() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        return sdf.format(calendar.getTime());
    }

    public static String getDateAndTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
//        Reporter.log("Test time: " + date, true);
        return dateFormat.format(date);
    }

    public static String addDaysToDate(String format, int numOfDays) throws ParseException {
        String dt = getDateAndTime(format);  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, numOfDays);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        return dt;
    }

    public static String convertDateFormat(String date, String oldFormat, String newFormat) throws ParseException {
        DateFormat fromFormat = new SimpleDateFormat(oldFormat);
        fromFormat.setLenient(false);
        DateFormat toFormat = new SimpleDateFormat(newFormat);
        toFormat.setLenient(false);
        Date newDate = fromFormat.parse(date);
        return toFormat.format(newDate);
    }

    public static String increaseByDays(String date, String format, int increaseBy) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, increaseBy);  // number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date
        return date;
    }

    public static String increaseByMonths(String date, String format, int increaseBy) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.MONTH, increaseBy);  // number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date
        return date;
    }

    public static String increaseByYears(String date, String format, int increaseBy) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.YEAR, increaseBy);  // number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date
        return date;
    }

    public static String getServerTime(RemoteWebDriver driver) throws ParseException {
        driver.get("https://time.is/");
        String serverDate = driver.findElement(By.xpath("//div[@id='dd']")).getText();
        return serverDate;
    }
}
