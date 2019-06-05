package com.oliulka.demoAPI.tests;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.oliulka.demoAPI.flows.Flow01PetStore;

public class Test01PetStore {
	
	final static Logger logger = Logger.getLogger(Test01PetStore.class);
	
	@Test(enabled=true)
	public void TestDefaultPetStoreAPI() throws Exception  
	{		
		/* ----------------------- start: Asserting default data of PetStore API ----------------------------------------------*/
		TestGetPetStoreAPI();
		/* ----------------------- end: Asserting default data of PetStore API -------------------------------------------**---*/
	}
	
	@Test(enabled=true)
	public void AddNewPetToPetStoreAPI() throws Exception  
	{		
		/* ----------------------- start: Adding and asserting new pet in PetStore in API ----------------------------------------------*/
		AddNewPetToAPI();
		/* ----------------------- end: Adding and asserting new pet in PetStore in API -------------------------------------------**---*/
	}

	 public void TestGetPetStoreAPI()
	 {
		Flow01PetStore flow01 = new Flow01PetStore();
		JSONArray resp = flow01.TestGetParticipantAPI();
		flow01.AssertParticipantAPI(resp);
		logger.info("Default PetStore API data was asserted successfully");
	 }
	 
	 public void AddNewPetToAPI()
	 {
		Flow01PetStore flow01 = new Flow01PetStore();
		JSONObject resp = flow01.AddNewAnimalToAPI();
		flow01.assertAddedAnimal(resp);
		logger.info("New pet data was asserted successfully");
	 }
}
