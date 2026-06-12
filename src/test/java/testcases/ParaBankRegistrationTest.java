package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ParaBankHomePage;
import pages.ParaBankLoginPage;
import pages.ParaBankRegistrationPage;

public class ParaBankRegistrationTest extends BaseTest {

    @Test
    public void verifyRegistrationAndLogin() {

        driver.get(
                "https://parabank.parasoft.com/parabank/register.htm");

        ParaBankRegistrationPage registerPage =
                new ParaBankRegistrationPage(driver);

        ParaBankHomePage homePage =
                new ParaBankHomePage(driver);

        ParaBankLoginPage loginPage =
                new ParaBankLoginPage(driver);

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        // Register User
        String username =
                registerPage.registerUser();

        System.out.println(
                "Registered Username = "
                + username);

        // Verify Registration Success
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[contains(text(),'Welcome')]")));

        Assert.assertTrue(
                driver.getPageSource()
                      .contains("Welcome"),
                "Registration failed");

        System.out.println(
                "Registration Successful");

        // Logout
        homePage.logout();

        // Wait for Login Page
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("username")));

        System.out.println(
                "Logout Successful");

     // Login Again
        loginPage.login(
                username,
                "Password123");

       

        // Print error/debug information
        System.out.println("After Login URL = "
                + driver.getCurrentUrl());

        System.out.println("After Login Title = "
                + driver.getTitle());

        System.out.println("PAGE CONTENT:");
        System.out.println(
                driver.findElement(By.tagName("body"))
                      .getText());

        // Wait for Accounts Overview Page
        wait.until(
                ExpectedConditions.urlContains(
                        "overview.htm"));

        System.out.println(
                "Current URL = "
                + driver.getCurrentUrl());

        System.out.println(
                "Page Title = "
                + driver.getTitle());

        // Verify Login
        Assert.assertTrue(
                driver.getCurrentUrl()
                      .contains("overview.htm"),
                "Login failed");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains("Accounts Overview"),
                "Accounts Overview not found");

        System.out.println(
                "Login Successful");
    }
}