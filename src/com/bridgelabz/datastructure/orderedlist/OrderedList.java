package com.bridgelabz.datastructure.orderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.bridgelabz.datastructure.linkedlist.*;


public class OrderedList<T> {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = sc.nextInt();

		File file = new File("C:\\Users\\Barpete Brother's\\eclipse-workspace\\Files\\OrderedList.txt");
		try (Scanner scan = new Scanner(file)) {
			while (scan.hasNextInt()) {
				list.add(scan.nextInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");

		}
		if (list.search(num)) {
			while (list.search(num))
				list.remove(num);
		} else
			list.add(num);
		list.sortList();
		try {
			Files.write(Paths.get("/Users/Barpete Brother's/eclipse-workspace/Files/OrderedList.txt"),
					list.list().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}