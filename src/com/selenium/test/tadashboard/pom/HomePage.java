package com.selenium.test.tadashboard.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.selenium.testfw.common.*;

public class HomePage extends BasePage {
	
	private final String repoXpathFormat = "//ul[@id='ulListRepositories']/li/a[.='%s']";

	By imgIconLoading = By.xpath("//img[@src='images/loading.gif']");
	
	@FindBy(xpath = "//a[text()='Repository: ']/span")
	private WebElement txtRepoName;
	
	@FindBy(xpath = "//a[@href='#Welcome']")
	private WebElement lnkWelcome;
	
	@FindBy(xpath = "//a[contains(.,'Repository: ')]")
	private WebElement lnkRepository;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getRepoName() throws Exception {
		waitForDisplay(txtRepoName, 20);
		return getText(txtRepoName);		
	}
	
	public void checkRepoDisplay(String repoName) throws Exception {
		Assert.assertEquals(getRepoName(), repoName, "Repo is incorrect");
	}
	
	public String getUserLogin() throws Exception {
		waitForDisplay(lnkWelcome, 20);
		return getText(lnkWelcome);
	}
	
	public void checkLoginUserDisplay(String userName) throws Exception {
		Assert.assertEquals(getUserLogin(), userName);
	}
	
	public void waitForHomePageReady(int timeOutInSeconds) throws Exception {
		waitForAllInvisibility(imgIconLoading, timeOutInSeconds);
	}
	
	public LoginPage logout() throws Exception {
		String userLogin = getUserLogin();
		String menuItem = userLogin + "->" + "Logout";
		selectMenuItem(menuItem, Constant.ELEMENT_TIMEOUT);
		return (LoginPage) GetInstance(LoginPage.class).waitForPageLoaded();
	}
	
	public HomePage selectRepo(String repo) throws Exception {
		String xpathRepo = String.format(repoXpathFormat, repo);
		click(lnkRepository);
		click(waitForDisplay(By.xpath(xpathRepo), Constant.ELEMENT_TIMEOUT));
		waitForHomePageReady(Constant.ELEMENT_TIMEOUT + 60);
		return this;
	}
}
