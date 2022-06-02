package test.java.Scenarios;

import io.appium.java_client.android.AndroidDriver;

import org.junit.jupiter.api.*;
import test.java.Pages.GeneralStoreHomePage;

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
public class Test001 {

    static AndroidDriver driver;

    static GeneralStoreHomePage home = new GeneralStoreHomePage(null);

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = home.capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        home = new GeneralStoreHomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    @Order(1)
    public void prueba(){
        home.primerTest();
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void pruebaToast(){
        home.segundoTest();
        assertEquals("Please enter your name", GeneralStoreHomePage.textoToast);
    }


}
