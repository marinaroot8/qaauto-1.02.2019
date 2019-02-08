import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BedCodeExample {
    public static void main(String[] args)
 /*  HOMEWORK 1
  {
        System.out.println("Hello World");
        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("tatata");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }*/ {
        System.out.println("Hello World");
        System.setProperty("webdriver.chrome.driver", "/Users/marina/Downloads/chromedriver");
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.google.com");

        String searchTerm = "Selenium";

        WebElement searchField = driver2.findElement(By.name("q"));
        WebElement searchField1 = driver2.findElement(By.xpath("//input[@name='q']"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver2.findElements(By.xpath("//div[@class='srg']/div"));
        System.out.println("Search results count: " + searchResultElements.size());


        // HOMEWORK 2 at school
        // for each element iv searchResultElements print text
        // for (WebElement searchResultElement : searchResultElements) {
        //  String searchResultElementText = searchResultElement.getText();
        //  System.out.println(searchResultElementText());
        //  if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase()))
        //  System.out.println("searchTerm found");
        //   }else {
        //       System.out.println("searchTerm not found");
        //
        //    }
        //}


        // HOMEWORK 3 at home

        System.out.println("Content: ");
        for (WebElement w : searchResultElements)
        {
            System.out.println(w.getText());
            if (w.getText().contains("Selenium"))
            {
                System.out.println("searchTerm found: ");
            } else {
                System.out.println("searchTerm not found: ");
            }

        }


    }
}