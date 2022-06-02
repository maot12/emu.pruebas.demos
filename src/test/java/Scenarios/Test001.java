package Scenarios;

import Pages.GeneralStoreHomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class Test001 {

    static AndroidDriver driver;

    static GeneralStoreHomePage home = new GeneralStoreHomePage(null);

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        driver = home.capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        home = new GeneralStoreHomePage(driver);
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

    @Test
    public void prueba(){
        home.rellenarTxt();
        assertTrue(true);
    }


}
