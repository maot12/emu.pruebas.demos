package test.java.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import test.java.Helpers.Base;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class ProductsPage extends Base {

    public static String textoToast = "";
    public String listaProductosDesplegable = "com.androidsample.generalstore:id/rvProductList";
    public String nombreProducto = "Jordan 6 Rings";

    public By textProducts = By.id("com.androidsample.generalstore:id/toolbar_title");
    public By iconCart = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    public By btnBack = By.id("com.androidsample.generalstore:id/appbar_btn_back");
    public By toastMsgOne = By.xpath("//android.widget.Toast[@text='Please add some product at first']");
    public By btnAddToCart = By.id("com.androidsample.generalstore:id/productAddCart");
    public By textPrice = By.xpath("//android.widget.TextView");
    public By textProductName = By.id("com.androidsample.generalstore:id/productName");


    public ProductsPage(AndroidDriver driver) {
        super(driver);
    }

    public String  validarPrimerTest(){
        return esperarHastaConTexto(textProducts);
    }

    public void tercerTest(){
        esperarHastaElementoVisible(iconCart);
        click(iconCart,"");
        textoToast = esperarHastaConTexto(toastMsgOne);
    }

    public void cuartoTest(){
        click(btnBack,"");
    }

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


}
