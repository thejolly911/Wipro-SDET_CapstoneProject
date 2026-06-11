package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoPurchasePage {

    WebDriver driver;

    public BlazeDemoPurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zipCode = By.id("zipCode");

    By creditCardNumber =
            By.id("creditCardNumber");

    By creditCardMonth =
            By.id("creditCardMonth");

    By creditCardYear =
            By.id("creditCardYear");

    By nameOnCard =
            By.id("nameOnCard");

    By purchaseFlightBtn =
            By.xpath("//input[@value='Purchase Flight']");

    public void enterPassengerDetails() {

        driver.findElement(name)
                .sendKeys("Test User");

        driver.findElement(address)
                .sendKeys("Demo Address");

        driver.findElement(city)
                .sendKeys("Boston");

        driver.findElement(state)
                .sendKeys("Massachusetts");

        driver.findElement(zipCode)
                .sendKeys("12345");

        driver.findElement(creditCardNumber)
                .clear();

        driver.findElement(creditCardNumber)
                .sendKeys("4111111111111111");

        driver.findElement(creditCardMonth)
                .clear();

        driver.findElement(creditCardMonth)
                .sendKeys("12");

        driver.findElement(creditCardYear)
                .clear();

        driver.findElement(creditCardYear)
                .sendKeys("2028");

        driver.findElement(nameOnCard)
                .sendKeys("Test User");
    }

    public void purchaseFlight() {

        driver.findElement(purchaseFlightBtn)
                .click();
    }
}