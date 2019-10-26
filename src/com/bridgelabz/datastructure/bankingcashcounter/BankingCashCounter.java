package com.bridgelabz.datastructure.bankingcashcounter;
import java.util.Scanner;
import com.bridgelabz.datastructure.queue.*;

public class BankingCashCounter<O> {
	static double totalBalance = 100000;

	static void deposit(int amount) {
		totalBalance += amount;
	}

	static void withdraw(int amount) {
		totalBalance -= amount;
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		int ch, amount;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of user");
		int user = scan.nextInt();
		for (int i = 1; i <= user; i++) {
			q.enqueue(i);
		}
		int n = q.size();
		for (int i = 0; i < n; i++) {
			System.out.println("Type 1 for deposit and 2 for withdraw");
			ch = scan.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter deposit amount");
				amount = scan.nextInt();
				deposit(amount);
				q.dequeue();
				break;
			case 2:
				System.out.println("Enter withdraw amount");
				amount = scan.nextInt();
				if (amount > totalBalance)
					System.out.println("amount is grater than totalbalance we can't proceed");
				else {
					withdraw(amount);
					q.dequeue();
				}
				break;
			default:
				System.out.println("Select valid number");
			}
		}
		System.out.println("Total balance left " + totalBalance);
	}
}