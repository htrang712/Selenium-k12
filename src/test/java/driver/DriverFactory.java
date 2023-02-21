package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
        String regulatePathDriver = System.getProperty("user.dir");
        String absolutePathDriver = "";
        if (OS.isFamilyMac()){
            absolutePathDriver = regulatePathDriver.concat("src/test/resources/Drivers/chromedriver");
        }
        if (OS.isFamilyWindows()){
            absolutePathDriver = regulatePathDriver.concat("src/test/resources/Drivers/chromedriver.exe");
        }
        if (absolutePathDriver.isEmpty()){
            throw new IllegalArgumentException("Can't detect OS type!");
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognite");

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }
}
