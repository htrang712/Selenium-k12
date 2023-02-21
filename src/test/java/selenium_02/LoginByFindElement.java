package selenium_02;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginByFindElement {

    public static void main(String[] args) {

        // start session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // open website
            driver.get("https://the-internet.herokuapp.com/login");

            // find element
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            // interaction
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            //debug
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // quite session
        driver.quit();

    }
}
