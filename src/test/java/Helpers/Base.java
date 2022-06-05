package test.java.Helpers;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class Base {

    protected AndroidDriver driver;
    WebDriverWait waitForToast;

    public Base(AndroidDriver driver){
        this.driver = driver;
    }

    public AndroidDriver capabilities(String device) throws MalformedURLException {
        String rootDir = "src\\test\\Resources\\app";
        String nameApk = "General-Store.apk";
        String automationName = "uiautomator2";
        String url = "http://127.0.0.1:4723/wd/hub";

        /******************************************************************************************/

        File app = new File(new File(rootDir), nameApk);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if (device.equals("emulator")){
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emu.pruebas.demo");
        } else if (device.equals("real")) {
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"R58R44BP8NZ");
        }
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        //desiredCapabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
        //desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

        return new AndroidDriver(new URL(url), desiredCapabilities);

    }

    public void type(By locator, String texto){
        List<WebElement> lista = driver.findElements(locator);

        for (WebElement we : lista){
            if (we.isDisplayed()){
                we.clear();
                we.sendKeys(texto);
            }
        }
    }

    public void click(By locator, String texto) {
        List<WebElement> lista = driver.findElements(locator);

        for (WebElement we : lista){
            if (we.getText().contains(texto)) {
                we.click();
                break;
            }
        }
    }

    public void esperarHastaElementoVisible(By locator){
        waitForToast = new WebDriverWait(driver, Duration.ofSeconds(25));
        waitForToast.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public String esperarHastaConTexto(By locator){
        waitForToast = new WebDriverWait(driver, Duration.ofSeconds(25));
        waitForToast.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElement(locator).getText();
    }

    public WebElement scrollHasta(String texto){
        return  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\""+texto+"\"));"));
    }

    public void scrollHastaEncontrar(String locator, String texto){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\""+locator+"\"))"
                + ".scrollIntoView(new UiSelector()"
                    + ".textMatches(\""+texto+"\")"
                    + ".instance(0))"));
    }
}
