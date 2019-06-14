package com.selenium.test.tadashboard.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.selenium.test.tadashboard.pom.DataProfilesManagePage;
import com.selenium.test.tadashboard.pom.HomePage;
import com.selenium.test.tadashboard.pom.LoginPage;
import com.selenium.test.tadashboard.pom.PanelsManagePage;
import com.selenium.testfw.common.BasePage;
import com.selenium.testfw.common.Constant;
import com.selenium.testfw.common.LogWrapper;

public class NavigationHeaderMenu extends BasePage {
	
	protected static final Logger LOG = LogWrapper.createLogger(NavigationHeaderMenu.class.getName());
	
	private final String repoXpathFormat = "//ul[@id='ulListRepositories']/li/a[.='%s']";
	
	@FindBy(xpath = "//a[text()='Repository: ']/span")
	private WebElement txtRepoName;
	
	@FindBy(xpath = "//a[@href='#Welcome']")
	private WebElement lnkWelcome;
	
	@FindBy(xpath = "//a[contains(.,'Repository: ')]")
	private WebElement lnkRepository;
	
	public NavigationHeaderMenu(WebDriver driver) {
		super(driver);
	}

	public String getUserLogin() throws Exception {
		waitForDisplay(lnkWelcome, 20);
		return getText(lnkWelcome);
	}
	
	public String getRepoName() throws Exception {
		waitForDisplay(txtRepoName, 20);
		return getText(txtRepoName);		
	}
	
	public LoginPage logout() throws Exception {
		String userLogin = getUserLogin();
		String menuItem = userLogin + "->" + "Logout";
		selectMenuItem(menuItem, Constant.ELEMENT_TIMEOUT);
		return (LoginPage) GetInstance(LoginPage.class).waitForPageLoaded();
	} 
	
	public HomePage goToRepo(String repo) throws Exception {
		String xpathRepo = String.format(repoXpathFormat, repo);
		click(lnkRepository);
		click(waitForDisplay(By.xpath(xpathRepo), Constant.ELEMENT_TIMEOUT));
		return (HomePage) GetInstance(HomePage.class).waitForPageLoaded();
	}
	
	public DataProfilesManagePage goToDataProfile() throws Exception {
		
		//TO-DO...
		return (DataProfilesManagePage) GetInstance(DataProfilesManagePage.class).waitForPageLoaded();
	}
	
	public PanelsManagePage goToPanels() throws Exception {
		
		//TO-DO...
		return (PanelsManagePage) GetInstance(PanelsManagePage.class).waitForPageLoaded();
	}
	
}
