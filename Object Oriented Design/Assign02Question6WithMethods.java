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
public class Assign02Qn6 {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int num;

	        do {
	            System.out.print("Enter a positive integer (or 0/negative to exit): ");
	            num = scanner.nextInt();
	            if (num > 0) {
	                boolean isPrime = checkPrime(num);
	                System.out.println(num + " is " + (isPrime ? "" : "not ") + "a prime number.");

	                if (isPrime) {
	                    boolean isPalindrome = checkPalindrome(num);
	                    System.out.println(num + " is " + (isPalindrome ? "" : "not ") + "a palindrome.");
	                }
	            } else if (num < 0) {
	                System.out.println("Please enter a positive integer.");
	            }
	        } while (num != 0);
	        
	        scanner.close();
	    }

	    // Function to check if a number is prime
	    private static boolean checkPrime(int num) {
	        if (num <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    // Function to check if a number is a palindrome
	    private static boolean checkPalindrome(int num) {
	        int reversed = 0;
	        int original = num;

	        while (num != 0) {
	            int digit = num % 10;
	            reversed = reversed * 10 + digit;
	            num /= 10;
	        }

	        return original == reversed;
	    }
}


