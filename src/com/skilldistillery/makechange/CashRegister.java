package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {
	public int ticketCost;
	public int moneyTendered;
	
	
	public int getItemPrice(Scanner sc) {
		//This method gets the price of the item the user wishes to purchase.
		
		System.out.print("How much does this item cost? >>");
		ticketCost = (int)(sc.nextDouble() * 100); //converting to pennies immediately
		return ticketCost;
	}
	
	public int getCashTendered(Scanner sc) {
		//This method gets the cash from the user that they wish to use to pay for the item.
		
		System.out.print("How much money was received? >>");
		moneyTendered = (int)(sc.nextDouble() * 100); //converting to pennies immediately
		return moneyTendered;
	}
	
	public void makeTransaction() {
		//This method tests the whether the user has given enough money to the register.
		
		if (moneyTendered < ticketCost) { // Not enough money received.
			System.out.printf("$%.2f won't pay for the cost of $%.2f.\n" , ((moneyTendered * .01)), (ticketCost * .01));
		} else if (moneyTendered == ticketCost) { // Exact change received.
			System.out.println("Thank you for the exact change!");
		} else { // More money was received than needed.
			int change = (moneyTendered - ticketCost);
			System.out.printf("Thank you, let me get your $%.2f in change.\n" , (change * .01));
			change = calculateChange(change, 2000, "Twenties");
			change = calculateChange(change, 1000, "Tens");
			change = calculateChange(change, 500, "Fives");
			change = calculateChange(change, 100, "Ones");
			change = calculateChange(change, 25, "Quarters");
			change = calculateChange(change, 10, "Dimes");
			change = calculateChange(change, 5, "Nickels");
			change = calculateChange(change, 1, "Pennies");
		}
	}

	public int calculateChange(int change, int moneyValue, String moneyType) {
		//Calculate the change and outputs the money left over.
		int n = change/moneyValue;
		int leftOver = change%moneyValue;

		outputChange(n, moneyValue, moneyType);
		return leftOver;
	}
	
	public void outputChange (int num, int value, String moneyType) {
		//Outputs the number of bills/coins, and displays how many to give out for what amount.
		if (num != 0) {
			System.out.printf("%d " + moneyType + " for a total of: $%.2f\n", num,  ((num * value) * .01));
		}
	}
}
