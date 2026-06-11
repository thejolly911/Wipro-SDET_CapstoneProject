package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import utilities.WaitUtils;
public class GuiAdvancedPage {
	 WebDriver driver;

	    public GuiAdvancedPage(WebDriver driver) {
	        this.driver = driver;
	    }   
	    By appleLink = By.id("apple");
	    By lenovoLink = By.id("lenovo");
	    By dellLink = By.id("dell"); 
	    
	    
	    
	    By footerLinks =
	            By.xpath("//h2[text()='Footer Links']/following-sibling::div//a");
	
	    public void handleShadowDom() {

	        WebElement shadowHost =
	                driver.findElement(By.id("shadow_host"));

	        SearchContext shadowRoot =
	                shadowHost.getShadowRoot();

	        // Textbox
	        WebElement textBox =
	                shadowRoot.findElement(By.cssSelector("input[type='text']"));

	        textBox.sendKeys("Shadow DOM Test");

	        // Checkbox
	        WebElement checkBox =
	                shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));

	        checkBox.click();

	        // File Upload
	        WebElement fileUpload =
	                shadowRoot.findElement(By.cssSelector("input[type='file']"));

	        String filePath =
	                System.getProperty("user.dir")
	                + "\\src\\test\\resources\\testdata\\sample.txt";

	        fileUpload.sendKeys(filePath);

	        System.out.println("Shadow DOM Textbox Entered");
	        System.out.println("Shadow DOM Checkbox Selected");
	        System.out.println("Shadow DOM File Uploaded");
	    }
	public void verifyBrokenLinks() {

	    List<WebElement> links =
	            driver.findElements(
	                    By.xpath("//div[@id='broken-links']//a"));

	    for (WebElement link : links) {

	        String url = link.getAttribute("href");

	        try {

	            HttpURLConnection connection =
	                    (HttpURLConnection)
	                    new URL(url).openConnection();

	            connection.connect();

	            int responseCode =
	                    connection.getResponseCode();

	            System.out.println(
	                    url + " --> " + responseCode);

	        } catch (Exception e) {

	            System.out.println(
	                    "Broken Link: " + url);
	        }
	    }
	}
	public void openLaptopLink(By laptopLocator)
	        throws InterruptedException {

	    WebElement laptop =
	            driver.findElement(laptopLocator);

	    WaitUtils.scrollToElement(
	            driver,
	            laptop);

	    String parentWindow =
	            driver.getWindowHandle();

	    laptop.click();

	    for (String window : driver.getWindowHandles()) {

	        if (!window.equals(parentWindow)) {

	            driver.switchTo().window(window);

	            System.out.println(
	                    "Laptop Site : "
	                    + driver.getTitle());

	            Thread.sleep(3000);

	            driver.close();

	            break;
	        }
	    }

	    driver.switchTo().window(parentWindow);
	}
	
	public void openAppleLink()
	        throws InterruptedException {

	    openLaptopLink(appleLink);
	    driver.navigate().back();
	}

	public void openLenovoLink()
	        throws InterruptedException {

	    openLaptopLink(lenovoLink);
	    driver.navigate().back();
	}

	public void openDellLink()
	        throws InterruptedException {

	    openLaptopLink(dellLink);
	    driver.navigate().back();
	}
	public void printFooterLinks() {

	    List<WebElement> links =
	            driver.findElements(footerLinks);

	    System.out.println(
	            "Total Footer Links : "
	            + links.size());

	    for (WebElement link : links) {

	        System.out.println(
	                "Link Text : "
	                + link.getText());

	        System.out.println(
	                "URL : "
	                + link.getAttribute("href"));
	    }
	}
}
