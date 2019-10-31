package com.bridgelabz.datastructureproblems;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

class HashTable {

	private LinkedList[] hashTable = new LinkedList[11];

	void add(int key) {
		int tableIndex = key % 11;
		if (hashTable[tableIndex] == null)
			hashTable[tableIndex] = new LinkedList();
		if (hashTable[tableIndex].contains(key))
			hashTable[tableIndex].remove(tableIndex);
		else
			hashTable[tableIndex].add(key);
	}

	int printAll() {
		for (LinkedList list : hashTable)
			if (list != null) {
				for (Object element : list)
					return (int) element;
				System.out.println();
			}
		return 0;
	}

	int search(int key) {
		int index = key % 11;
		if (hashTable[index].contains(key))
			return (int) hashTable[index].get(hashTable[index].indexOf(key));
		return -1;
	}
}

public class Hashing {
	public static void main(String[] args) throws Exception {
		HashTable table = new HashTable();
		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(new FileReader("/home/admin1/FellowShipSachinBarpete/Files/hashingInput"));
		while (sc.hasNext()) {
			int value = sc.nextInt();
			table.add(value);
		}
		System.out.println("Enter any number for search");
		int searchKey = in.nextInt();
		table.add(searchKey);

		try {
			FileWriter fw = new FileWriter("/home/admin1/FellowShipSachinBarpete/Files/hashingOutput");
			fw.write(table.printAll() + " ");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		sc.close();
		in.close();
	}
}