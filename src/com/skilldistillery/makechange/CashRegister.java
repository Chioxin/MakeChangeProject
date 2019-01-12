package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {
	public double ticketCost;
	public double moneyTendered;
	
	
	public double getItemPrice(Scanner sc) {
		//This method gets the price of the item the user wishes to purchase.
		
		System.out.print("How much does this item cost? >>");
		ticketCost = sc.nextDouble();
		return ticketCost;
		
	}
	
	public double getCashTendered(Scanner sc) {
		//This method gets the cash from the user that they wish to use to pay for the item.
		
		System.out.print("How much money was received? >>");
		moneyTendered = sc.nextDouble();
		return moneyTendered;
		
	}
	
	public void makeTransaction() {
		//This method tests the whether the user has given enough money to the register.
		
		if (moneyTendered < ticketCost) { // Not enough money received.
			System.out.printf("$%.2f won't pay for the cost of $%.2f.\n" , moneyTendered, ticketCost );
		} else if (moneyTendered == ticketCost) { // Exact change received.
			System.out.println("Thank you for the exact change!");
		} else { // More money was received than needed.
			double d = (moneyTendered - ticketCost);
			int changeInPennies = convertToPennies(d);
			System.out.printf("Thank you, let me get your $%.2f in change.\n" , (changeInPennies*.01));
			changeInPennies = calculateChange(changeInPennies, 20.0, "Twenties");
			changeInPennies = calculateChange(changeInPennies, 10.0, "Tens");
			changeInPennies = calculateChange(changeInPennies, 5.0, "Fives");
			changeInPennies = calculateChange(changeInPennies, 1.0, "Ones");
			changeInPennies = calculateChange(changeInPennies, 0.25, "Quarters");
			changeInPennies = calculateChange(changeInPennies, 0.10, "Dimes");
			changeInPennies = calculateChange(changeInPennies, 0.05, "Nickels");
			changeInPennies = calculateChange(changeInPennies, 0.01, "Pennies");
			
		}
		
	}
	public int calculateChange(int change, double moneyValue, String moneyType) {
		//Calculate the change and outputs the money left over.
		//It is required that "change" is in pennies at this point!
		int moneyValueAsPennies = convertToPennies(moneyValue);
		int n =(int)(change/moneyValueAsPennies);
		outputChange(n, moneyValueAsPennies, moneyType);
		return change - (n * moneyValueAsPennies);
		
	}
	
	public int convertToPennies (double n) {
		//Converts a number to an integer, and decides if it should round the value up a penny
		n = n * 100;
		int pennies = (int)(n);
		n = n - pennies;
		
		if (n >= .5) {
			return (pennies + 1);
		} else {
			return pennies;
		}

	}
	
	public void outputChange (int num, int value, String moneyType) {
		//Outputs the number of bills/coins, and displays how many to give out for what amount.
		if (num != 0) {
			System.out.printf("%d " + moneyType + " for a total of: $%.2f\n", num,  ((num * value) * .01));
		}
	}
	

}
