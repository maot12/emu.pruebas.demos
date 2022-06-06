package test.java.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.helpers.UtilSelenium;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class GeneralStoreHomePage extends UtilSelenium {

    /**
     * Variables globales
     */
    public static String textoToast = "";
    public static String textoHome = "";

    /**
     * Localizadores
     */
    public By txtName = By.id("com.androidsample.generalstore:id/nameField");
    public By btnLetShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    public By radMale = By.id("com.androidsample.generalstore:id/radioMale");
    public By radFema = By.id("com.androidsample.generalstore:id/radioMale");
    public By spinCon = By.id("com.androidsample.generalstore:id/spinnerCountry");
    public By toastMsg = By.xpath("//android.widget.Toast[@text='Please enter your name']");
    public By textoHomeTitle = By.id("com.androidsample.generalstore:id/toolbar_title");

    /**
     * Constructor de la clase con herencia
     * @param driver
     */
    public GeneralStoreHomePage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Método que realiza las funciones del primer test
     */
    public void primerTest(){

        type(txtName,"Miguel");

        click(radMale,"");

        click(spinCon,"");

        WebElement el = scrollHasta("Argentina");

        el.click();

        click(btnLetShop,"Let's  Shop");

    }

    /**
     * Método que realiza las funciones del segundo test
     */
    public void segundoTest(){

        click(btnLetShop,"Let's  Shop");

        textoToast = esperarHastaConTexto(toastMsg);

    }

    /**
     * Método que realiza las funciones del cuarto test y devuelve un string
     * @return
     */
    public String cuartoTest(){

        return esperarHastaConTexto(textoHomeTitle);

    }
}
