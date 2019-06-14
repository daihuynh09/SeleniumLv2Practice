package com.selenium.test.tadashboard.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.selenium.testfw.common.*;

public class LoginPage extends BasePage {
	
	Select cbRepo = new Select(driver.findElement(By.id("repository")));

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//div[@class='btn-login']")
	private WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String username, String password, String repo) {
		selectByValue(cbRepo, repo);
		enter(txtUsername, username);
		enter(txtPassword, password);
		click(btnLogin);
	}

	public HomePage loginValid(String username, String password, String repo) throws Exception {
		login(username, password, repo);
		HomePage homePage = (HomePage) GetInstance(HomePage.class).waitForPageLoaded();
		homePage.waitForIconLoadingNotDisplay(Constant.ELEMENT_TIMEOUT);
		return homePage;
	}

	public LoginPage loginInValid(String username, String password, String repo) throws Exception {
		login(username, password, repo);
		return this;
	}

	public void checkAlertMessage(String message, int timeOutInSeconds) {
		Assert.assertEquals(getAlertMessage(timeOutInSeconds), message);
	}

	public boolean isAt(int timeOutInSeconds) {
		return doesElementExist(btnLogin, timeOutInSeconds);
	}
}
