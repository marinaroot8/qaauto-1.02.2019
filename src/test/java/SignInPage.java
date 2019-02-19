import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver driver;
    private WebElement errorForUsername;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        initElements();
}
    private void initElements() {
        errorForUsername = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }

    public boolean isPageLoaded() {
        return errorForUsername.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME");
    }

    public boolean isTitleShown() {
        return errorForUsername.isDisplayed()
        && driver.getTitle().equals("Sign In to LinkedIn");
    }
}
