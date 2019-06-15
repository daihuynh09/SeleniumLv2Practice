package com.selenium.testfw.common;

public class Constant {
	
	//******************************** SERVER **********************************************
	public static final String HUB_SERVER = "http://192.168.172.246:4445/wd/hub";
	
	//******************************** PROJECT *********************************************
	public static final String TA_DASHBOARD_URL = "http://192.168.172.246:80/TADashboard";
	public static final String REPO = "SampleRepository";
	public static final String USERNAME = "administrator";
	public static final String PASSWORD = "";
	
	//******************************** CONFIG FILE *****************************************
	public static final String CONFIG_FILE_LOG = "config/log4j.properties";
	
	//******************************* TIMEOUT DEFAULT **************************************
	public static final int PAGE_LOAD_TMEOUT = 180;
	public static final int ELEMENT_TIMEOUT = 120;
	public static final int DRIVER_TIMEOUT = 180;
	
}
