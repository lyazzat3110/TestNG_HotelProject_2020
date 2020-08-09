package com.qa.hotel.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.hotel.base.BasePage;
import com.qa.hotel.util.ElementUtil;

public class Hotel3starPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	By box3star = By.id("f-star-rating-3");
	By lists = By.xpath("//a[@class='property-name-link']");
	By distance = By.xpath("//a[text()='Distance']");
	By landmark = By.xpath("//a[contains(text(),'City center')]");
	By listOfHotels = By.xpath("//a[@class='property-name-link']");
	By tenMiles = By.xpath("//ul[@class='property-landmarks']");
	

	public Hotel3starPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHotelVerifyPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public void showChosenHotels() throws InterruptedException {
		elementUtil.waitForElementPresent(box3star);
		elementUtil.doClick(box3star);
		elementUtil.doClick(distance);
		elementUtil.waitForElementPresent(landmark);
		elementUtil.doClick(landmark);

		List<WebElement> hotelList = driver.findElements(listOfHotels);
		  System.out.println(hotelList.size());
		List<WebElement> miles = driver.findElements(tenMiles);

		for (int i = 0; i < hotelList.size(); i++) {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)", "");
			
		
		
			String text = miles.get(i).getText();
			String hotelMiles = text.substring(0, 3);
			double radius = Double.parseDouble(hotelMiles);
           
			if (radius < 10) {
				System.out.println("3 start hotel is " + hotelList.get(i).getText() + " " + radius);
			}
		}
	}

	public void verifyHilton() throws InterruptedException {

		List<WebElement> listofHotels = driver.findElements(lists);

		for (int i = 0; i < listofHotels.size(); i++) {

			String nameOfHotel = listofHotels.get(i).getText();

			if (nameOfHotel.contains("Hilton")) {
				System.out.println("There is Hilton in the list");
			} else {
				System.out.println("There is no Hilton");
			}

		}

	}

	public Hotel4starPage switchPage() {

		return new Hotel4starPage(driver);
	}

}
