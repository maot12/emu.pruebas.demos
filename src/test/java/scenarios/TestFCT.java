package test.java.scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import test.java.pages.CartPage;
import test.java.pages.GeneralStoreHomePage;
import test.java.pages.ProductsPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.java.pages.CartPage.productValueClean;
import static test.java.pages.CartPage.totalValue;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFCT {

    private AndroidDriver driver;

    private GeneralStoreHomePage generalStoreHomePage = new GeneralStoreHomePage(null);
    private ProductsPage productsPage = new ProductsPage(null);
    private CartPage cartPage = new CartPage(null);

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = generalStoreHomePage.capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        generalStoreHomePage = new GeneralStoreHomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    @Order(1)
    public void primerTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();

        assertEquals("Products",productsPage.validarPrimerTest());
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(2)
    public void segundoTest() throws IOException, InterruptedException {
        generalStoreHomePage.segundoTest();

        assertEquals("Please enter your name", GeneralStoreHomePage.textoToast);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(3)
    public void tercerTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.tercerTest();

        assertEquals("Please add some product at first", ProductsPage.textoToast);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(4)
    public void cuartoTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.cuartoTest();

        assertEquals("General Store", generalStoreHomePage.cuartoTest());
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(5)
    public void quintoTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.quintoTest();

        assertEquals("Jordan 6 Rings",cartPage.validarQuintoTest());
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(6)
    public void sextoTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.elegirDosProductos();
        cartPage.sextoTest();

        assertEquals(productValueClean, totalValue);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(7)
    public void septimoTest() throws InterruptedException, IOException {
        generalStoreHomePage.primerTest();
        productsPage.elegirDosProductos();
        cartPage.septimoTest();

        assertTrue(true);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
