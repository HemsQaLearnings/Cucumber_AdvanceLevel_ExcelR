package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PomPages.Pom_HomePage;
import com.PomPages.Pom_loginPage;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTable_Login_StepDefinition{
	Pom_loginPage plogin;
	Pom_HomePage hp;
	// Pre-condition - Given
	// Actions - When
	// Validations - Then
	public WebDriver driver;
	@Given("the user should be in homepage")
	public void the_user_should_be_in_homepage() throws InterruptedException, IOException {
		// implement the method with selenium java test script

		Generic_Utilities.BaseClass.getLogger().info("Goto my account-->Click on Login.. ");

		plogin = new Pom_loginPage(Generic_Utilities.BaseClass.getDriver());
		String username = Generic_Utilities.BaseClass.getProperties().getProperty("email");
		String password = Generic_Utilities.BaseClass.getProperties().getProperty("password");

		plogin.loginToApp(username, password);
		plogin.getLogin_btn().click();

	}

	@When("the user click on pim module button")
	public void the_user_click_on_pim_module_button() throws InterruptedException {
		
		Generic_Utilities.BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		
		hp=new Pom_HomePage(Generic_Utilities.BaseClass.getDriver());
		hp.getPim().click();
		
	}

	@When("the user click on add employee button")
	public void the_user_click_on_add_employee_button() throws InterruptedException {
	
		hp.getAddEmployee().click();

	}

	@When("enter all the required fields")
	public void enter_all_the_required_fields(DataTable dataTable) throws InterruptedException {
		Generic_Utilities.BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		// fn
		hp.getFirstName().sendKeys(dataMap.get("FirtName"));

		// mn
		hp.getMiddleName().sendKeys(dataMap.get("MiddleName"));
		// ln
		hp.getLastName().sendKeys(dataMap.get("lastName"));
		// empid
		hp.getEmp_id().clear();
		Thread.sleep(2000);
		hp.getEmp_id().sendKeys(dataMap.get("Employeeid"));
	
	}

	@Then("click on save button")
	public void click_on_save_button() throws InterruptedException {
		  Generic_Utilities.BaseClass.getLogger().info("Clicking on Save button");

	        hp.getSave_btn().click();
	        Thread.sleep(4000);


	}
}
