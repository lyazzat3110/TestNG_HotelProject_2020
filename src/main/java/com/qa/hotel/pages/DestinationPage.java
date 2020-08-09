package com.qa.hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.hotel.base.BasePage;
import com.qa.hotel.util.ElementUtil;

public class DestinationPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By destination = By.id("qf-0q-destination");
	By boston = By.id("recommendedsqm-asi0-s1");
	By closeLocPage = By.xpath("//button[text()='close']");
	By checkInDate = By.id("qf-0q-localised-check-in");
	By checkOutDate = By.id("qf-0q-localised-check-out");
	By buttonSearch = By.xpath("//button[@type='submit']");
	By clickPage = By.className("container-queryform col-12 col-l4 mv-bird");

	public DestinationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getDestinationPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public Hotel3starPage put_info() {

		elementUtil.waitForElementPresent(destination);
		elementUtil.doClick(destination);
		elementUtil.doSendKeys(destination, "Boston, Massachusetts, United States of America");
		elementUtil.waitForElementPresent(closeLocPage);
		elementUtil.doClick(closeLocPage);
		elementUtil.waitForElementPresent(checkInDate);
		elementUtil.doClick(checkInDate);
		elementUtil.doSendKeys(checkInDate, " 09/01/20");
		elementUtil.waitForElementPresent(checkOutDate);
		elementUtil.doClick(checkOutDate);
		elementUtil.doSendKeys(checkOutDate, " 09/05/20");

		WebElement room = driver.findElement(By.id("qf-0q-rooms"));
		Select select1 = new Select(room);
		select1.selectByValue("1");

		WebElement adults = driver.findElement(By.id("qf-0q-room-0-adults"));
		Select select2 = new Select(adults);
		select2.selectByValue("2");

		WebElement children = driver.findElement(By.id("qf-0q-room-0-children"));
		Select select3 = new Select(children);
		select3.selectByValue("2");

		WebElement childAge1 = driver.findElement(By.id("qf-0q-room-0-child-0-age"));
		Select select4 = new Select(childAge1);
		select4.selectByValue("4");

		WebElement childAge2 = driver.findElement(By.id("qf-0q-room-0-child-1-age"));
		Select select5 = new Select(childAge2);
		select5.selectByValue("9");

		elementUtil.waitForElementPresent(buttonSearch);

		elementUtil.doClick(buttonSearch);

		return new Hotel3starPage(driver);
	}

}
