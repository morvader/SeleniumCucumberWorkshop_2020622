package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userInput = By.id("username");
    By passInput = By.id("password");
    By loginBtn = By.cssSelector("#login > button");
    By mensaje = By.id("flash");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private void login(String user, String pass) {
        driver.findElement(userInput).sendKeys(user);
        driver.findElement(passInput).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public LoginPage loginIncorrecto (String user, String pass){
        login(user, pass);
        return this;
    }

    public ZonaSegura loginCorrecto (String user, String pass){
        login(user, pass);
        return new ZonaSegura(driver);
    }

    public String getMensaje(){
        return driver.findElement(mensaje).getText();
    }

}
