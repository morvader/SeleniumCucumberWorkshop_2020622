package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com/login";

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void credencialesIncorrectas_MensajeUsuarioIvalido() {

        String usuarioIncorrecto = "fakeUser";
        String passwordIncorrecto = "fakePass";
        String mensajeEsperado = "Your username is invalid!";

        driver.findElement(By.id("username")).sendKeys(usuarioIncorrecto);
        driver.findElement(By.id("password")).sendKeys(passwordIncorrecto);

        driver.findElement(By.cssSelector("#login > button")).click();

        String mensaje = driver.findElement(By.id("flash")).getText();

        assertTrue(driver.getCurrentUrl().endsWith("login"));

        assertTrue(mensaje.startsWith(mensajeEsperado));

    }

    @Test
    public void credencialesCorrectas_AccesoZonaSegura() {

        String usuarioCorrecto = "tomsmith";
        String passwordCorrecto = "SuperSecretPassword!";
        String mensajeEsperado = "You logged into a secure area!";


        driver.findElement(By.id("username")).sendKeys(usuarioCorrecto);
        driver.findElement(By.id("password")).sendKeys(passwordCorrecto);

        driver.findElement(By.cssSelector("#login > button")).click();

        String mensaje = driver.findElement(By.id("flash")).getText();

        assertTrue(driver.getCurrentUrl().endsWith("secure"));

        assertTrue(mensaje.startsWith(mensajeEsperado));

    }
}
