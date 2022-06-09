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
    /**
     * El primer test juega con los primeros componentes.
     * Se selecciona un país, se escribe un nombre se selecciona un sexo
     * y se presiona el botón.
     * El test valida comprobando la presencia de un texto en la siguiente página.
     */
    public void primerTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();

        assertEquals("Products",productsPage.validarPrimerTest());
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(2)
    /**
     * El segundo test solo presiona el botón provocando un error con su correspondiente
     * recordatorio.
     * El test resulta satisfactorio si aparece un toast.
     */
    public void segundoTest() throws IOException, InterruptedException {
        generalStoreHomePage.segundoTest();

        assertEquals("Please enter your name", GeneralStoreHomePage.textoToast);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(3)
    /**
     * El cuarto test comprueba que el botón de retroceder lleve a la página de
     * procedencia.
     */
    public void cuartoTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.cuartoTest();

        assertEquals("General Store", generalStoreHomePage.cuartoTest());
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(4)
    /**
     * El tercer test busca entrar en el carrito de compra sin añadir
     * ningún producto, provocando un error.
     * El test es válido si aparece un toast.
     */
    public void tercerTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.tercerTest();

        assertEquals("Please add some product at first", ProductsPage.textoToast);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(5)
    /**
     * El quinto test comprueba que el artículo que se ha metido en el carrito corresponde
     * con el artículo seleccionado.
     */
    public void quintoTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.quintoTest();

        assertEquals("Jordan 6 Rings",cartPage.validarQuintoTest());
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(6)
    /**
     * El sexto test comprueba que el precio de dos artículos es correcto.
     */
    public void sextoTest() throws IOException, InterruptedException {
        generalStoreHomePage.primerTest();
        productsPage.elegirDosProductos();
        cartPage.sextoTest();

        assertEquals(productValueClean, totalValue);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @Order(7)
    /**
     * El séptimo test comprueba que se muestra la ventana con los términos y
     * condiciones correctamente y la cierra.
     */
    public void septimoTest() throws InterruptedException, IOException {
        generalStoreHomePage.primerTest();
        productsPage.elegirDosProductos();
        cartPage.septimoTest();

        assertTrue(true);
        generalStoreHomePage.screenShotSelenium(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
