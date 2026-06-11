package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GuiUtilityPage {
	 WebDriver driver;

	    public GuiUtilityPage(WebDriver driver) {
	        this.driver = driver;

}
	    By startButton =
	            By.xpath("//button[text()='START']");
	    
	    public void clickDynamicButton() {

	        WebDriverWait wait =
	                new WebDriverWait(driver,
	                        Duration.ofSeconds(10));

	        wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        startButton));

	        driver.findElement(startButton).click();

	        System.out.println(
	                "Dynamic Button Clicked Successfully");
	    }
}
