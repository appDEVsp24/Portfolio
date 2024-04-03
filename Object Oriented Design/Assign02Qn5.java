/** 
* Assignment 2: Strings and loops.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 2 -Qn 5 
* 
* 2/6/2024
*/
package New;

import java.util.Scanner;

public class Assign02Qn5 {
	
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
	        int oddNumber = firstNum;
	        int oddSum = 0;
	        do {
	            if (oddNumber % 2 != 0) {
	                //System.out.print(oddNumber + " ");
	                oddSum += oddNumber * oddNumber;
	            }
	            oddNumber++;
	        } while (oddNumber <= secondNum);

	        // Output all the numbers and their squares between 1 and 10
	        System.out.println("Numbers and their squares between 1 and 10:");
	        int num = 1;
	        do {
	            System.out.println(num + " " + (num * num));
	            num++;
	        } while (num <= 10);

	        // Output the sum of the squares of all the odd numbers between firstNum and secondNum inclusive
	        System.out.println("Sum of squares of odd numbers between " + firstNum + " and " + secondNum + ":");
	        System.out.println(oddSum);

	        // Output all the uppercase letters
	        System.out.println("Uppercase letters:");
	        char ch = 'A';
	        do {
	            System.out.print(ch + " ");
	            ch++;
	        } while (ch <= 'Z');
	    }
}