package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TheInternet.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        loginPage.navigateTo();
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

        String mensaje = loginPage
                .loginIncorrecto(usuarioIncorrecto,passwordIncorrecto)
                .getMensaje();

        assertTrue(driver.getCurrentUrl().endsWith("login"));

        assertTrue(mensaje.startsWith(mensajeEsperado));

    }

    @Test
    public void credencialesCorrectas_AccesoZonaSegura() {

        String usuarioCorrecto = "tomsmith";
        String passwordCorrecto = "SuperSecretPassword!";
        String mensajeEsperado = "You logged into a secure area!";

        String mensaje = loginPage
                .loginCorrecto(usuarioCorrecto,passwordCorrecto)
                .getMensaje();

        assertTrue(driver.getCurrentUrl().endsWith("secure"));

        assertTrue(mensaje.startsWith(mensajeEsperado));

    }
}
