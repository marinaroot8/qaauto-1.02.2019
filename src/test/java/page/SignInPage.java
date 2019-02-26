package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@id='error-for-username']")
    private WebElement errorForUsername;

    @FindBy(xpath = "//*[@id='error-for-password']")
    private WebElement passwordValidationMessage;

    @FindBy (xpath = "//div[@id='error-for-username']")
    private WebElement emailValidationMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
}

// void method doesn't return anything


    public boolean isPageLoaded() {
        return (errorForUsername.isDisplayed()
                || passwordValidationMessage.isDisplayed())
        && driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME");
    }

    //public boolean isTitleShown() {
    //     return errorForUsername.isDisplayed()
    //      && driver.getTitle().equals("Sign In to LinkedIn");
    //  }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }
    public String getEmailValidationMessageText() {
        return emailValidationMessage.getText();
    }
    }



