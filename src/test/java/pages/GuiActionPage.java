package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.WaitUtils;

public class GuiActionPage {

    WebDriver driver;

    public GuiActionPage(WebDriver driver) {
        this.driver = driver;
    }

    By copyTextBtn =
            By.xpath("//button[text()='Copy Text']");

    By dragElement =
            By.id("draggable");

    By dropElement =
            By.id("droppable");

    By slider =
            By.xpath("//span[contains(@class,'ui-slider-handle')]");

    By pointMeBtn =
            By.xpath("//button[text()='Point Me']");

    By comboBox =
            By.id("comboBox");

    public void performDoubleClick()
            throws InterruptedException {

        WebElement button =
                driver.findElement(copyTextBtn);

        WaitUtils.scrollToElement(driver, button);

        Thread.sleep(3000);

        new Actions(driver)
                .doubleClick(button)
                .perform();

        System.out.println("Double Click Done");
    }

    public void performDragAndDrop()
            throws InterruptedException {

        WebElement source =
                driver.findElement(dragElement);

        WebElement target =
                driver.findElement(dropElement);

        WaitUtils.scrollToElement(driver, source);

        Thread.sleep(3000);

        new Actions(driver)
                .dragAndDrop(source, target)
                .perform();

        System.out.println("Drag Drop Done");
    }

    public void moveSlider()
            throws InterruptedException {

        WebElement sliderElement =
                driver.findElement(slider);

        WaitUtils.scrollToElement(
                driver,
                sliderElement);

        Thread.sleep(3000);

        new Actions(driver)
                .dragAndDropBy(
                        sliderElement,
                        80,
                        0)
                .perform();

        System.out.println("Slider Moved");
    }

    public void performMouseHover()
            throws InterruptedException {

        WebElement hoverElement =
                driver.findElement(pointMeBtn);

        WaitUtils.scrollToElement(
                driver,
                hoverElement);

        Thread.sleep(3000);

        new Actions(driver)
                .moveToElement(hoverElement)
                .perform();

        System.out.println("Mouse Hover Done");
    }

    public void selectScrollingDropdown()
            throws InterruptedException {

        WebElement combo =
                driver.findElement(comboBox);

        WaitUtils.scrollToElement(
                driver,
                combo);

        Thread.sleep(3000);

        combo.click();

        combo.sendKeys("Item 5");

        System.out.println(
                "Scrolling Dropdown Selected");
    }
}