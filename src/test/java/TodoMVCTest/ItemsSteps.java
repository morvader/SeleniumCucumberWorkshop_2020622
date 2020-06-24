package TodoMVCTest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItemsSteps {
    WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }

    @Given("^accedo a la lista$")
    public void accedoALaLista() {
    }

    @Then("^la lista de elementos esta vacía$")
    public void laListaDeElementosEstaVacía() {
    }
}
