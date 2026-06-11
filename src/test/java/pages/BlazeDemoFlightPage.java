package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoFlightPage {

    WebDriver driver;

    public BlazeDemoFlightPage(WebDriver driver) {
        this.driver = driver;
    }

    By chooseFlightBtn =
            By.xpath("(//input[@value='Choose This Flight'])[1]");

    public void chooseFlight() {

        driver.findElement(chooseFlightBtn).click();
    }
}