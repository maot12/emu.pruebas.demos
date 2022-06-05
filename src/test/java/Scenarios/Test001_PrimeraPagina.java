package test.java.Scenarios;

import es.getronics.oca.utilidades.UtilSelenium;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import test.java.Pages.CartPage;
import test.java.Pages.GeneralStoreHomePage;
import test.java.Pages.ProductsPage;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test001_PrimeraPagina {

    static AndroidDriver driver;
    private UtilSelenium utilSelenium;

    static GeneralStoreHomePage home = new GeneralStoreHomePage(null);
    static ProductsPage productsPage = new ProductsPage(null);
    static CartPage cartPage = new CartPage(null);

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = home.capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        home = new GeneralStoreHomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    @Order(1)
    public void primerTest(){
        home.primerTest();
        assertEquals("Products",productsPage.validarPrimerTest());
    }

    @Test
    @Order(2)
    public void segundoTest(){
        home.segundoTest();
        assertEquals("Please enter your name", GeneralStoreHomePage.textoToast);
    }

    @Test
    @Order(3)
    public void tercerTest(){
        home.primerTest();
        productsPage.tercerTest();
        assertEquals("Please add some product at first", productsPage.textoToast);
    }

    @Test
    @Order(4)
    public void cuartoTest(){
        home.primerTest();
        productsPage.cuartoTest();
        assertEquals("General Store", home.cuartoTest());
    }

    @Test
    @Order(5)
    public void quintoTest(){
        home.primerTest();
        productsPage.quintoTest();
        assertEquals("Jordan 6 Rings",cartPage.validarQuintoTest());
    }
}
