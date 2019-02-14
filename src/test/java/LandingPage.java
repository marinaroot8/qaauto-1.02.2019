import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage {

    WebDriver driver;

    WebElement signInButton;
    WebElement userEmailField;
    WebElement userPasswordField;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
        isPageLoaded();
    }

    public void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));
        userEmailField = driver.findElement(By.name("session_key"));
        userPasswordField = driver.findElement(By.name("session_password"));
    }


    public void login(String userEmail, String userPassword) {
        userEmailField.sendKeys("a@b.c");
        userPasswordField.sendKeys("");
        signInButton.click();
    }

    public void isPageLoaded() {
        Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong");
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");
    }
}
