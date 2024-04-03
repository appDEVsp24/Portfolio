/** 
* My first Java Project.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 1 -Qn 5 
* 
* 01/23/2024
*/
package New;

import java.util.Scanner;

public class Assign1Qn5 {
		
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	
	        System.out.print("Please enter your 8-digit CWID: ");
	        int number = scanner.nextInt();

	        breakDigits(number);
	
	        scanner.close();
	    }
	
	    private static void breakDigits(int number) {
	        String numberString = String.valueOf(number);
	
	        int total = 0;
	
	        System.out.print("The digits are: ");
	        for (int i = 0; i < numberString.length(); i++) {
	            int digit = Character.getNumericValue(numberString.charAt(i));
	            System.out.print(digit + " ");
	            total += digit;
	        }
	
	        System.out.println("\nThe total is: " + total);
	
	        double average = (double) total / numberString.length();
	        System.out.println("The average is: " + average);
	    }
	}