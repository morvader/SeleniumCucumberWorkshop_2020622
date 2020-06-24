package TodoMVCTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TodoMVC.MainReactPage;

import static org.testng.Assert.assertEquals;

public class ItemsSteps {
    WebDriver driver;
    MainReactPage mainReactPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        driver = new ChromeDriver();
        mainReactPage = new MainReactPage(driver);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Given("^accedo a la lista$")
    public void accedoALaLista() {
        mainReactPage.navigateTo();
    }

    @Then("^la lista de elementos esta vacía$")
    public void laListaDeElementosEstaVacía() {
        assertEquals(0,mainReactPage.getNumberOfElements(), "La lista no está vacía");
    }
}
