import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInit {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://duckduckgo.com/");

        final WebElement inputText = driver.findElement(By.id("search_form_input_homepage"));

        inputText.sendKeys("Selenium");

        inputText.sendKeys(Keys.ENTER);

        driver.close();

    }
}
