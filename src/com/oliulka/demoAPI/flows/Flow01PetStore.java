package com.oliulka.demoAPI.flows;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.*;

import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.restassured.response.Response;

public class Flow01PetStore //extends DemoAPIAbstractTest
{
	String 	APIurl = "https://5clr97erg9.execute-api.us-east-1.amazonaws.com/DemoAPI/pets";
	public static String resp = null;
	/********************************SETUP: Start: GET Participant API *************************************************/  	
	public JSONObject TestGetParticipantAPI() throws JSONException
	{
		//logger.info("------------------------------------------Starting GET Participant call---------------------------------------------------------------");
		Response response = given()
				.get(APIurl +"participant/");
			
		assertEquals(response.getStatusCode(),200);
		resp =  response.asString();
		
		JSONObject generalobject = new JSONObject(resp);
		assertTrue("GET participant call reply does not look good", generalobject.getString("InternalId").length() > 10);
		//logger.info("------------------------------------------GET Participant call was successful---------------------------------------------------------");
		return generalobject;
	}
			

	/********************************Test 1: Start: GET Participant API**********************************************/
		
	public void AssertParticipantAPI(JSONObject generalobject, String xmllocation) 
	{	
		//logger.info("------------------------------------------Start asserting JSON response for Participant API--------------------------------------------");
		String currentAPI = APIurl +"participant/";
		//JSONObject pptobject = generalobject.getJSONObject("ParticipantData").getJSONObject("ParticipantInfo").getJSONObject("Participant");

		//assertEquals("", pptobject.getString("FirstName"), "FirstName API value of endpoint: "+currentAPI+" does not match the XML value,");
	    //assertEquals("", pptobject.getString("LastName"),  "LastName API value of endpoint: "+currentAPI+" does not match the XML value,");  
		//logger.info("------------------------------------------JSON response for Participant API was asserted successfully --------------------------------------------");
		}

		/********************************Test 1: End: GET Participant API *********************************************/

}
