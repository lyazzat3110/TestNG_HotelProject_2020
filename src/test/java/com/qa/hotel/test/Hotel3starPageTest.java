package com.qa.hotel.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotel.base.BasePage;
import com.qa.hotel.pages.DestinationPage;
import com.qa.hotel.pages.Hotel3starPage;
import com.qa.hotel.util.AppConstant;

public class Hotel3starPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DestinationPage destinationPage;
	Hotel3starPage hotel3starPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		destinationPage = new DestinationPage(driver);
		hotel3starPage = destinationPage.put_info();

	}

	@Test(priority = 1, description = "This test shows verification title of the page")
	public void verifyPageTitleTest() {

		String title = destinationPage.getDestinationPageTitle();
		System.out.println("HotelVerify page title is" + title);
		Assert.assertEquals(title, AppConstant.HOTEL3STAR_PAGE_TITLE);

	}

	@Test(priority = 2, description = 
	"This test searches for 3 star hotels with distance less then 10 miles from city center")

	public void ShowHotelList() throws InterruptedException {

		hotel3starPage.showChosenHotels();

	}

	@Test(priority = 3, description = 
			"This test verifies Hilton hotels in 3 star list of hotel")
	public void verifyNameOfHotel() throws InterruptedException {

		hotel3starPage.verifyHilton();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
