package com.bridgelabz.oops.inventory;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

class JSONObject {
	private String name;
	private int weight;
	private float price;
	private float value;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

public class JSONInventoryDataManagement {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			JSONObject[] jObj = mapper.readValue(new File("InventoryDetail.json"), JSONObject[].class);
			for (int i = 0; i < jObj.length; i++)
				jObj[i].setValue(jObj[i].getWeight() * jObj[i].getPrice());

			String jsonString = mapper.writeValueAsString(jObj);
			System.out.println(jsonString);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}