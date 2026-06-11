package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import utilities.WaitUtils;

public class GuiSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public GuiSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By wikipediaSearchBox =
            By.id("Wikipedia1_wikipedia-search-input");

    By wikipediaSearchButton =
            By.className("wikipedia-search-button");

    By firstWikipediaResult =
            By.xpath("(//div[@class='wikipedia-search-results']//a)[1]");

    public void searchWikipedia(String text)
            throws InterruptedException {

        WaitUtils.scrollToElement(
                driver,
                driver.findElement(wikipediaSearchBox));

        Thread.sleep(3000);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(wikipediaSearchBox))
                .sendKeys(text);

        wait.until(ExpectedConditions
                .elementToBeClickable(wikipediaSearchButton))
                .click();

        Thread.sleep(3000);
    }

    public void openFirstWikipediaResult()
            throws InterruptedException {

        String parentWindow =
                driver.getWindowHandle();

        wait.until(ExpectedConditions
                .elementToBeClickable(firstWikipediaResult))
                .click();

        Thread.sleep(3000);

        for (String window :
                driver.getWindowHandles()) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                System.out.println(
                        "Wikipedia Title : "
                                + driver.getTitle());

                Thread.sleep(3000);

                driver.close();

                break;
            }
        }

        driver.switchTo().window(parentWindow);

        System.out.println(
                "Returned to Automation Page");
    }
}