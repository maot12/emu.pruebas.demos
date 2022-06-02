package Helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class Base {

    protected AndroidDriver driver;
    protected WebDriverWait myWaitVar;

    public Base(AndroidDriver driver){
        this.driver = driver;
    }

    public AndroidDriver capabilities(String device) throws MalformedURLException {
        String automationName = "uiautomator2";
        String url = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if (device.equals("emulator")){
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PruebaAppium3");
        } else if (device.equals("real")) {
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"R58R44BP8NZ");
        }
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\mortega2\\IdeaProjects\\emu.pruebas.demos\\src\\main\\resources\\General-Store.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        //desiredCapabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
        //desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

        return new AndroidDriver(new URL(url), desiredCapabilities);

    }

    public void type(By locator, String texto){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(texto);
    }
}
