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
import com.qa.hotel.pages.Hotel5starPage;
import com.qa.hotel.util.AppConstant;

public class Hotel5StarPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DestinationPage destinationPage;
	Hotel3starPage hotel3starPage;
	Hotel4starPage hotel4starPage;
	Hotel5starPage hotel5starsPage;

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
		hotel5starsPage = hotel4starPage.switchPage();

	}

	@Test(priority = 1, description = "This test shows verification title of the page")
	public void verifyPageTitleTest() {

		String title = hotel5starsPage.getHotel5starsPageTitle();
		System.out.println("Hotel 5-star page title is" + title);
		Assert.assertEquals(title, AppConstant.HOTEL5STAR_SHEET_TITLE);

	}

	@Test(priority = 2, description = 
	"This test searches for 5 star hotels with distance less then 10 miles from city center")

	public void Get_Information() throws InterruptedException {

		hotel5starsPage.show5starHotelList();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
