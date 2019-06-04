package com.oliulka.demoAPI;

import org.testng.annotations.BeforeTest;

public class DemoAPIAbstractTest {
	
	String Util ="Demo";
	
	@BeforeTest
	public String getAPIurl()
	{
		if(Util.contains("DEMO"))
		{
			String APIurl = "https://5clr97erg9.execute-api.us-east-1.amazonaws.com/DemoAPI/pets";
			return APIurl;
		}
		return null;
	}
}


