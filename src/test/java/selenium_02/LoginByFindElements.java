package selenium_02;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginByFindElements {

    public static void main(String[] args) {

        // start session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // open website
            driver.get("https://the-internet.herokuapp.com/login");

            // find element
            By fieldSel = By.tagName("input");
            By loginBtnSel = By.cssSelector("[type='submit']");

            List<WebElement> fieldElem = driver.findElements(fieldSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;

            if (!fieldElem.isEmpty()) {
                // interaction
                fieldElem.get(USERNAME_INDEX).sendKeys("tomsmith");
                fieldElem.get(PASSWORD_INDEX).sendKeys("SuperSecretPassword!");
                loginBtnElem.click();
            } else {
                throw new IllegalArgumentException("Element not found");
            }

            //debug
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        driver.navigate().refresh();
        driver.navigate().back();

        // quite session
        driver.quit();
    }
}
