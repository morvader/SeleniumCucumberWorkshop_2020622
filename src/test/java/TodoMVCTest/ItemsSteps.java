package TodoMVCTest;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TodoMVC.MainReactPage;

import java.util.ArrayList;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ItemsSteps {
    WebDriver driver;
    MainReactPage mainReactPage;
    ArrayList<String> elementosCompletados;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        elementosCompletados = new ArrayList<String>();
        driver = new ChromeDriver();
        mainReactPage = new MainReactPage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("^accedo a la lista$")
    public void accedoALaLista() {
        mainReactPage.navigateTo();
    }

    @Then("^la lista de elementos esta vacía$")
    public void laListaDeElementosEstaVacía() {
        assertEquals(0, mainReactPage.getNumberOfElements(), "La lista no está vacía");
    }

    @When("^añado el elemento \"([^\"]*)\" a lista$")
    public void añadoElElementoALista(String newItem) throws Throwable {
        mainReactPage.addNewTodo(newItem);
    }

    @Then("^la lista tiene (\\d+) elemento$")
    public void laListaTieneElemento(int nElementosEsperados) {
        final int numberOfElementsActuales = mainReactPage.getNumberOfElements();

        assertEquals(numberOfElementsActuales, nElementosEsperados);
    }

    @And("^la lista contiene el elemento \"([^\"]*)\"$")
    public void laListaContieneElElemento(String elementoEsperado) throws Throwable {
        assertTrue(mainReactPage.getElementNames().contains(elementoEsperado));

    }

    @When("^marco el elemento (\\d+) como completado$")
    public void marcoElElementoComoCompletado(int posicionCompletado) {
        String nombreElemento = mainReactPage.getListElementName(posicionCompletado);
        elementosCompletados.add(nombreElemento);

        mainReactPage.completeElement(posicionCompletado);
    }

    @Then("^el elemento (\\d+) queda marcado como completado$")
    public void elElementoQuedaMarcadoComoCompletado(int arg0) {
    }

    @And("^aparece en la lista de completados$")
    public void apareceEnLaListaDeCompletados() {
        mainReactPage.clickCompletedBtn();


    }

    @When("^elimino el elemento (\\d+)$")
    public void eliminoElElemento(int arg0) {
    }

    @Then("^el elemento \"([^\"]*)\" deja de aparecer en las listas$")
    public void elElementoDejaDeAparecerEnLasListas(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^añado (\\d+) elementos$")
    public void añadoElementos(int nelementosACrear) {
        for (int i = 0; i < nelementosACrear; i++) {
            mainReactPage.addNewTodo("Test " + i);
        }
    }
}
