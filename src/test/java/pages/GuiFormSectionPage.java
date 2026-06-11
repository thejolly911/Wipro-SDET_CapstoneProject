package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuiFormSectionPage {

    WebDriver driver;

    public GuiFormSectionPage(WebDriver driver) {
        this.driver = driver;
    }

    By input1 = By.id("input1");
    By input2 = By.id("input2");
    By input3 = By.id("input3");

    By btn1 = By.id("btn1");
    By btn2 = By.id("btn2");
    By btn3 = By.id("btn3");
    
    public void fillSection1() {

        driver.findElement(input1)
              .sendKeys("Section One");

        driver.findElement(btn1)
              .click();

        System.out.println(
                "Section 1 Submitted");
    }
    public void fillSection2() {

        driver.findElement(input2)
              .sendKeys("Section Two");

        driver.findElement(btn2)
              .click();

        System.out.println(
                "Section 2 Submitted");
    }
    public void fillSection3() {

        driver.findElement(input3)
              .sendKeys("Section Three");

        driver.findElement(btn3)
              .click();

        System.out.println(
                "Section 3 Submitted");
    }
}