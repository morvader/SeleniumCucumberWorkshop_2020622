package pages.TheInternet;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlPage {
    String URL = "https://the-internet.herokuapp.com/dynamic_controls";

    private WebDriver driver;

    By btn = By.cssSelector("#checkbox-example button");
    By checkbox = By.cssSelector("#checkbox");
    By mensaje = By.cssSelector("#message");

    public DynamicControlPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicControlPage navigateTo(){
        driver.get(this.URL);
        return this;
    }
    public void clickButton() {
        driver.findElement(btn).click();
    }

    public String getMensaje() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje));

        return driver.findElement(mensaje).getText();
    }

    public void waitCheckBoxInvisible() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
    }

    public boolean isCheckBoxPresent() {
        try {
            driver.findElement(checkbox);
            return true;
        } catch (NoSuchElementException noElement) {
            return false;
        }
    }
}
