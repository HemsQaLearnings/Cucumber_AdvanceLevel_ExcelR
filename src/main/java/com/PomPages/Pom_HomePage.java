package com.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_HomePage {

		public Pom_HomePage(WebDriver driver)
		{
			
			PageFactory.initElements(driver, this);
		}
		//fetch----Dashboard and verify in homepage
		@FindBy(xpath="//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
		private WebElement dashboard;
		
		public WebElement getDashboard() {
			return dashboard;
		}

		public void setDashboard(WebElement dashboard) {
			this.dashboard = dashboard;
		}
		//-------------------click on pim major Tab
		@FindBy(xpath="//ul[@class='oxd-main-menu']/li[2]/a")
		private WebElement pim;
		
		public WebElement getPim() {
			return pim;
		}

		public void setPim(WebElement pim) {
			this.pim = pim;
		}
	//-------------------click on addEmployee

		@FindBy(xpath="//a[text()='Add Employee']")
		private WebElement addEmployee;
		
		public WebElement getAddEmployee() {
			return addEmployee;
		}
		
		public void setAddEmployee(WebElement addEmployee) {
			this.addEmployee = addEmployee;
		}
	//-------------------add firstname
		
		@FindBy(xpath="//input[@placeholder='First Name']")
		private WebElement firstName;
		
		public WebElement getFirstName() {
			return firstName;
		}

		public void setFirstName(WebElement firstName) {
			this.firstName = firstName;
		}

	//-------------------add MiddleName
		@FindBy(xpath="//input[@placeholder='Middle Name']")
		private WebElement middleName;
		
		public WebElement getMiddleName() {
			return middleName;
		}

		public void setMiddleName(WebElement middleName) {
			this.middleName = middleName;
		}

	//-------------------add lastName
		
		@FindBy(xpath="//input[@placeholder='Last Name']")
		private WebElement lastName;
		
		public WebElement getLastName() {
			return lastName;
		}

		public void setLastName(WebElement lastName) {
			this.lastName = lastName;
		}

	//-------------click on employee id
		@FindBy(xpath=("(//input[@class='oxd-input oxd-input--active'])[2]"))
		private WebElement emp_id;
		
		public WebElement getEmp_id() {
			return emp_id;
		}

		public void setEmp_id(WebElement emp_id) {
			this.emp_id = emp_id;
		}
		
	//-------------------click on save_btn

		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement save_btn;
		
		public WebElement getSave_btn() {
			return save_btn;
		}



		public void setSave_btn(WebElement save_btn) {
			this.save_btn = save_btn;
		}

	//-------------------click on save_btn

		//--------------employee list page will open
		
			@FindBy(xpath="//button[@type='submit']")
			private WebElement save_Required_btn;
			
		public WebElement getSave_Required_btn() {
			return save_Required_btn;
		}

		public void setSave_Required_btn(WebElement save_Required_btn) {
			this.save_Required_btn = save_Required_btn;
		}

	//-------------------click on pim major Tab

		@FindBy(xpath="//ul[@class='oxd-main-menu']/li[2]/a")
		private WebElement getPim2;
		
		public WebElement getGetPim2() {
			return getPim2;
		}

		public void setGetPim2(WebElement getPim2) {
			this.getPim2 = getPim2;
		}

	//-------------------click on employeeList major Tab

		
		@FindBy(xpath="//div[@class='oxd-topbar-body']/descendant::a[1]")
		private WebElement employeeList;
		
		public WebElement getEmployeeList() {
			return employeeList;
		}

		public void setEmployeeList(WebElement employeeList) {
			this.employeeList = employeeList;
		}

	//-------------------click on employeeNameSearch
		
		@FindBy(xpath="//form[@class='oxd-form']/descendant::input[1]")
		private WebElement employeeNameSearch;
		
		public WebElement getEmployeeNameSearch() {
			return employeeNameSearch;
		}

		public void setEmployeeNameSearch(WebElement employeeNameSearch) {
			this.employeeNameSearch = employeeNameSearch;
		}

	//-----click on button type = search

		//check add empolyee is present in the list of emp record
		
	//verification of employee name present in the list or not
		@FindBy(xpath="//div[@role='rowgroup']//div[1]//div[1]//div[3]")
		private WebElement verifyEmpName;
		
		
		public WebElement getVerifyEmpName() {
			return verifyEmpName;
		}

		public void setVerifyEmpName(WebElement verifyEmpName) {
			this.verifyEmpName = verifyEmpName;
		}
//--------------click on profile
		@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
		private WebElement profile_drpdown;
		
		public WebElement getProfile_drpdown() {
			return profile_drpdown;
		}

		public void setProfile_drpdown(WebElement profile_drpdown) {
			this.profile_drpdown = profile_drpdown;
		}

		@FindBy(xpath="//a[normalize-space()='Logout']")
		private WebElement profile_logout;
		
		public WebElement getProfile_logout() {
			return profile_logout;
		}

		public void setProfile_logout(WebElement profile_logout) {
			this.profile_logout = profile_logout;
		}
	
		
		//>>>>>>>>>>>>>>business logic implimentation<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		public void OragneHrm_HomePageTask(String fname,String mname,String lname,String empid) throws InterruptedException
		{
			//dashboard
			//pim.click(); //step 1: click on pim majortab
		//	addEmployee.click();
			firstName.sendKeys(fname);
			middleName.sendKeys(mname);
			lastName.sendKeys(lname);
			emp_id.sendKeys(empid);
			save_btn.click();
			Thread.sleep(3000);
			//save_btn.click();
		}
		public void OrangeHrm_HomePageTask2(String searchName)
		{
			//pim.click(); //step 1: click on pim majortab
			//employeeList.click();
			employeeNameSearch.sendKeys(searchName);
			//save_btn.click();
			//String verifyEmpText = verifyEmpName.getText();
			//System.out.println(verifyEmpText);
		}


}
