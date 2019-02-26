package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;
import test.BaseTest;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest() {
        String userEmail = "wowaliwa@gmail.com";
        String userPassword = "wowaliwa8542";
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.loginGeneral(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page didn't load after Login");

        SearchPage searchPage = homePage.search (searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page didn't load after Login");
    }
}
