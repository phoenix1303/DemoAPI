package com.oliulka.demoAPI.flows;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.given;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;

import com.jayway.restassured.response.Response;
import com.oliulka.demoAPI.DemoAPIAbstractTest;

public class Flow01PetStore //extends DemoAPIAbstractTest
{
	final static Logger logger = Logger.getLogger(Flow01PetStore.class);
	String 	APIurl = "https://5clr97erg9.execute-api.us-east-1.amazonaws.com/DemoAPI";
	public static String resp = null;
	
	/********************************SETUP: Start: GET pets data  API *************************************************/  	
	public JSONArray TestGetParticipantAPI() throws JSONException
	{
		logger.info("------------------------------------------Starting GET data call---------------------------------------------------------------");
		Response response = given()
				.get(APIurl +"/pets");
			
		assertEquals(response.getStatusCode(),200);
		resp =  response.asString();
		if(!resp.startsWith("["))
		{
			resp = "[" + resp + "]";
		}
		JSONArray generalantarray = new JSONArray(resp);
		logger.info("------------------------------------------GET data call was successful---------------------------------------------------------");
		System.out.println("Total number of pets in the store - "+ generalantarray.length());
		return generalantarray;
	}
			
	/********************************Test 1: Start: Assert pets API**********************************************/
	public void AssertParticipantAPI(JSONArray generalantarray) 
	{	
		logger.info("------------------------------------------Start default JSON response for data API--------------------------------------------");
		
		assertTrue("GET data strategy call reply looks good", generalantarray.length() > 0);
		for(int i=0;i<generalantarray.length();i++)
		{
			Assert.assertNotNull(generalantarray.getJSONObject(i).get("id"));
			Assert.assertNotNull(generalantarray.getJSONObject(i).get("type"));
			Assert.assertNotNull(generalantarray.getJSONObject(i).get("price"));
			System.out.println("Pet number "+(i+1)+" is "+generalantarray.getJSONObject(i).get("type")+
					" and costs " + generalantarray.getJSONObject(i).get("price"));
		}
		
		logger.info("------------------------------------------JSON response for data API was asserted successfully --------------------------------------------");
	}

	/********************************Test 1: End: Assert pets API *********************************************/

}
