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
			double change = moneyTendered - ticketCost;
			System.out.printf("Thank you, let me get your $%.2f in change.\n" , change);
			change = calculateChange(change, 20.0, "Twenties");
			change = calculateChange(change, 10.0, "Tens");
			change = calculateChange(change, 5.0, "Fives");
			change = calculateChange(change, 1.0, "Ones");
			change = calculateChange(change, 0.25, "Quarters");
			change = calculateChange(change, 0.10, "Dimes");
			change = calculateChange(change, 0.05, "Nickels");
			change = calculateChange(change, 0.01, "Pennies");
			
		}
		
	}
	
	public void outputChange (int num, double value, String moneyType) {
		//Outputs the number of bills, and displays how many to give out for what amount.
		System.out.printf("%d " + moneyType + " for a total of: $%.2f\n", num,  (num * value));
//		System.out.print((num + "\t" + moneyType + " for a total of:\t$" + (num * value)));
		
	}
	
	public double calculateChange(double change, double moneyValue, String moneyType) {
		//Calculate the change and outputs the money left over.
		
		int n =(int)(change/moneyValue);
		outputChange(n, moneyValue, moneyType);
		System.out.println(change + " <--- Current :: Predicted ---> " + (change - (n*moneyValue)));
		return change - (n * moneyValue);
	}

}
