package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TheInternet.DynamicControlPage;
import pages.TheInternet.LoginPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlTest extends BaseTest {
    DynamicControlPage dynamicControlPage;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        dynamicControlPage = new DynamicControlPage(driver);
        dynamicControlPage.navigateTo();
    }

    @Test
    public void checkBoxApareceYDesaparece() {
        assertTrue(dynamicControlPage.isCheckBoxPresent(), "Al inciar debería mostrarse el checkbox");

        dynamicControlPage.clickButton();


        assertFalse(dynamicControlPage.isCheckBoxPresent(), "Al hacer click en el botón, el checkbox debería desaparecer");

    }
}
