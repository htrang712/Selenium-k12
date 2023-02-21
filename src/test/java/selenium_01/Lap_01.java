package selenium_01;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lap_01 {

    public static void main(String[] args) {
        String regulatePathDriver = System.getProperty("user.dir");
        String absolutePathDriver = "";
        if (OS.isFamilyMac()) {
            absolutePathDriver = regulatePathDriver.concat("/src/test/resources/Drivers/chromedriver");
        }
        if (OS.isFamilyWindows()) {
            absolutePathDriver = regulatePathDriver.concat("/src/test/resources/Drivers/chromedriver.exe");
        }
        if (absolutePathDriver.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS type!");
        }

        System.setProperty("webdriver.chrome.driver", absolutePathDriver);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognite");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://learn.sdetpro.com/");

        // Sleep
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
