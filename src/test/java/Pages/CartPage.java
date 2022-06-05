package test.java.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import test.java.Helpers.Base;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Miguel Angel Ortega
 * @created 05/06/2022
 * @project emu.pruebas.demo
 */
public class CartPage extends Base {

    public By productName = By.id("com.androidsample.generalstore:id/productName");
    public By textoCartTitle = By.id("com.androidsample.generalstore:id/toolbar_title");

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    public String validarQuintoTest(){
        esperarHastaElementoVisible(productName);
        return driver.findElement(productName).getText();
    }
}
