import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver driver;
    private WebElement errorForUsername;
    private WebElement passwordValidationMessage;
    private WebElement emailValidationMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        initElements();
}

// void method doesn't return anything

    private void initElements() {
        errorForUsername = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        passwordValidationMessage = driver.findElement(By.xpath("//*[@id='error-for-password']"));
        emailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }
    public boolean isPageLoaded() {
        return (errorForUsername.isDisplayed()
                || passwordValidationMessage.isDisplayed())
        && driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME");
    }

    public boolean isTitleShown() {
        return errorForUsername.isDisplayed()
        && driver.getTitle().equals("Sign In to LinkedIn");
    }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }
    public String getEmailValidationMessageText() {
        return emailValidationMessage.getText();
    }
    }



