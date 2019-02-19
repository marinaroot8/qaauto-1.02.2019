import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMeyhod(){
        driver.quit();
    }

    @Test
    public void negativeLoginTest() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login("dfd@ms.ru", "");
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");
    }

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                { "sizag@webmails.top", "111111Qa" },
                { "Sizag@webmails.top", "111111Qa" },
                { " sizag@webmails.top ", "111111Qa" }
        };
    }
    @Test(dataProvider = "validData")
    public void successfulLoginTestHome(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login(userEmail, userPassword);
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page didn't load after Login");
    }

    @Test
    public void negativeLoginWrongPass() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login("sizg@webmails.top", "111111Qa");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isPageLoaded(),
                "Sign In Page is not loaded");
    }

    @Test
    public void negativeIsTitleShown() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login("dfd@ms.ru", "yftf");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isPageLoaded(),
                "Sign In Page is not loaded");

        Assert.assertTrue(signInPage.isTitleShown());
    }

    @Test
    public void negativeIsErrorMsgShown() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login("sizag@webmails.top", "yftf");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isPageLoaded(),
                "Sign In Page is not loaded");
        Assert.assertEquals(signInPage.getPasswordValidationMessageText(), "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message password");
    }
}
