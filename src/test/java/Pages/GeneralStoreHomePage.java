package test.java.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.Helpers.Base;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class GeneralStoreHomePage extends Base {

    public static String textoToast = "";
    public static String textoHome = "";

    public By txtName = By.id("com.androidsample.generalstore:id/nameField");
    public By btnLetShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    public By radMale = By.id("com.androidsample.generalstore:id/radioMale");
    public By radFema = By.id("com.androidsample.generalstore:id/radioMale");
    public By spinCon = By.id("com.androidsample.generalstore:id/spinnerCountry");
    public By toastMsg = By.xpath("//android.widget.Toast[@text='Please enter your name']");
    public By textoHomeTitle = By.id("com.androidsample.generalstore:id/toolbar_title");

    public GeneralStoreHomePage(AndroidDriver driver) {
        super(driver);
    }

    public void primerTest(){
        /*
        Introducimos texto en el input text
         */
        type(txtName,"Miguel");
        /*
        Realizamos click en el radio buttom "male"
         */
        click(radMale,"");
        /*
        Realizamos click en el spinner
         */
        click(spinCon,"");
        /*

         */

        WebElement el = scrollHasta("Argentina");
        el.click();
        click(btnLetShop,"Let's  Shop");
    }

    public void segundoTest(){
        click(btnLetShop,"Let's  Shop");
        textoToast = esperarHastaConTexto(toastMsg);
    }

    public String cuartoTest(){
        return esperarHastaConTexto(textoHomeTitle);
    }
}
