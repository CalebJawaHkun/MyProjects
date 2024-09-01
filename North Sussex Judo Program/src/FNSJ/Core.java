package FNSJ;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Core {
	// A static method that collects data and returns the object.
	public static Athelete collectUserData() {
		
		// Declaring variables needed to instantiate the athelete object.
		 Scanner reader = new Scanner(System.in);
		 String temp;
		 String name, tplan;
		 double weight;
		 
		 int noce = 0, pth = 0, wcate;
			//Collect name of the athelete.
			System.out.print("\nPlease Enter Your Name : ");
			name = reader.next(); name += reader.nextLine();
			// Validation. If the user entered gibberish name prompt to enter again.
			while(!Pattern.matches("([A-Z][a-z]+)(\s[A-Z][a-z]+)*", name)) {
				System.out.print("Please Enter a valid name format : ");
				name = reader.next(); name += reader.nextLine();
			}
			
			// Collecting Training plan from the user.
			System.out.print("What would be Your training Plan? \n [Beginner, Intermediate, Elite] : ");
			tplan = reader.next(); tplan += reader.nextLine(); 
			
			// If the user entered other than the set value, enter again.
			while( !tplan.equalsIgnoreCase("Beginner") && !tplan.equalsIgnoreCase("Intermediate") && !tplan.equalsIgnoreCase("Elite")) 
			{
				System.out.print("Please enter your plan again! : ");
				tplan = reader.nextLine();
			}
			
			System.out.print("You have subscribed " +tplan +"!\n");
			
			// branch for beginner and not beginner. Athelete other than beginner will enter the competition
			if(tplan.equalsIgnoreCase("Intermediate") || tplan.equalsIgnoreCase("Elite")) {
				System.out.print("How many competition have you entered? : ");
				
				temp = reader.next();
				
				while(!new Scanner(temp).hasNextInt()) {
					System.out.println("Strings are not allowed! Enter Again! : ");
					temp = reader.next();
					
				}
				
				noce = Integer.parseInt(temp);						
			}
			else { // Beginner are not allowed to enter the competition.
				System.out.println("Since you are a Beginner, You will not enter any competition.");
				noce = 0;
			}
			
			//Collecting competetion weight category
			System.out.println("\nHeavyweight - 1, \n"
					+ "Light-Heavyweight - 2 \n"
					+ "Middleweight - 3 \n"
					+ "Light-Middleweight - 4 \n"
					+ "Lightweight - 5 \n"
					+ "Flyweight - 6\n");
			System.out.print("Choose your weight category! (With Numbers) : ");
			temp = reader.next();
			// if the user entered other than an integer, prompt to enter again.
			while(!new Scanner(temp).hasNextInt()) {
				System.out.print("Please Enter a number! : ");
				temp = reader.next();
				
			}
			/* 
			 * String is passed into a new Scanner object
			 * hasNextInt() function is called on the object to read if there are integers or not.
			 * Returns true if there is otherwise false. 
			 */
			wcate = Integer.parseInt(temp);
			
			// if the user entered a number that is out of bount
			while(wcate <= -0 || wcate > 6) {
				System.out.print("Choose between 1 and 6 to decide your competition weight category! :");
				wcate = reader.nextInt();
			}
			
			
			// Collecting current weight
			System.out.print("Please enter your current Weight (In Kilogram) : ");
			
			temp = reader.next();
			
			while(!new Scanner(temp).hasNextDouble()) // if the string did not contain a double or integer
			{
				System.out.print("Please enter a number! : ");
				temp = reader.next();
			}
			
			weight = Double.parseDouble(temp); // if it contained a double or integer
								
			System.out.print("Would you like to purchase the private tutor? [Yes or No] : ");
			String yorn = reader.next();
			
			// if the user entered other than yes or no. Prompt to enter agin
			while(!yorn.equalsIgnoreCase("Yes") && !yorn.equalsIgnoreCase("No")) {
				System.out.print("You can only choose \"Yes\" or \"No\" ");
				yorn = reader.next();
			}
			
			// if the user want to enter the competition
			if(yorn.equalsIgnoreCase("yes")) {
				System.out.print("How many hours of private tuitin? (5 hours max per week!) : ");
				temp = reader.next();
				
				// if the user did not enter a number. prompt again
				while(!new Scanner(temp).hasNextInt()) {
					System.out.println("Enter a number!");
					temp = reader.next();
				}
				
				pth = Integer.parseInt(temp);
				
				// if the user entered number greater than 5 or less than 0, prompt again
				while(pth > 5 || pth <= -0) {
					if(pth > 5) {
						System.out.println("You can only have a maximum of 5 hours per week!");
					}
					else {
						System.out.println("Invalid hours!");
					}
					
					System.out.print("Please Enter Again : ");
					pth = reader.nextInt();
					
				}
				
				System.out.printf("You have subsribe for %d hours per week!\n\n", pth);
			}
			else // otherwise.
			{
				System.out.println("You will not receive the private tutor for the following month!\n");
					pth = 0;
			}
			
			reader.close();
			
			// a statement that returns the object with assigned values. 
			return new Athelete(
						name, 
						noce, 
						pth, 
						wcate, 
						tplan, 
						weight
					);			
	}
}
