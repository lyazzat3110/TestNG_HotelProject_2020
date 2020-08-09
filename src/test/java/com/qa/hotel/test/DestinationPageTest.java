package com.qa.hotel.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotel.base.BasePage;
import com.qa.hotel.pages.DestinationPage;
import com.qa.hotel.util.AppConstant;

public class DestinationPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DestinationPage destinationPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		destinationPage = new DestinationPage(driver);

	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {

		String title = destinationPage.getDestinationPageTitle();
		System.out.println("destination page title is" + title);
		Assert.assertEquals(title, AppConstant.DESTINATION_PAGE_TITLE);

	}

	@Test(priority = 2)

	public void Get_Information() throws InterruptedException {

		destinationPage.put_info();

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
