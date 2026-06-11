package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GuiFormPage {

    WebDriver driver;

    public GuiFormPage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("name");
    By email = By.id("email");
    By phone = By.id("phone");
    By address = By.id("textarea");

    By maleRadio = By.id("male");
    By femaleRadio = By.id("female");

    By sunday = By.id("sunday");
    By monday = By.id("monday");
    By friday = By.id("friday");

    By countryDropdown = By.id("country");
    By colorsDropdown = By.id("colors");
    By sortedListDropdown = By.id("animals");

    public void enterName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }

    public void enterEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPhone(String userPhone) {
        driver.findElement(phone).sendKeys(userPhone);
    }

    public void enterAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    public void selectMaleGender() {
        driver.findElement(maleRadio).click();
    }

    public void selectFemaleGender() {
        driver.findElement(femaleRadio).click();
    }

    public void selectSunday() {
        driver.findElement(sunday).click();
    }

    public void selectMonday() {
        driver.findElement(monday).click();
    }

    public void selectFriday() {
        driver.findElement(friday).click();
    }

    public void selectCountry() {
        Select country = new Select(driver.findElement(countryDropdown));
        country.selectByVisibleText("India");
    }

    public void selectColor() {
        Select color = new Select(driver.findElement(colorsDropdown));
        color.selectByVisibleText("Red");
    }

    public void selectAnimal() {
        Select animal = new Select(driver.findElement(sortedListDropdown));
        animal.selectByVisibleText("Cat");
    }
}