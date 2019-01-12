## Make Change Project

This project simulates a cash register. A user is asked to enter an item amount and is then asked how much they'd like to pay with.

The program will calculate the change returned by largest denomination and list out the change from twenties down to the pennies to be returned to the buyer. For example: If the user enters 20 dollars for an item that cost 3.96, the program will output 1 tend dollar bill, 1 five dollar bill, 1 one dollar bill, and 4 pennies.

This is Week 1 [Skill Distillery](http://skilldistillery.com) weekend homework.

### Technologies Used
* Java
* Git command line
* Eclipse

### Challenges

Doubles are deceptive. We look at money like DOLLAR.CENTS, but in a double, that could look like 1.3299999999999 after some math, when we'd like it to be 1.33. The best way around this problem for this particular program was to convert the money received by the user into pennies by multiplying it by 100, and then casting it into an int to truncate it to what we needed.