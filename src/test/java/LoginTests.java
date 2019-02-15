import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.JButton;

import java.awt.*;

public class LoginTests {
        @Test
        public void negativeLoginTest() {
                System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.linkedin.com/");

                String titleUnlogin = driver.getTitle();
                WebElement singInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));
                String currentUrlUnlogin = driver.getCurrentUrl();


                Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");
//
//                // HOMEWORK 4 at home
//
//         //1       Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/");
//                driver.findElement(By.xpath("//input[@class='login submit-button']"));
//                WebElement eMail = driver.findElement(By.name("session_key"));
//                eMail.sendKeys("a@b.c");
//                WebElement password = driver.findElement(By.name("session_password"));
//                password.sendKeys("");
//                JButton b1 = new JButton("Sign in");
//                b1.doClick();
//                Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");
//
//                // HOMEWORK 4 at class
//
//               //1 example
//                // Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "URL is wrong");
//               //2 example of 1
//
//                String expectedURL = "https://www.linkedin.com/";
//                Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login page URL is wrong");
//
//                WebElement signInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));
//                Assert.assertEquals(signInButton.isDisplayed(), true, "SignIn button is not displayed");
//          //or      Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed");
//
//                WebElement userEmailField = driver.findElement(By.name("session_key"));
//                userEmailField.sendKeys("a@b.c");
//                WebElement userPasswordField = driver.findElement(By.name("session_password"));
//                userPasswordField.sendKeys("");
//                signInButton.click();
//
//                Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed");
//                Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login page URL is wrong");
//                Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");
//
//            //CLASSWORK 5
//            // Successful Login

        }
            //    @Test
                public void successfulLoginTest() {

                //MINE
                        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
                        WebDriver driver = new ChromeDriver();
                        driver.get("https://www.linkedin.com/");

                        String expectedURL = "https://www.linkedin.com/feed/";
                        WebElement signInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));

                        WebElement userEmailField = driver.findElement(By.name("session_key"));
                        userEmailField.sendKeys("sizag@webmails.top");
                        WebElement userPasswordField = driver.findElement(By.name("session_password"));
                        userPasswordField.sendKeys("111111Qa");

                        signInButton.click();
                        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Successful Login page URL is wrong");

                        WebElement profileNavMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
                        Assert.assertTrue(profileNavMenuItem.isDisplayed(), "Login failed. Home page didn't load after Login");



                }
}
