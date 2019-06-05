package com.oliulka.demoAPI.tests;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.oliulka.demoAPI.flows.Flow01PetStore;

public class Test01PetStore {
	
	final static Logger logger = Logger.getLogger(Test01PetStore.class);
	
	@Test(enabled=true)
	public void TestBasicPetStoreAPI() throws Exception  
	{		
		/* ----------------------- start: Asserting Participant Data in API ----------------------------------------------*/
		TestGetPetStoreAPI();
		/* ----------------------- end: Asserting Participant Data in API -------------------------------------------**---*/
	}

	 public void TestGetPetStoreAPI()
	 {
		Flow01PetStore flow01 = new Flow01PetStore();
		JSONArray resp = flow01.TestGetParticipantAPI();
		flow01.AssertParticipantAPI(resp);
		logger.info("Participant API data was asserted successfully");
	 }
}
