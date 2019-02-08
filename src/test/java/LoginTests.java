import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
        @Test
        public void negativeLoginTest() {
                System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.linkedin.com/");
                Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");

        }


}
