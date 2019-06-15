package com.selenium.test.tadashboard.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.selenium.testfw.common.*;

public class HomePage extends BasePage {
	
	// Elements
	private final By imgIconLoading = By.xpath("//img[@src='images/loading.gif']");
	
	// Page Components
	private final NavigationHeaderMenu navigationHeaderMenu;
	
	
	public HomePage(WebDriver driver) throws Exception {
		super(driver);
		navigationHeaderMenu = GetInstance(NavigationHeaderMenu.class);
	}

	public NavigationHeaderMenu navigationMenu() {
		return navigationHeaderMenu;
	}
	
	public void checkRepoDisplay(String repoName) throws Exception {
		Assert.assertEquals(navigationMenu().getRepoName(), repoName, "Repo is incorrect");
	}
	
	public void checkLoginUserDisplay(String userName) throws Exception {
		Assert.assertEquals(navigationMenu().getUserLogin(), userName);
	}
	
	public void waitForIconLoadingNotDisplay(int timeOutInSeconds) throws Exception {
		waitForAllInvisibility(imgIconLoading, timeOutInSeconds);
	}
	
	
}
