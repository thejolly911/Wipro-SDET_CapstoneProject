package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.BlazeDemoHomePage;
import pages.BlazeDemoFlightPage;
import pages.BlazeDemoPurchasePage;
import pages.BlazeDemoConfirmationPage;

public class BlazeDemoTest extends BaseTest {

    @Test
    public void verifyFlightBooking() throws InterruptedException {

        driver.get("https://blazedemo.com");

        BlazeDemoHomePage homePage =
                new BlazeDemoHomePage(driver);

        BlazeDemoFlightPage flightPage =
                new BlazeDemoFlightPage(driver);

        BlazeDemoPurchasePage purchasePage =
                new BlazeDemoPurchasePage(driver);

        BlazeDemoConfirmationPage confirmationPage =
                new BlazeDemoConfirmationPage(driver);

        homePage.selectDepartureCity();
        Thread.sleep(2000);

        homePage.selectDestinationCity();
        Thread.sleep(2000);

        homePage.clickFindFlights();
        Thread.sleep(2000);

        flightPage.chooseFlight();
        Thread.sleep(2000);

        purchasePage.enterPassengerDetails();
        Thread.sleep(2000);

        purchasePage.purchaseFlight();
        Thread.sleep(2000);

        confirmationPage.verifyBookingSuccess();
        Thread.sleep(3000);
    }
}