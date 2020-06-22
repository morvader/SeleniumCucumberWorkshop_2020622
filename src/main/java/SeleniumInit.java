import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumInit {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");



        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu","--ignore-certificate-errors");

        WebDriver driver = new ChromeDriver(options);

        //WebDriver driver = new FirefoxDriver();

        //driver.manage().window().setSize(new Dimension(300,300));

        driver.get("https://duckduckgo.com/");

        final WebElement inputText = driver.findElement(By.id("search_form_input_homepage"));

        inputText.sendKeys("Selenium");

        inputText.sendKeys(Keys.ENTER);

        driver.close();

    }
}
