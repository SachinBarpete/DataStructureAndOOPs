package com.bridgelabz.oops.stockmanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class StockAccount {
	static Scanner sc = new Scanner(System.in);

	private static Stock setStock() {
		Stock stock = new Stock();
		System.out.println("Enter the name of stock");
		stock.setName(sc.next());
		System.out.println("Enter the share of stock");
		stock.setShare(sc.nextInt());
		System.out.println("Enter the price of stock");
		stock.setPrice(sc.nextFloat());
		stock.setValue(stock.getShare() * stock.getPrice());
		return stock;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		System.out.println("Enter the number of stock");
		int nmst = sc.nextInt();

		ObjectMapper mapper = new ObjectMapper();

		Stock[] stockList = new Stock[nmst];
		int i = 0;
		while (i < stockList.length) {
			stockList[i] = StockAccount.setStock();
			i++;
		}
		
		double totalValue=0;
		for(int j=0;j<stockList.length;j++)
			totalValue +=stockList[j].getValue();
		StockPortfolio stp = new StockPortfolio();
		stp.setTotalStockValue(totalValue);
		
		mapper.defaultPrettyPrintingWriter().writeValue(new File("StockAccount.json"), stockList);
		
		String jsonString = mapper.writeValueAsString(stockList);
		String totalStockValue = mapper.writeValueAsString(stp);
		System.out.println(jsonString);
		System.out.println(totalStockValue);
	}

}
