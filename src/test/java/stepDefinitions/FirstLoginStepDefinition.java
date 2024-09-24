package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PomPages.Pom_HomePage;
import com.PomPages.Pom_loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstLoginStepDefinition {
	// Pre-condition - Given
	// Actions - When
	// Validations - Then

	Pom_loginPage lp;
	Pom_HomePage hp;
	List<HashMap<String, String>> datamap; // Data-driven

	@Given("the user is on OrangeHrm Login Page")
	public void the_user_is_on_orange_hrm_login_page() {
		System.out.println("Yes user is on LoginPage");
		// You can add a check here to validate the login page is displayed
	}

	@When("^the user enters (.*) and (.*)$") // (.*) can accept any values
	// Ensure that the ^ (start) and $ (end) symbols are added
	public void the_user_enters_username_and_password(String username, String password) {
		lp = new Pom_loginPage(Generic_Utilities.BaseClass.getDriver());

		WebDriverWait wait = new WebDriverWait(Generic_Utilities.BaseClass.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lp.getUsn())).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(lp.getPass())).sendKeys(password);

		System.out.println("Entered username: " + username);
		System.out.println("Entered password: " + password);
	}

	@When("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		lp.getLogin_btn().click();

	}

	@Then("the user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		WebDriverWait wait = new WebDriverWait(Generic_Utilities.BaseClass.getDriver(), Duration.ofSeconds(10));

		WebElement header = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")));
		String dashboard_text = header.getText();

		System.out.println(dashboard_text);

		if (dashboard_text.equalsIgnoreCase("Dashboard")) {
			System.out.println(dashboard_text + " ******* Page is displayed **********");
		} else {
			System.out.println("Home page is not displayed");
		}
	}

	/*
	 * @Then("the user should be redirected to homepage") public void
	 * the_user_should_be_redirected_to_homepage() {
	 * 
	 * WebDriverWait wait = new
	 * WebDriverWait(Generic_Utilities.BaseClass.getDriver(),
	 * Duration.ofSeconds(10)); try {
	 * 
	 * WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
	 * By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")));
	 * String dashboard_text = header.getText(); System.out.println(dashboard_text);
	 * if (dashboard_text.equalsIgnoreCase("Dashboard")) {
	 * System.out.println(dashboard_text + " ******* Page is displayed **********");
	 * 
	 * } else { System.out.println("home page is not displayed"); } } catch
	 * (Exception e) { System.out.
	 * println("********Exception caught: home page is not displayed *******" +
	 * e.getMessage()); Assert.assertTrue(false);
	 * 
	 * } finally { WebDriver driver2 = Generic_Utilities.BaseClass.getDriver();
	 * 
	 * driver2.quit();
	 * System.out.println("********Browser Closed Sucessfully*********"); } }
	 */

	@Then("the user should be redirected to the Home Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_home_page_by_passing_email_and_password_with_excel_row(
			String rows) {
		try {
			datamap = Generic_Utilities.DataReader
					.data(System.getProperty("user.dir") + "\\testData\\OrangeHRM_Login_TestData.xlsx", "Sheet1");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int index = Integer.parseInt(rows) - 1;
		String usn = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");

		lp = new Pom_loginPage(Generic_Utilities.BaseClass.getDriver());
		lp.loginToApp(usn, pwd);

		lp.getLogin_btn().click();

		hp = new Pom_HomePage(Generic_Utilities.BaseClass.getDriver());
		try {
			boolean targetpage = hp.getDashboard().isDisplayed();
			System.out.println("target page: " + targetpage);

			if (exp_res.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					hp = new Pom_HomePage(Generic_Utilities.BaseClass.getDriver());
					hp.getProfile_drpdown().click();
					hp.getProfile_logout().click();

					Assert.assertTrue(true);
					// Assert.assertTrue(false); // to capture the screenshot
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp_res.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					hp.getProfile_logout().click();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {

			Assert.assertTrue(false);
		}

	}

}
