/** 
* Assignment 2: Strings and loops.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 2 -Qn 4 
* 
* 2/6/2024
*/
package New;

import java.util.Scanner;

public class Assign02Qn4 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Prompt the user to input firstNum and secondNum
	        System.out.print("Enter first number: ");
	        int firstNum = scanner.nextInt();

	        System.out.print("Enter second number: ");
	        int secondNum = scanner.nextInt();
	        
	        scanner.close();

	        // Validate that firstNum is less than secondNum
	        if (firstNum >= secondNum) {
	            System.out.println("Error: firstNum must be less than secondNum.");
	            return;
	        }

	        // Output all the odd numbers between firstNum and secondNum inclusive
	        System.out.println("Odd numbers between " + firstNum + " and " + secondNum + ":");
	        @SuppressWarnings("unused")
			int oddSum = 0;
	        for (int i = firstNum; i <= secondNum; i++) {
	            if (i % 2 != 0) {
	                System.out.print(i + " ");
	                oddSum += i * i;
	            }
	        }
	        System.out.println();

	        // Output the sum of all the even numbers between firstNum and secondNum inclusive
	        System.out.println("Sum of even numbers between " + firstNum + " and " + secondNum + ":");
	        int evenSum = 0;
	        for (int i = firstNum; i <= secondNum; i++) {
	            if (i % 2 == 0) {
	                evenSum += i;
	            }
	        }
	        System.out.println(evenSum);

			
	    }
	}