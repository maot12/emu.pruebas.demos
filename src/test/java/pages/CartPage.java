package test.java.pages;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import test.java.helpers.UtilSelenium;

import static org.testng.AssertJUnit.assertEquals;


/**
 * @author Miguel Angel Ortega
 * @created 05/06/2022
 * @project emu.pruebas.demo
 */
public class CartPage extends UtilSelenium {

    /**
     * Variables globales
     */
    public static double totalValue = 0;
    public static double productValueClean = 0;

    /**
     * Localizadores
     */
    public By productName = By.id("com.androidsample.generalstore:id/productName");
    public By textoCartTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
    public By textoPrice = By.id("com.androidsample.generalstore:id/productPrice");
    public By textoAmountPrice = By.id("com.androidsample.generalstore:id/totalAmountLbl");
    public By checkBoxCart = By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");
    public By btnVisit = By.id("com.androidsample.generalstore:id/btnProceed");
    public By btnLongPress = By.id("com.androidsample.generalstore:id/termsButton");
    public By btnBack = By.id("com.androidsample.generalstore:id/appbar_btn_back");
    public By btnCloseTerms = By.xpath("//android.widget.Button[@text='CLOSE']");
    public By textTerms = By.xpath("//android.widget.TextView[@text='Terms Of Conditions']");

    /**
     * Constructor de la clase con herencia
     * @param driver
     */
    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Método que valida el quinto test y devuelve un string
     * @return
     */
    public String validarQuintoTest(){
        esperarHastaElementoVisible(productName);
        return driver.findElement(productName).getText();
    }

    /**
     * Método que realiza las funciones del sexto test
     */
    public void sextoTest(){

        for (int i = 0; i < driver.findElements(textoPrice).size();i++){

            String valueString = driver.findElements(textoPrice).get(i).getText();
            productValueClean += getDoubleClean(valueString);

        }

        String total = driver.findElements(textoAmountPrice)
                .get(0)
                .getText();
        totalValue = getDoubleClean(total);

    }

    /**
     * Método que realiza las funciones del séptimo test
     */
    public void septimoTest(){

        pressTermsConditions(btnLongPress);

        assertEquals("Terms Of Conditions",driver.findElement(textTerms).getText());

        click(btnCloseTerms,"CLOSE");
    }

    /**
     * Método que limpia un valor double pasándole por parámetro un string y me devuelve el double formateado
     * @param valueString
     * @return
     */
    private double getDoubleClean(String valueString) {

        valueString = valueString.substring(1);

        return Double.parseDouble(valueString);
    }
}
