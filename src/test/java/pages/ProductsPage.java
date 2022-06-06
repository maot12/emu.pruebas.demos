package test.java.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import test.java.helpers.UtilSelenium;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class ProductsPage extends UtilSelenium {

    /**
     * Variables globales
     */
    public static String textoToast = "";
    public String listaProductosDesplegable = "com.androidsample.generalstore:id/rvProductList";
    public String nombreProducto = "Jordan 6 Rings";

    /**
     * Localizadores
     */
    public By textProducts = By.id("com.androidsample.generalstore:id/toolbar_title");
    public By iconCart = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    public By btnBack = By.id("com.androidsample.generalstore:id/appbar_btn_back");
    public By toastMsgOne = By.xpath("//android.widget.Toast[@text='Please add some product at first']");
    public By btnAddToCart = By.id("com.androidsample.generalstore:id/productAddCart");
    public By textPrice = By.xpath("//android.widget.TextView");
    public By textProductName = By.id("com.androidsample.generalstore:id/productName");


    /**
     * Constructor de la clase con herencia
     * @param driver
     */
    public ProductsPage(AndroidDriver driver) {

        super(driver);
    }

    /**
     * Método para validar el primer test que devuelve un string
     * @return
     */
    public String  validarPrimerTest(){

        return esperarHastaConTexto(textProducts);
    }

    /**
     * Método que realiza las funciones del tercer test
     */
    public void tercerTest(){

        esperarHastaElementoVisible(iconCart);

        click(iconCart,"");

        textoToast = esperarHastaConTexto(toastMsgOne);
    }

    /**
     * Método que realiza las funciones del cuarto test
     */
    public void cuartoTest(){

        click(btnBack,"");
    }

    /**
     * Método que realiza las funciones del quinto test
     */
    public void quintoTest(){

        scrollHastaEncontrar(listaProductosDesplegable,nombreProducto);

        int count = driver.findElements(textProductName).size();

        for(int i = 0; i<count; i++) {

            String text = driver.findElements(textProductName).get(i).getText();

            if(text.equals(nombreProducto)) {

                driver.findElements(btnAddToCart).get(i).click();
                break;

            }

        }

        click(iconCart,"");

    }

    /**
     * Método para elegir dos productos de la lista del total de elementos
     */
    public void elegirDosProductos(){

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

        click(iconCart,"");

    }

}
