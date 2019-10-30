package pageObject.conversation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Log;

import java.util.List;

public class StarReviewsPage {

    protected final static By starRatingHeader = By.className("spcv_stars-rating-summary");
    protected final static By starRating = By.className("spcv_icon");
    protected final static By starRatingEditing = By.className("spcv_editing");
    protected final static By starRatingFull = By.className("spcv_full");
    protected final static By commentEditor = By.className("spcv_editor");



    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]/input")
    @CacheLookup
    WebElement nickName;

    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
    @CacheLookup
    WebElement addComment;

    @FindBy(xpath = "//*[@class=\"spcv_sort-by\"]/span")
    @CacheLookup
    WebElement sortByName;

    @FindBy(xpath = "class=\"spcv_droplist\"")
    @CacheLookup
    WebElement sortByList;

    @FindBy(xpath = "class=\"spcv_stars-rating spcv_rich-editor\"")
    @CacheLookup
    WebElement starRatingInComment;

    WebDriver driver;

    public StarReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnNickName() {
        System.out.println("Clicking on Nick Name");
        try {
            nickName.click();
        } catch (Exception e) {
            System.out.println("Error clicking on nick name");
        }
    }


    public void enterNickName(String myNickName) {
        System.out.println("Entering nick name");
        try {
            nickName.sendKeys(myNickName);
        } catch (Exception e) {
            System.out.println("Error Entering first name");
        }
    }


    public void clickOnSortBy() {
        System.out.println("Clicking on SortBy");
        try {
            sortByName.click();
        } catch (Exception e) {
            System.out.println("Error clicking on SortBy");
        }
    }


    public void enterComment(String myComment) {
        System.out.println("Entering Comment");
        try {
            addComment.sendKeys(myComment);
        } catch (Exception e) {
            System.out.println("Error Entering Comment");
        }
    }


    public String getSortName() {
        String fullSortName = null;
        System.out.println("Getting sort name");
        try {
            fullSortName = sortByName.getText();
            System.out.println("The sort name is: " + fullSortName);
        } catch (Exception e) {
            System.out.println("Error getting sort name");
        }
        return fullSortName;
    }


    public int getFullStarRating() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        int fullStarReview = 0;
        System.out.println("Getting Star rating");
        try {
            wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@data-spot-im-class=\"rich-editor-wrapper\"]"),"data-expanded","true"));
            fullStarReview = driver.findElement(commentEditor).findElement(starRatingEditing).findElements(starRatingFull).size();
            System.out.println("The Star rating is: " + fullStarReview);
        } catch (Exception e) {
            System.out.println("Error getting Star rating");
        }
        return fullStarReview;
    }

    public String getComment() {
        String fullComment = null;
        System.out.println("Getting comment");
        try {
            fullComment = addComment.getText();
            System.out.println("The comment is: " + fullComment);
        } catch (Exception e) {
            System.out.println("Error getting the comment");
        }
        return fullComment;
    }


    public void chooseSortByFromList(String sortByOption) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        Log.info("Choosing sort by");
        try {
            List<WebElement> sortBy = driver.findElements(By.xpath("//*[@class=\"spcv_droplist\"]/li"));
            for (int x = 0; x < sortBy.size(); x++) {
                if (sortBy.get(x).getText().contains(sortByOption)) {
                    System.out.println("Clicking on " + sortBy.get(x).getText() + " from sort by list");
                    sortBy.get(x).click();
                    wait.until(ExpectedConditions.invisibilityOf(sortByList));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error choosing destination");
        }
    }

    public void chooseRating(By ratingRoot, int stars){
        WebElement rating = driver.findElement(ratingRoot);
        rating.findElement(starRatingEditing).findElements(starRating).get(stars-1).click();

    }

    public void rateFromHeader(int stars) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(starRatingHeader));
        chooseRating(starRatingHeader,stars);

    }

}