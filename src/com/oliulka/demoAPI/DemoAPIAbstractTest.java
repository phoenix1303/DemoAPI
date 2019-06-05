package com.oliulka.demoAPI;

import org.testng.annotations.BeforeTest;

public class DemoAPIAbstractTest {
	
	public static String APIurl = null;
	
	@BeforeTest
	public String getAPIurl()
	{
		APIurl = "https://5clr97erg9.execute-api.us-east-1.amazonaws.com/DemoAPI/pets";
		return APIurl;
	}
}


