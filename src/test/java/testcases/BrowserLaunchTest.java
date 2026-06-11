package testcases;

import org.testng.annotations.Test;

import base.BaseTest;

public class BrowserLaunchTest extends BaseTest {

    @Test
    public void launchBrowser() {

        driver.get("https://testautomationpractice.blogspot.com");

        System.out.println(driver.getTitle());
    }
}