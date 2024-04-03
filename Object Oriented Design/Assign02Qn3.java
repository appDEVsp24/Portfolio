/** 
* Assignment 2: Strings and loops.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 2 -Qn 3 
* 
* 2/6/2024
*/
package New;

import java.util.Scanner;

public class Assign02Qn3 {

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
	        int oddNumber = firstNum;
	        int oddSum = 0;
	        while (oddNumber <= secondNum) {
	            if (oddNumber % 2 != 0) {
	                System.out.print(oddNumber + " ");
	                oddSum += oddNumber * oddNumber;
	            }
	            oddNumber++;
	        }
	        System.out.println();

	        // Output the sum of all the even numbers between firstNum and secondNum inclusive
	        System.out.println("Sum of even numbers between " + firstNum + " and " + secondNum + ":");
	        int evenNumber = firstNum;
	        int evenSum = 0;
	        while (evenNumber <= secondNum) {
	            if (evenNumber % 2 == 0) {
	                evenSum += evenNumber;
	            }
	            evenNumber++;
	        }
	        System.out.println(evenSum);

	        // Output all the numbers and their squares between 1 and 10
	        System.out.println("Numbers and their squares between 1 and 10:");
	        int num = 1;
	        while (num <= 10) {
	            System.out.println(num + " " + (num * num));
	            num++;
	        }

	        // Output the sum of the squares of all the odd numbers between firstNum and secondNum inclusive
	        System.out.println("Sum of squares of odd numbers between " + firstNum + " and " + secondNum + ":");
	        System.out.println(oddSum);

	        // Output all the uppercase letters
	        System.out.println("Uppercase letters:");
	        char ch = 'A';
	        while (ch <= 'Z') {
	            System.out.print(ch + " ");
	            ch++;
	        }   
	}
}


