package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = scanner.nextInt();
		System.out.println("Check In date (dd/MM/yyyy): ");
		Date checkIn = simpleDateFormat.parse(scanner.next());
		System.out.println("Check Out date (dd/MM/yyyy): ");
		Date checkOut = simpleDateFormat.parse(scanner.next());
		
		if(!checkOut.after(checkIn)) 
		{
			System.out.println("Error in reservation Date");
		}
		else 
		{
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check In date (dd/MM/yyyy): ");
			checkIn = simpleDateFormat.parse(scanner.next());
			System.out.println("Check Out date (dd/MM/yyyy): ");
			checkOut = simpleDateFormat.parse(scanner.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) 
			{
				System.out.println("Error in Reservation: data invalid");
			}
			else 
			{
				if(!checkOut.after(checkIn)) 
				{
					System.out.println("Error in reservation Date");
				}
				else 
				{
					reservation.updateDates(checkIn, checkOut);
					System.out.println(reservation);
				}
			}
			
		}
	}
}