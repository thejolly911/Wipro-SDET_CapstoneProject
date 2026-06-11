package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankRegistrationPage {

    WebDriver driver;

    public ParaBankRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");

    By username = By.id("customer.username");
    By password = By.id("customer.password");

    By confirmPassword =
            By.id("repeatedPassword");

    By registerButton =
            By.xpath("//input[@value='Register']");
    
    public String registerUser() {

        String uniqueUser =
                "user" +
                System.currentTimeMillis();
        //unique username

        driver.findElement(firstName)
                .sendKeys("Demo");

        driver.findElement(lastName)
                .sendKeys("User");

        driver.findElement(address)
                .sendKeys("Demo Address");

        driver.findElement(city)
                .sendKeys("Boston");

        driver.findElement(state)
                .sendKeys("MA");

        driver.findElement(zipCode)
                .sendKeys("12345");

        driver.findElement(phone)
                .sendKeys("9876543210");

        driver.findElement(ssn)
                .sendKeys("12345");

        driver.findElement(username)
                .sendKeys(uniqueUser);

        driver.findElement(password)
                .sendKeys("Password123");

        driver.findElement(confirmPassword)
                .sendKeys("Password123");

        driver.findElement(registerButton)
                .click();

        return uniqueUser;
    }
}