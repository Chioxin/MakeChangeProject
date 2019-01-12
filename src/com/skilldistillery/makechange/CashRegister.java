package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {
	
	
	public double getItemPrice(Scanner sc) {
		
		System.out.print("How much does this item cost? >>");
		return sc.nextDouble();
		
	}
	
	public double getCashTendered(Scanner sc) {
		
		System.out.print("How much money was received? >>");
		return sc.nextDouble();
		
	}

}
