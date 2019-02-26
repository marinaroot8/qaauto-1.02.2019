package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SignInPage;
import test.BaseTest;

public class LoginTests extends BaseTest {


    @DataProvider
    public Object[][] notValidDataLandingPage() {
        return new Object[][]{
                {"dfd@ms.ru", ""},
                {"", "111111Qa"},
                {"вуасук@ms.ru", ""},
                {"", "1"},
                {"*&^%$#@ms.ru", ""}
        };
    }
    @Test(dataProvider = "notValidDataLandingPage")
    public void negativeLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        landingPage.loginGeneral(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
    }
    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"wowaliwa@gmail.com", "wowaliwa8542"},
                {"Wowaliwa@gmail.com", "wowaliwa8542"},
                {" wowaliwa@gmail.com ", "wowaliwa8542"}
        };
    }
    @Test(dataProvider = "validData")
    public void successfulLoginTestHome(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.loginGeneral(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page didn't load after Login");
    }
    @DataProvider
    public Object[][] notValidDataSignInPage() {
        return new Object[][]{
                {"si@webmails.top", "111111Qa", "Hmm, we don't recognize that email. Please try again.", ""},
                {"sizag@webmails.top", "111111", "", "Hmm, that's not the right password. Please try again or request a new one."}
        };
    }
    @Test(dataProvider = "notValidDataSignInPage")
    public void negativeLoginWrongPass(String userEmail, String userPassword, String emailError, String passwordError) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        SignInPage signInPage = landingPage.loginGeneral(userEmail, userPassword);
        Assert.assertTrue(signInPage.isPageLoaded(), "Sign In Page is not loaded");
        Assert.assertEquals(signInPage.getEmailValidationMessageText(), emailError, "Hmm, we don't recognize that email. Please try again.");
        Assert.assertEquals(signInPage.getPasswordValidationMessageText(), passwordError, "Hmm, that's not the right password. Please try again or request a new one.");
    }
}
