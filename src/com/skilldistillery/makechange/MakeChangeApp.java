package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		CashRegister register = new CashRegister();
		boolean quit;
		
		do {
			System.out.printf("\tItem costs $%.2f\n\n", register.getItemPrice(kb));
			System.out.printf("\tWe received $%.2f\n\n", register.getCashTendered(kb));
			register.makeTransaction();
			
			quit = runAgain(kb);
			
		} while (quit);
		
		System.out.println("Have a nice day!");

		kb.close();
	}
	public static boolean runAgain(Scanner sc) {
		String input;
		
		System.out.print("\nWould you like to make another transaction? (Y/N)>> ");
		input = sc.next();
		
		if (input.equalsIgnoreCase("y")) {
			return true;
		} else {
			return false;
		}
		
	}

}
