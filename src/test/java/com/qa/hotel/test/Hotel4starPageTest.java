
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
import com.qa.hotel.pages.Hotel4starPage;
import com.qa.hotel.util.AppConstant;

public class Hotel4starPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DestinationPage destinationPage;
	Hotel3starPage hotel3starPage;
	Hotel4starPage hotel4starPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		destinationPage = new DestinationPage(driver);
		hotel3starPage = destinationPage.put_info();
		hotel4starPage = hotel3starPage.switchPage();

	}

	@Test(priority = 1, description = 
			"This test shows verification title of the page")
	public void verifyPageTitleTest() throws InterruptedException {

		String title = hotel4starPage.getHotel4starPageTitle();
		System.out.println("Hotel 4-star page title is" + title);
		Assert.assertEquals(title, AppConstant.HOTEL4STAR_PAGE_TITLE);

	}

	@Test(priority = 2, description = 
 "This test searches for 4 star hotels with distance less then 10 miles from city center")

	public void ShowHotleList() throws InterruptedException {

		hotel4starPage.chose4starHotel();

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
