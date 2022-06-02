package Pages;

import Helpers.Base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class GeneralStoreHomePage extends Base {

    By txtName = By.id("com.androidsample.generalstore:id/nameField");

    public GeneralStoreHomePage(AndroidDriver driver) {
        super(driver);
    }

    public void rellenarTxt(){
        type(txtName,"Miguel");
    }
}
