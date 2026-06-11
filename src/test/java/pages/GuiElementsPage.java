package pages;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class GuiElementsPage {

    WebDriver driver;

    public GuiElementsPage(WebDriver driver) {
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
    
    By datePicker1 = By.id("datepicker");
    By datePicker2 = By.id("txtDate");
    By selectedDate = By.xpath("//a[text()='15']");
    By startDate = By.id("start-date");
    By endDate = By.id("end-date");
    By submitDateRange = By.xpath("//button[text()='Submit']");
    
    By singleFileUpload = By.id("singleFileInput");

    By uploadSingleFileBtn =
            By.xpath("//button[text()='Upload Single File']");
    
    By uploadStatus = By.id("singleFileStatus");
    
    By multipleFileUpload = By.id("multipleFilesInput");

    By uploadMultipleFilesBtn =
            By.xpath("//button[text()='Upload Multiple Files']");

    By multipleFilesStatus =
            By.id("multipleFilesStatus");
    
    By simpleAlertBtn = By.xpath("//button[text()='Simple Alert']");
    By confirmationAlertBtn = By.xpath("//button[text()='Confirmation Alert']");
    By promptAlertBtn = By.xpath("//button[text()='Prompt Alert']");
    By newTabBtn = By.xpath("//button[text()='New Tab']");
    By popupWindowBtn = By.xpath("//button[text()='Popup Windows']");

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
    
    public void enterDatePicker1() {
        driver.findElement(datePicker1).sendKeys("06/06/2026");
    }
    
    public void enterDatePicker2() {

        driver.findElement(datePicker2).click();

        driver.findElement(selectedDate).click();
    }
    
    public void selectDateRange() {

        driver.findElement(startDate)
              .sendKeys("06-06-2026");

        driver.findElement(endDate)
              .sendKeys("10-06-2026");
    }
    
    public void submitDateRange() {
        driver.findElement(submitDateRange).click();
    }
    
    public void uploadSingleFile(String filePath) {

        driver.findElement(singleFileUpload)
              .sendKeys(filePath);
    }

    public void clickUploadButton() {

        driver.findElement(uploadSingleFileBtn)
              .click();
    }
    
    public String getUploadStatus() {

        return driver.findElement(uploadStatus)
                     .getText();
    }
    
    public void uploadMultipleFiles(String file1, String file2) {

        driver.findElement(multipleFileUpload)
              .sendKeys(file1 + "\n" + file2);
    }

    public void clickUploadMultipleFiles() {

        driver.findElement(uploadMultipleFilesBtn)
              .click();
    }

    public String getMultipleFilesStatus() {

        return driver.findElement(multipleFilesStatus)
                     .getText();
    }
    
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

                System.out.println("New Tab Title : "
                        + driver.getTitle());

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

                System.out.println("Popup Window Title : "
                        + driver.getTitle());

                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }
    
}