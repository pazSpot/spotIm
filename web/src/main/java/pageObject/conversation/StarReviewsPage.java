package pageObject.conversation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

import java.util.List;

public class StarReviewsPage {

    protected final static By starRatingHeader = By.className("spcv_stars-rating-summary");
    protected final static By starRating = By.className("spcv_icon");
    protected final static By starRatingEditing = By.className("spcv_editing");
    protected final static By starRatingFull = By.className("spcv_full");
    protected final static By commentEditor = By.className("spcv_editor");


    @FindBy(xpath = "//*[@class=\"spcv_sort-by\"]/span")
    @CacheLookup
    WebElement sortByName;

    @FindBy(xpath = "//*[@data-spot-im-class=\"message-timestamp\"]")
    @CacheLookup
    WebElement commentsTimeStamp;

    @FindBy(xpath = "class=\"spcv_droplist\"")
    @CacheLookup
    WebElement sortByList;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]/input")
    @CacheLookup
    WebElement nickName;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
    @CacheLookup
    WebElement addComment;

    @FindBy(xpath = "class=\"spcv_stars-rating spcv_rich-editor\"")
    @CacheLookup
    WebElement starRatingInComment;

    WebDriver driver;

    public StarReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSortBy() {
        Log.info("Clicking on SortBy");
        try {
            sortByName.click();
        } catch (Exception e) {
            Log.info("Error clicking on SortBy");
        }
    }

    public void chooseSortByFromList(String sortByOption) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Log.info("Choosing sort by");
        try {
            List<WebElement> sortBy = driver.findElements(By.xpath("//*[@class=\"spcv_droplist\"]/li"));
            for (int x = 0; x < sortBy.size(); x++) {
                if (sortBy.get(x).getText().contains(sortByOption)) {
                    Log.info("Clicking on " + sortBy.get(x).getText() + " from sort by list");
                    sortBy.get(x).click();
                    wait.until(ExpectedConditions.invisibilityOf(sortByList));
                    break;
                }
            }
        } catch (Exception e) {
            Log.info("Error choosing destination");
        }
    }

    public int getFullStarRating() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        int fullStarReview = 0;
        Log.info("Getting Star rating");
        try {
            wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@data-spot-im-class=\"rich-editor-wrapper\"]"), "data-expanded", "true"));
            fullStarReview = driver.findElement(commentEditor).findElement(starRatingEditing).findElements(starRatingFull).size();
            Log.info("The Star rating is: " + fullStarReview);
        } catch (Exception e) {
            Log.info("Error getting Star rating");
        }
        return fullStarReview;
    }

    public String getSortName() {
        String fullSortName = null;
        Log.info("Getting sort name");
        try {
            fullSortName = sortByName.getText();
            Log.info("The sort name is: " + fullSortName);
        } catch (Exception e) {
            Log.info("Error getting sort name");
        }
        return fullSortName;
    }

    public void chooseRating(By ratingRoot, int stars) {
        WebElement rating = driver.findElement(ratingRoot);
        rating.findElement(starRatingEditing).findElements(starRating).get(stars - 1).click();
    }

    public void rateFromHeader(int stars) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(starRatingHeader));
        chooseRating(starRatingHeader, stars);
    }

}