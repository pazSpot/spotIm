package spotTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.conversation.StarReviewsPage;
import utilities.BasePage;
import utilities.DataProvider;
import utilities.UiUtilities;

import java.util.concurrent.TimeUnit;

public class starReviews extends BasePage {

    @Test(alwaysRun = true, dataProvider = "fullStarRating", dataProviderClass = DataProvider.class)
    public void clickOnTheStarReviews(int fullStarRating) throws Exception {

        StarReviewsPage starReviewsPage = new StarReviewsPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("starReviews");
        starReviewsPage.rateFromHeader(fullStarRating);

        Assert.assertEquals(starReviewsPage.getFullStarRating(), fullStarRating, "Error: full star rating doesn't match to DP");


    }

    @Test(alwaysRun = true, dataProvider = "sortList", dataProviderClass = DataProvider.class)
    public void clickOnSortBy(String sortName) throws Exception {
        StarReviewsPage starReviewsPage = new StarReviewsPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        UiUtilities uiUtilities = new UiUtilities(driver);

        uiUtilities.openBrandHomePage("starReviews");
        starReviewsPage.clickOnSortBy();
        starReviewsPage.chooseSortByFromList(sortName);

        Assert.assertEquals(starReviewsPage.getSortName(), sortName, "Error: sort name doesn't match to DP");
    }
}

