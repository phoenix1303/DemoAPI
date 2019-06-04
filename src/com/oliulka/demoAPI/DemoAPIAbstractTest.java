package com.oliulka.demoAPI;

import org.testng.annotations.BeforeTest;

public class DemoAPIAbstractTest {
	
	public static String APIurl = null;
	String Util ="DEMO";
	
	@BeforeTest
	public String getAPIurl()
	{
		if(Util.contains("DEMO"))
		{
			APIurl = "https://5clr97erg9.execute-api.us-east-1.amazonaws.com/DemoAPI/pets";
			return APIurl;
		}
		return null;
	}
}


