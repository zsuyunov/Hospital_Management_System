package MyPack;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculateAge {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your date of birth in this format(mm/dd/yyyy");
		
		
		String abc = scanner.nextLine();
		
		LocalDate BirthDate = LocalDate.parse(abc, DateTimeFormatter.ofPattern("mm/dd/yyyy"));
		LocalDate currentDate = LocalDate.now();
		
		int age = Period.between(BirthDate, currentDate).getYears();
		
		System.out.println("Your age is" + age);
		
		if(age >= 70)
		{
			System.out.println("You are eligible for a free meal once you visit our hospital");
		}
		if(age < 18)
		{
			System.out.println("Make sure you are accompanied by an adult");
		}
		if(age <13)
		{
			System.out.println("You should be assigned a paediatrically specialized doctor");
		}
		
	}

}
