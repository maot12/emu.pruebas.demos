package test.java.Pages;

import Helpers.Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.MobileBy.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class GeneralStoreHomePage extends Base {

    public static String textoToast = "";

    By txtName = By.id("com.androidsample.generalstore:id/nameField");
    By btnLetShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    By radMale = By.id("com.androidsample.generalstore:id/radioMale");
    By radFema = By.id("com.androidsample.generalstore:id/radioMale");
    By spinCon = By.id("com.androidsample.generalstore:id/spinnerCountry");

    By toastMsg = By.xpath("//android.widget.Toast[@text='Please enter your name']");







    public GeneralStoreHomePage(AndroidDriver driver) {
        super(driver);
    }

    public void primerTest(){
        type(txtName,"Miguel");
        click(radMale);
        click(spinCon);
        WebElement el = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        el.click();
        click(btnLetShop);
    }

    public void segundoTest(){
        click(btnLetShop);
        textoToast = esperarHastaConTexto(toastMsg);
    }
}
