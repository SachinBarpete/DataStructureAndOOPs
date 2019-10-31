package com.bridgelabz.oops.inventory;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;

public class InventoryManagement extends JSONInventoryDataManagement {
	private static JSONObject inventoryFactory() {
		JSONObject jObj = new JSONObject();
		jObj.setName("Sugar");
		jObj.setPrice(30);
		jObj.setWeight(5);
		jObj.setValue(jObj.getWeight() * jObj.getPrice());
		return jObj;
	}

	public static void main(String[] args) {
		//for converting Object to JSON and JSON to Object
		ObjectMapper mapper = new ObjectMapper(); 

		try {
			//reading the value from JSON file
			JSONObject[] jObj = mapper.readValue(new File("InventoryDetail.json"), JSONObject[].class);
			String oldString = mapper.writeValueAsString(jObj);
			String jsonString = mapper.writeValueAsString(inventoryFactory());
			System.out.println(oldString);
			System.out.println(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
