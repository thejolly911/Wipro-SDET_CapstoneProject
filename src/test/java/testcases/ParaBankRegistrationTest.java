package testcases;

import java.time.Duration;

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
    public void verifyRegistrationAndLogin() throws InterruptedException {

        driver.get(
                "https://parabank.parasoft.com/parabank/register.htm");

        ParaBankRegistrationPage registerPage =
                new ParaBankRegistrationPage(driver);

        ParaBankHomePage homePage =
                new ParaBankHomePage(driver);

        ParaBankLoginPage loginPage =
                new ParaBankLoginPage(driver);

        // Register user
        String username = registerPage.registerUser();

        System.out.println("Registered Username = " + username);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(5000);

        System.out.println("Registration Successful");

        // Logout
        homePage.logout();

        // Wait until login page appears
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.name("username")));

        // Login again
        loginPage.login(username, "Password123");

        // Wait for Accounts Overview page
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.titleContains("ParaBank"),
                        ExpectedConditions.presenceOfElementLocated(
                                org.openqa.selenium.By.linkText("Accounts Overview"))));

        System.out.println("Current URL = " + driver.getCurrentUrl());
        System.out.println("Page Title = " + driver.getTitle());

        boolean loginSuccess =
                driver.getPageSource().contains("Accounts Overview");

        System.out.println("Login Success = " + loginSuccess);

        Assert.assertTrue(
                loginSuccess,
                "Login failed - Accounts Overview not found");

        System.out.println("Login Successful");
    }
}