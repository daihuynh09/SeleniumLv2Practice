package com.selenium.testfw.driver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import com.selenium.testfw.common.*;

public abstract class AbstractDriverManager {
	
	protected WebDriver driver;
	private URL gridUrl;
	
	protected abstract void startService();
	protected abstract void stopService();
	protected abstract String createDriver();

	AbstractDriverManager() {
		try {
			gridUrl = new URL(Constant.HUB_SERVER);
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		}
	}

	URL getGridUrl() {
		return gridUrl;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			stopService();
			driver = null;
		}
	}
	
	public WebDriver getDriver() {
		if (driver == null) {
			startService();
			createDriver();
		}
		return driver;
	}
}
