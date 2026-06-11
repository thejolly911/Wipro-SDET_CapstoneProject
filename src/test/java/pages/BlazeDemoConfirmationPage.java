package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoConfirmationPage {

    WebDriver driver;

    public BlazeDemoConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    By confirmationMessage =
            By.tagName("h1");

    public void verifyBookingSuccess() {

        String message =
                driver.findElement(
                        confirmationMessage)
                        .getText();

        System.out.println(
                "Booking Status : "
                + message);
    }
}