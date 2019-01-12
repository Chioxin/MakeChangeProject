package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		CashRegister register = new CashRegister();
		
		System.out.printf("\tItem costs $%.2f\n", register.getItemPrice(kb));
		System.out.printf("\tWe received $%.2f\n", register.getCashTendered(kb));
		register.makeTransaction();
		
		kb.close();
	}

}
