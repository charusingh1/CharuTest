
package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.DealerPortalPage;

public class VehicleSearchStepDefs {

	WebDriver driver;
	DealerPortalPage dealerPortalPage;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void afterScenario() {
		driver.quit();
	}

	@Given("^User visits covercheck\\.vwfsinsuranceportal page$")
	public void user_visits_covercheck_vwfsinsuranceportal_page() throws Throwable {
		dealerPortalPage = new DealerPortalPage(driver);
		dealerPortalPage.navigate();	    
	}

	@When("^the user enter valid vehicle registration number into the search bar \"([^\"]*)\"$")
	public void the_user_enter_valid_vehicle_registration_number_into_the_search_bar(String vehicleRegistrationNumber) throws Throwable {
	    dealerPortalPage.enterVehicleRegistration(vehicleRegistrationNumber);
	}

	@When("^click on find vehicle button$")
	public void click_on_find_vehicle_button() throws Throwable {
	   dealerPortalPage.clickFindVehicle();
	}

	@Then("^correct vehicle information is displayed on the page \"([^\"]*)\"$")
	public void correct_vehicle_information_is_displayed_on_the_page(String vehicleRegistrationNumber) throws Throwable {
		Assert.assertTrue(dealerPortalPage.isValidVehicleRecordFoundMsgPresent(vehicleRegistrationNumber));
	}

	@When("^the user enter invalid vehicle registration number into the search bar \"([^\"]*)\"$")
	public void the_user_enter_invalid_vehicle_registration_number_into_the_search_bar(String vehicleRegistrationNumber) throws Throwable {
	    dealerPortalPage.enterVehicleRegistration(vehicleRegistrationNumber);
	}

	@Then("^page displays message ‘Sorry record not found’$")
	public void page_displays_message_Sorry_record_not_found() throws Throwable {
		Assert.assertTrue(dealerPortalPage.isNoRecordFoundMsgPresent());
	}

	@Then("^page displays ‘Please enter a valid car registration’$")
	public void page_displays_Please_enter_a_valid_car_registration() throws Throwable {
	    Assert.assertTrue(dealerPortalPage.isBlankRegistrationErrorPresent());
	}
}
