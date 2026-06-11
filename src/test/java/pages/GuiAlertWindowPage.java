package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuiAlertWindowPage {

    WebDriver driver;

    public GuiAlertWindowPage(WebDriver driver) {
        this.driver = driver;
    }

    By simpleAlertBtn = By.xpath("//button[text()='Simple Alert']");
    By confirmationAlertBtn = By.xpath("//button[text()='Confirmation Alert']");
    By promptAlertBtn = By.xpath("//button[text()='Prompt Alert']");
    By newTabBtn = By.xpath("//button[text()='New Tab']");
    By popupWindowBtn = By.xpath("//button[text()='Popup Windows']");

    public void handleSimpleAlert() {
        driver.findElement(simpleAlertBtn).click();
        driver.switchTo().alert().accept();
    }

    public void handleConfirmationAlert() {
        driver.findElement(confirmationAlertBtn).click();
        driver.switchTo().alert().accept();
    }

    public void handlePromptAlert() {
        driver.findElement(promptAlertBtn).click();
        driver.switchTo().alert().sendKeys("Test User");
        driver.switchTo().alert().accept();
    }

    public void handleNewTab() {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(newTabBtn).click();

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                System.out.println(driver.getTitle());

                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }

    public void handlePopupWindow() {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(popupWindowBtn).click();

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                System.out.println(driver.getTitle());

                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }
}