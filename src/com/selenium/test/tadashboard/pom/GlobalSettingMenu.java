package com.selenium.test.tadashboard.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.testfw.common.BasePage;
import com.selenium.testfw.common.Constant;

public class GlobalSettingMenu extends BasePage {

	private final String menuItemFormat = "//li[@class='mn-setting']//a[.='%s']";
	
	@FindBy(xpath = "//li[@class='mn-setting']")
	private WebElement iconGlobalSetting;
	
	public GlobalSettingMenu(WebDriver driver) {
		super(driver);
	}

	/**
	 * Select global menu item on page
	 * 
	 * @param menuItem Menu item with format: node1->node2->...->nodeN
	 * @param timeOutInSeconds Time out (seconds)
	 * @throws Exception
	 */
	private void selectGlobalMenuItem(String item, int timeOutInSeconds) throws Exception {	
		String itemXpath = String.format(menuItemFormat, item);
		By itemLocator = By.xpath(itemXpath);
		click(iconGlobalSetting);
		waitForDisplay(itemLocator, timeOutInSeconds);
		click(itemLocator);
	}
	
	public DashboardPage goToAddPage() throws Exception {
		selectGlobalMenuItem("Add Page", Constant.ELEMENT_TIMEOUT);
		return (DashboardPage) GetInstance(DashboardPage.class).waitForPageLoaded();
	}
	
	public PanelPage goToCreatePanel() throws Exception {
		selectGlobalMenuItem("Create Panel", Constant.ELEMENT_TIMEOUT);
		return (PanelPage) GetInstance(PanelPage.class).waitForPageLoaded();
	}
	
	public ProfilePage goToCreateProfile() throws Exception {
		selectGlobalMenuItem("Create Profile", Constant.ELEMENT_TIMEOUT);
		return (ProfilePage) GetInstance(ProfilePage.class).waitForPageLoaded();
	}
}
