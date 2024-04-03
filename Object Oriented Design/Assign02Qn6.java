/** 
* Assignment 2: Strings and loops.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 2 -Qn 6 
* 
* 2/6/2024
*/
package New;

import java.util.Scanner;

public class Assign02Qn06 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        int num;
	        do {
	            System.out.print("Enter a positive integer: ");
	            num = scanner.nextInt();
	            
	            if (num <= 0) {
	                System.out.println("Invalid input. Please enter a positive integer greater than 0.");
	            }
	        } while (num <= 0);
	        
	        boolean isPrime = true;
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                isPrime = false;
	                break;
	            }
	        }
	        
	        if (isPrime) {
	            System.out.println(num + " is a prime number.");
	            
	            // Check if the number is a palindrome
	            String numString = Integer.toString(num);
	            boolean isPalindrome = true;
	            for (int i = 0; i < numString.length() / 2; i++) {
	                if (numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) {
	                    isPalindrome = false;
	                    break;
	                }
	            }
	            
	            if (isPalindrome) {
	                System.out.println(num + " is also a palindrome.");
	            } else {
	                System.out.println(num + " is not a palindrome.");
	            }
	        } else {
	            System.out.println(num + " is not a prime number.");
	        }
	        
	        scanner.close();
	    }
}