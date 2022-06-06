package test.java.helpers;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;


/**
 * @author mortega2
 * @project emu.pruebas.demos
 * @date 02/06/2022
 */
public class UtilSelenium {

    protected AndroidDriver driver;
    public WebDriverWait waiter;

    /**
     * Conctructor de la clase UtilSelenium
     * @param driver
     */
    public UtilSelenium(AndroidDriver driver){
        this.driver = driver;
    }

    /**
     * Clase que instancia el objeto Android driver con las capabilities necesarias para conectarse al emulador
     * de android studio
     * @param device
     * @return
     */
    public AndroidDriver capabilities(String device) throws MalformedURLException {

        //Ruta donde se encuentra el archivo *.apk
        String rootDir = "src\\test\\Resources\\app";

        //Nombre del archivo .apk
        String nameApk = "General-Store.apk";

        //Nombre del driver
        String automationName = "uiautomator2";

        //Url donde nos conectamos con el server de Appium
        String url = "http://127.0.0.1:4723/wd/hub";

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

    /**
     * Método para escribir en un campo de texto
     * @param locator
     * @param texto
     */
    public void type(By locator, String texto){
        List<WebElement> lista = driver.findElements(locator);

        for (WebElement we : lista){
            if (we.isDisplayed()){
                we.clear();
                we.sendKeys(texto);
            }
        }
    }

    /**
     * Método para hacer clic en un elemento
     * @param locator
     * @param texto
     */
    public void click(By locator, String texto) {
        List<WebElement> lista = driver.findElements(locator);

        for (WebElement we : lista){
            if (we.getText().contains(texto)) {
                we.click();
                break;
            }
        }
    }

    /**
     * Método para hacer una espera implícita hasta que un elemento esté cargado
     * @param locator
     */
    public void esperarHastaElementoVisible(By locator){
        waiter = new WebDriverWait(driver, Duration.ofSeconds(25));
        waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * Método para hacer una espera implícita hasta que un elemento esté cargado y devuelve su texto
     * @param locator
     * @return
     */
    public String esperarHastaConTexto(By locator){
        waiter = new WebDriverWait(driver, Duration.ofSeconds(25));
        waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElement(locator).getText();
    }

    /**
     * Método que recorre una lista haciendo scroll hasta el texto que pasamos por parámetro
     * @param texto
     * @return
     */
    public WebElement scrollHasta(String texto){
        return  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\""+texto+"\"));"));
    }

    /**
     * Método que recorre una lista haciendo scroll hasta el texto que pasamos por parámetro
     * @param locator
     * @param texto
     */
    public void scrollHastaEncontrar(String locator, String texto){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\""+locator+"\"))"
                + ".scrollIntoView(new UiSelector()"
                    + ".textMatches(\""+texto+"\")"
                    + ".instance(0))"));
    }

    /**
     * Método para hacer un long press al elemento
     * @param locator
     */
    public void pressTermsConditions(By locator){
        TouchAction action = new TouchAction(driver);
        WebElement el = driver.findElement(locator);
        action.longPress(element(el));
        action.release();
        action.perform();
    }

    /**
     * Método que devuelve la fecha y la hora formateados
     * @return
     */
    public String getDate(){
        Date date = new Date();
        DateFormat dateFormatFecha = new SimpleDateFormat("ddMMyy");
        DateFormat dateFormatHoras = new SimpleDateFormat("HHmmss");
        return dateFormatFecha.format(date)+dateFormatHoras.format(date);
    }

    /**
     * Método que realiza una captura de pantalla
     * @param clase
     * @throws InterruptedException
     * @throws IOException
     */
    public void screenShotSelenium(String clase) throws InterruptedException, IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File("src\\test\\resources\\screenshots\\screenshot_"+clase+"_"+getDate()+".png"));
    }
}
