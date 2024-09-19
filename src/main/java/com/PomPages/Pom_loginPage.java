package com.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_loginPage {

	public Pom_loginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='username']")
	private WebElement usn_edit;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pass_edit;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement login_btn;
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement logout_dropdown;
	
	public WebElement getLogout_dropdown() {
		return logout_dropdown;
	}

	public void setLogout_dropdown(WebElement logout_dropdown) {
		this.logout_dropdown = logout_dropdown;
	}
	
	@FindBy(xpath="(//a[contains(text(),'out')])[2]")
	private WebElement logout_btn;
	
	public WebElement getLogout_btn() {
		return logout_btn;
	}

	public void setLogout_btn(WebElement logout_btn) {
		this.logout_btn = logout_btn;
	}


	
	public WebElement getUsn() {
		return usn_edit;
	}

	public void setUsn(WebElement usn) {
		this.usn_edit = usn;
	}
//......................................................................
	public WebElement getPass() {
		return pass_edit;
	}

	public void setPass(WebElement pass) {
		this.pass_edit = pass;
	}
//......................................................................
	public WebElement getLogin_btn() {
		return login_btn;
	}

	public void setLogin_btn(WebElement login_btn) {
		this.login_btn = login_btn;
	}
//......................................................................
	
//......................................................................	
	
	//business logic implementation in pom page only
	
	
	  public void loginToApp(String userName,String Password) 
	  {
		 
	  usn_edit.sendKeys(userName); 
	  pass_edit.sendKeys(Password);
	  //login_btn.click(); 
	  }
	  
	 
}
