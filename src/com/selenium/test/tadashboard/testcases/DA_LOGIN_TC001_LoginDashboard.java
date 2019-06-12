package com.selenium.test.tadashboard.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.selenium.testfw.common.*;
import com.selenium.test.tadashboard.pom.*;


public class DA_LOGIN_TC001_LoginDashboard extends BaseTest {

	protected static final Logger LOG = LogWrapper.createLogger(DA_LOGIN_TC001_LoginDashboard.class.getName());

	private String invalidUser = "abc";
	private String invalidPass = "123";

	@Test(description = "Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
	public void Valid_Login() throws Exception {

		LOG.info("Login with valid credential");
		LoginPage loginPage = page.GetInstance(LoginPage.class);
		HomePage homePage = loginPage.loginValid(Constant.USERNAME, Constant.PASSWORD, Constant.REPO);

		LOG.info("Verify: Repo display correctly");
		homePage.checkRepoDisplay(Constant.REPO);

		LOG.info("Verify: Login User display correctly");
		homePage.checkLoginUserDisplay(Constant.USERNAME);
	}

	@Test(description = "Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
	public void Login_Invalid_Credential() throws Exception {

		LOG.info("Login with invalid credential");
		LoginPage loginPage = page.GetInstance(LoginPage.class).loginInValid(invalidUser, invalidPass, Constant.REPO);

		LOG.info("Verify: 'Username or password is invalid' message displays in alert");
		loginPage.checkAlertMessage("Username or password is invalid", 20);

	}
	
	@Test(description = "Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password")
	public void Login_CorrectUsername_InvalidPassword() throws Exception {
		
		LOG.info("Login with correct username and invalid password");
		LoginPage loginPage = page.GetInstance(LoginPage.class).loginInValid(Constant.USERNAME, invalidPass, Constant.REPO);
		
		LOG.info("Verify: 'Username or password is invalid' message displays in alert");
		loginPage.checkAlertMessage("Username or password is invalid", 20);
	}
	
	@Test(description = "Verify that user is able to log in different repositories successfully after logging out current repository")
	public void Login_Different_Repo_Successfully() throws Exception {
		
		LOG.info("Login with valid credential");
		LoginPage loginPage = page.GetInstance(LoginPage.class);
		HomePage homePage = loginPage.loginValid(Constant.USERNAME, Constant.PASSWORD, Constant.REPO);
		
		LOG.info("Log out");
		loginPage = homePage.logout();
	
		LOG.info("Verify: User is navigated to Login page");
		Assert.assertTrue(loginPage.isAt(Constant.ELEMENT_TIMEOUT));
	}
}
