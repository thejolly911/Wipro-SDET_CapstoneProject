package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class GuiTablePage {

    WebDriver driver;

    public GuiTablePage(WebDriver driver) {
        this.driver = driver;
    }
    By rows =
            By.xpath("//table[@id='productTable']/tbody/tr");

    By page2 = By.xpath("//a[text()='2']");

    By page3 = By.xpath("//a[text()='3']");

    By page4 = By.xpath("//a[text()='4']");
    
    public void navigatePagination() {

        WaitUtils.scrollToElement(
                driver,
                driver.findElement(page2));

        driver.findElement(page2).click();

        System.out.println("Opened Page 2");

        driver.findElement(page3).click();

        System.out.println("Opened Page 3");

        driver.findElement(page4).click();

        System.out.println("Opened Page 4");
    }
        public void printRowCount() {

            int rowCount =
                    driver.findElements(rows).size();

            System.out.println(
                    "Total Rows : " + rowCount);
        }
        
        public void selectProduct(String productName) {

            for(int page=1; page<=4; page++) {

                try {

                    driver.findElement(
                        By.xpath("//td[text()='"
                        + productName +
                        "']/following-sibling::td/input"))
                        .click();

                    System.out.println(
                        productName + " Selected");

                    break;

                } catch(Exception e) {

                    if(page < 4) {

                        driver.findElement(
                            By.xpath("//a[text()='"
                            + (page+1)
                            + "']"))
                            .click();
                    }
                }
            }
        }
    

}