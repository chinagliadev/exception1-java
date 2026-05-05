package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
		    System.out.println("Enter Account Data");

		    System.out.print("Number: ");
		    int number = scanner.nextInt();

		    scanner.nextLine(); 

		    System.out.print("Holder: ");
		    String holder = scanner.nextLine();

		    System.out.print("Initial Balance: ");
		    double balance = scanner.nextDouble();

		    System.out.print("Withdraw Limit: ");
		    double withdrawLimit = scanner.nextDouble();

		    Account account = new Account(number, holder, withdrawLimit);
		    account.deposit(balance);

		    System.out.print("Enter amount for withdraw: ");
		    double withdrawAmount = scanner.nextDouble();

		    account.withDraw(withdrawAmount);
		}

		catch (DomainException de) {
		    System.out.println("Withdraw error: " + de.getMessage());
		}
		catch (InputMismatchException e) {
		    System.out.println("Invalid input!");
		}
		catch (Exception e) {
		    System.out.println("Unexpected error: " + e.getMessage());
		}

		scanner.close();
	}
}
