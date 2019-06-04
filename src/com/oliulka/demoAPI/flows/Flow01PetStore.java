package com.oliulka.demoAPI.flows;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.jayway.restassured.response.Response;

public class Flow01PetStore //extends DemoAPIAbstractTest
{
	String 	APIurl = "https://5clr97erg9.execute-api.us-east-1.amazonaws.com/DemoAPI";
	public static String resp = null;
	/********************************SETUP: Start: GET Participant API *************************************************/  	
	public JSONArray TestGetParticipantAPI() throws JSONException
	{
		//logger.info("------------------------------------------Starting GET data call---------------------------------------------------------------");
		Response response = given()
				.get(APIurl +"/pets");
			
		assertEquals(response.getStatusCode(),200);
		resp =  response.asString();
		if(!resp.startsWith("["))
		{
			resp = "[" + resp + "]";
		}
		JSONArray participantarray = new JSONArray(resp);
		//logger.info("------------------------------------------GET data call was successful---------------------------------------------------------");
		System.out.println("ToTal number of pets in the store - "+ participantarray.length());
		return participantarray;
	}
			

	/********************************Test 1: Start: GET Participant API**********************************************/
		
	public void AssertParticipantAPI(JSONArray participantarray) 
	{	
		//logger.info("------------------------------------------Start default JSON response for data API--------------------------------------------");
		
		assertTrue("GET data strategy call reply looks good", participantarray.length() > 0);
		for(int i=1;i<=participantarray.length();i++)
		{
			//Assert.assertNotNull(participantarray.getJSONObject(i).getJSONObject("id"));
			Assert.assertNotNull(participantarray.getJSONObject(i).getJSONObject("type"));
			Assert.assertNotNull(participantarray.getJSONObject(i).getJSONObject("price"));
			System.out.println("Pet number"+i+" is "+participantarray.getJSONObject(i).getJSONObject("type")+
					" and costs " + participantarray.getJSONObject(i).getJSONObject("price"));
		}
		
		//logger.info("------------------------------------------JSON response for data API was asserted successfully --------------------------------------------");
		}

		/********************************Test 1: End: GET Participant API *********************************************/

}
