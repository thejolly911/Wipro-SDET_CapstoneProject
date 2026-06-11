package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuiFileUploadPage {

    WebDriver driver;

    public GuiFileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    By singleFileUpload = By.id("singleFileInput");

    By uploadSingleFileBtn =
            By.xpath("//button[text()='Upload Single File']");

    By uploadStatus = By.id("singleFileStatus");

    By multipleFileUpload = By.id("multipleFilesInput");

    By uploadMultipleFilesBtn =
            By.xpath("//button[text()='Upload Multiple Files']");

    By multipleFilesStatus =
            By.id("multipleFilesStatus");

    public void uploadSingleFile(String filePath) {
        driver.findElement(singleFileUpload).sendKeys(filePath);
    }

    public void clickUploadButton() {
        driver.findElement(uploadSingleFileBtn).click();
    }

    public String getUploadStatus() {
        return driver.findElement(uploadStatus).getText();
    }

    public void uploadMultipleFiles(String file1, String file2) {
        driver.findElement(multipleFileUpload)
                .sendKeys(file1 + "\n" + file2);
    }

    public void clickUploadMultipleFiles() {
        driver.findElement(uploadMultipleFilesBtn).click();
    }

    public String getMultipleFilesStatus() {
        return driver.findElement(multipleFilesStatus).getText();
    }
}