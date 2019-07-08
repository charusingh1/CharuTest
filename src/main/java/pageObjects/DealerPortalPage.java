package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DealerPortalPage {

	WebDriver driver;
	String homePageUrl = "https://covercheck.vwfsinsuranceportal.co.uk/";
	By findVehicle = By.name("btnfind");
	By vehicleRegistration = By.id("vehicleReg");	
	String validVehicleRecordForRegistrationNumber = "//div[@class='result'][contains(text(),'%s')]";
	By noRecordFoundForRegistrationNumber = By.xpath("//div[@class='result'][contains(text(),'Sorry record not found')]");	
	By blankRegistrationNumberError = By.xpath("//div[@class='error-required'][contains(text(),'Please enter a valid car registration')]");

	public DealerPortalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate() {
		driver.get(homePageUrl);
	}

	public void enterVehicleRegistration(String vehicleRegistrationNumber) {
		driver.findElement(vehicleRegistration).sendKeys(vehicleRegistrationNumber);
	}

	public void clickFindVehicle() {
		driver.findElement(findVehicle).click();
	}
	
	public boolean isBlankRegistrationErrorPresent() {
		WebElement e = driver.findElement(blankRegistrationNumberError);
		return e.isDisplayed();
	}
	
	public boolean isValidVehicleRecordFoundMsgPresent(String vehicleRegistrationNumber) {
		String resultMsg = "Result for : " + vehicleRegistrationNumber;
		By searchedRecordXPath = By.xpath(String.format(validVehicleRecordForRegistrationNumber, resultMsg));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement e = driver.findElement(searchedRecordXPath);
		return e.isDisplayed();
	}	

	public boolean isNoRecordFoundMsgPresent() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement e = driver.findElement(noRecordFoundForRegistrationNumber);
		return e.isDisplayed();
	}
}