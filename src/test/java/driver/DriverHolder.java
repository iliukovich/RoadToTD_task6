package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    private static ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();
    private static WebDriver driver;

    private DriverHolder() {
    }

    public static WebDriver getInstance() {
        if (driverHolder.get() == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driverHolder.set(driver);
        }
        return driverHolder.get();
    }

    public static void clean() {
        driver.close();
        driver = null;
    }
}
