import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void negativeLoginTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login("dfd@ms.ru", "");
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");


    }

    @Test
    public void successfulLoginTestHome() {

        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded");

        landingPage.login("sizag@webmails.top", "111111Qa");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page didn't load after Login");
    }

    @Test
    public void negativeLoginWrongPass() {

        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

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
        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

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
        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

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
