package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuiDatePickerPage {

    WebDriver driver;
    WebDriverWait wait;

    public GuiDatePickerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By datePicker1 = By.id("datepicker");

    By datePicker2 = By.id("txtDate");

    By startDate = By.id("start-date");

    By endDate = By.id("end-date");

    By submitDateRange =
            By.xpath("//button[text()='Submit']");

    public void enterDatePicker1() {

        WebElement dateField =
                wait.until(ExpectedConditions.elementToBeClickable(datePicker1));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        dateField);

        dateField.clear();

        dateField.sendKeys("06/06/2026");

        dateField.sendKeys(Keys.TAB);

        System.out.println(
                "DatePicker1 Value = "
                        + dateField.getAttribute("value"));
    }

    public void enterDatePicker2() {

        WebElement dateField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(datePicker2));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].value='06/15/2026';",
                        dateField);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].dispatchEvent(new Event('change'));",
                        dateField);

        System.out.println(
                "DatePicker2 Value = "
                        + dateField.getAttribute("value"));
    }

    public void selectDateRange() {

        WebElement start =
                wait.until(ExpectedConditions.visibilityOfElementLocated(startDate));

        WebElement end =
                wait.until(ExpectedConditions.visibilityOfElementLocated(endDate));

        start.clear();
        start.sendKeys("06-06-2026");

        end.clear();
        end.sendKeys("10-06-2026");

        System.out.println("Date Range Selected");
    }

    public void submitDateRange() {

        WebElement submit =
                wait.until(ExpectedConditions.elementToBeClickable(submitDateRange));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        submit);

        submit.click();

        System.out.println("Date Range Submitted");
    }
} 