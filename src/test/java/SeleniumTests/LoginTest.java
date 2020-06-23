package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    @Test
    public void credencialesIncorrectas_MensajeUsuarioIvalido(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        String usuarioIncorrecto = "fakeUser";
        String passwordIncorrecto= "fakePass";
        String mensajeEsperado = "Your username is invalid!";

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys(usuarioIncorrecto);
        driver.findElement(By.id("password")).sendKeys(passwordIncorrecto);

        driver.findElement(By.cssSelector("#login > button")).click();

        String mensaje = driver.findElement(By.id("flash")).getText();

        assertTrue(driver.getCurrentUrl().endsWith("login"));

        assertTrue(mensaje.startsWith(mensajeEsperado));

        driver.close();

    }
}
