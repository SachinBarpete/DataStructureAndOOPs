package com.bridgelabz.datastructureproblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.bridgelabz.datastructure.linkedlist.*;

public class UnorderedList<T> {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word to search");
		String word = sc.nextLine();

		File file = new File("C:\\Users\\Barpete Brother's\\eclipse-workspace\\Files\\UnorderedList.txt");
		try (Scanner scan = new Scanner(file)) {
			while (scan.hasNext()) {
				list.add(scan.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		if (list.search(word)) {
			while (list.search(word))
				list.remove(word);
		} else
			list.add(word);
		try {
			Files.write(Paths.get("/Users/Barpete Brother's/eclipse-workspace/Files/UnorderedList.txt"),
					list.list().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}