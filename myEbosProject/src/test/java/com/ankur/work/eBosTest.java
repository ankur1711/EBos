package com.ankur.work;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class eBosTest {


//AndroidDriver dr;
//ChromeDriver driver;

public void testapp	() throws MalformedInputException, InterruptedException, MalformedURLException {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName", "XT1254");
	//capabilities.setCapability("platformVersion", "5.1");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("app", "Chrome");
	
	
	//@SuppressWarnings("unused")
	//WebDriver driver = new RemoteWebDriver();
	WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	driver.get("https://qa.ebos.qsrsoft.com");
	WebElement UserIcon = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".user-settings-icon")));
	UserIcon.click();
	WebElement UserId = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='ebos_login'][data-eid='e100001']")));
	UserId.click();
	//WebElement StoreNumber = driver.findElement(By.xpath(".//*[@id='store-locations-dropdown']/li[11]/a"));
	//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	//WebElement StoreIcon = driver.findElement(By.xpath(".//*[@id='locations']/a/i"));
	WebElement StoreIcon = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='locations']")));
	StoreIcon.click();
	
	//WebElement StoreNumber = driver.findElement(By.cssSelector("#store-locations-dropdown>li:nth-child(11)"));
	WebElement StoreNumber = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#store-locations-dropdown>li:nth-child(11)")));
	StoreNumber.click();
	

	//WebElement HamburgerIcon = driver.findElement(By.cssSelector("#menu-icon"));
	WebElement HamburgerIcon = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='menu-icon']")));
	HamburgerIcon.click();
	
	WebElement CashMgmtButton = (new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav-list']/ul/li[2]/a")));
	
	CashMgmtButton.click();

	WebElement SkimsButton = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[onclick='nav_menu(5);'][href='#']")));
	SkimsButton.click();
	
	WebElement SkimsTitle = (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ebos_page_title']")));
	String TestOutput = SkimsTitle.getText();
	System.out.println(TestOutput);
	
	
	driver.quit();
	/*
	dr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	for (int i=0; i<100; i++)
	{
	WebElement testBox = dr.findElement(By.id("com.whatsapp:id/entry"));
	testBox.sendKeys("Hi");
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement Enterbox = dr.findElement(By.id("com.whatsapp:id/send"));
	Enterbox.click();

	}*/
	driver.quit();
}
}
	
