package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZonaSegura {
    WebDriver driver;

    By mensaje = By.id("flash");

    public ZonaSegura(WebDriver driver) {
        this.driver = driver;
    }

    public String getMensaje(){
        return driver.findElement(mensaje).getText();
    }
}
