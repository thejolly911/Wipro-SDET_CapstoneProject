package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankLoginPage {

    WebDriver driver;

    public ParaBankLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.name("username");

    By passwordField = By.name("password");

    By loginButton =
            By.xpath("//input[@value='Log In']");
    
    public void login(String username,
            String password) {

driver.findElement(usernameField)
      .sendKeys(username);

driver.findElement(passwordField)
      .sendKeys(password);

driver.findElement(loginButton)
      .click();
}
}
