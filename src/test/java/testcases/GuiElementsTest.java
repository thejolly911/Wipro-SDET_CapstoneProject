package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GuiAlertWindowPage;
import pages.GuiDatePickerPage;
import pages.GuiFileUploadPage;
import pages.GuiFormPage;
import pages.GuiActionPage;
import pages.GuiSearchPage;
import pages.GuiTablePage;
import pages.GuiAdvancedPage;
import pages.GuiUtilityPage;
import pages.GuiFormSectionPage;
import utilities.WaitUtils;

public class GuiElementsTest extends BaseTest {

    @Test
    public void verifyGuiElements() throws InterruptedException {

        driver.get("https://testautomationpractice.blogspot.com");

        GuiFormPage formPage = new GuiFormPage(driver);

        GuiDatePickerPage datePage =
                new GuiDatePickerPage(driver);

        GuiFileUploadPage uploadPage =
                new GuiFileUploadPage(driver);

        GuiAlertWindowPage alertPage =
                new GuiAlertWindowPage(driver);
        
        GuiActionPage actionPage =
                new GuiActionPage(driver);
        
        GuiSearchPage searchPage =
                new GuiSearchPage(driver);
        
        GuiTablePage tablePage =
                new GuiTablePage(driver);
        
        GuiAdvancedPage advancedPage =
                new GuiAdvancedPage(driver);
        
        GuiUtilityPage utilityPage =
                new GuiUtilityPage(driver);
        
        GuiFormSectionPage formSectionPage =
                new GuiFormSectionPage(driver);

        // Text Fields
        formPage.enterName("Test User");
        formPage.enterEmail("testuser@gmail.com");
        formPage.enterPhone("9876543210");
        formPage.enterAddress("Demo Address");
        Thread.sleep(2000);


        // Radio Button
        formPage.selectMaleGender();
        Thread.sleep(2000);


        // Checkboxes
        formPage.selectSunday();
        formPage.selectMonday();
        formPage.selectFriday();
        Thread.sleep(2000);


        // Dropdowns
        formPage.selectCountry();
        Thread.sleep(2000);

        formPage.selectColor();
        Thread.sleep(2000);

        formPage.selectAnimal();
        Thread.sleep(2000);


        // Date Pickers
        datePage.enterDatePicker1();
        Thread.sleep(2000);

        datePage.enterDatePicker2();
        Thread.sleep(2000);

        datePage.selectDateRange();
        datePage.submitDateRange();
        Thread.sleep(2000);


        // Single File Upload
        String singleFilePath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\sample.txt";

        uploadPage.uploadSingleFile(singleFilePath);
        uploadPage.clickUploadButton();
        Thread.sleep(2000);


        System.out.println(uploadPage.getUploadStatus());

        // Multiple File Upload
        String file1 =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\sample1.txt";

        String file2 =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\sample2.txt";

        uploadPage.uploadMultipleFiles(file1, file2);
        uploadPage.clickUploadMultipleFiles();
        Thread.sleep(2000);


        System.out.println(uploadPage.getMultipleFilesStatus());
        
     // Pagination Web Tables
        
        tablePage.selectProduct("Laptop");
        Thread.sleep(3000);
        
        tablePage.printRowCount();
        Thread.sleep(2000);

        tablePage.navigatePagination();
        Thread.sleep(2000);
        
        // Wikipedia Search
        searchPage.searchWikipedia("Selenium");

        Thread.sleep(2000);

        searchPage.openFirstWikipediaResult();
        
        // Dynamic Button
        utilityPage.clickDynamicButton();
        Thread.sleep(2000);

        // Alerts
        alertPage.handleSimpleAlert();
        Thread.sleep(2000);

        alertPage.handleConfirmationAlert();
        Thread.sleep(2000);

        alertPage.handlePromptAlert();
        Thread.sleep(2000);


        // Windows
        alertPage.handleNewTab();
        Thread.sleep(2000);

        alertPage.handlePopupWindow();
        Thread.sleep(2000);

        // Mouse Hover
        actionPage.performMouseHover();
        Thread.sleep(2000);

       // Double Click
        actionPage.performDoubleClick();
        Thread.sleep(2000);

       // Drag and Drop
        actionPage.performDragAndDrop();
        Thread.sleep(2000);

       // Slider
        actionPage.moveSlider();
        Thread.sleep(2000);
        
        // Scrolling Dropdown
        WaitUtils.scrollToElement(
                driver,
                driver.findElement(By.id("comboBox")));

        Thread.sleep(1000);

        actionPage.selectScrollingDropdown();
        Thread.sleep(2000);
      
        // Laptop Links
        advancedPage.openAppleLink();
        Thread.sleep(2000);

        advancedPage.openLenovoLink();
        Thread.sleep(2000);

        advancedPage.openDellLink();
        Thread.sleep(2000);
        
     // Broken Links
        advancedPage.verifyBrokenLinks();
        Thread.sleep(3000);
        
        // Shadow DOM
        advancedPage.handleShadowDom();
        Thread.sleep(2000);
        
        // Form
        formSectionPage.fillSection1();

        formSectionPage.fillSection2();

        formSectionPage.fillSection3();
        
        // Footer Links
        advancedPage.printFooterLinks();
       

        Thread.sleep(5000);
    }
}