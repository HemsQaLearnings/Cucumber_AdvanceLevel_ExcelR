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

	List<HashMap<String, String>> datamap; // Data driven

	@Given("the user is on OrangeHrm Login Page")
	public void the_user_is_on_orange_hrm_login_page() throws InterruptedException {

		Generic_Utilities.BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		System.out.println("Yes user is on LoginPage");
	}

	@When("^the user enters (.*) and (.*)$") // (.*) it can accept any values if we specify dot star
	// make sure ^ cap sysmbol and $ sysmbol is added
	public void the_user_enters_username_and_password(String username, String password) throws InterruptedException {
		// Enter username
		lp = new Pom_loginPage(Generic_Utilities.BaseClass.getDriver());
		Thread.sleep(2000);
		lp.getUsn().sendKeys(username);
		Thread.sleep(2000);
		// Enter password
		lp.getPass().sendKeys(password);
		Thread.sleep(1000);
	}

	@When("the user clicks on login button")
	public void the_user_clicks_on_login_button() throws InterruptedException {
		lp.getLogin_btn().click();
		Thread.sleep(2000);

	}

	@Then("the user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {

		WebDriverWait wait = new WebDriverWait(Generic_Utilities.BaseClass.getDriver(), Duration.ofSeconds(10));
		try {

			WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")));
			String dashboard_text = header.getText();
			System.out.println(dashboard_text);
			if (dashboard_text.equalsIgnoreCase("Dashboard")) {
				System.out.println(dashboard_text + " page is displayed");

			} else {
				System.out.println("home page is not displayed");
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
			System.out.println("Exception caught: home page is not displayed " + e.getMessage());

		} finally {
			WebDriver driver2 = Generic_Utilities.BaseClass.getDriver();

			driver2.quit();
		}
	}

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
					//Assert.assertTrue(false); // to capture the screenshot
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
