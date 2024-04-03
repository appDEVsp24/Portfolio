/** 
* Assignment 2: Strings and loops.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 2 -Qn 1 
* 
* 2/5/2024
*/
package New;

import java.util.Scanner;

public class Assign2Qn1 {
	
	 public static void
	    characters(String str)
	    {
	 
	        // Finding the string length
	        int n = str.length();
	 
	        // First character of the string
	        String f = str.substring(0,1);
	 
	        // Last character of the string
	        String l = str.substring(n - 1);
	        
	        //Excluding the first and last characters
	        String mid = str.substring(1, str.length() - 1);     
	        
	        //Printing out the first character
	        System.out.println("The first letter is: " + f);
	        
	        // Printing first and last characters
	        System.out.println("The first and last letters are: " + f + " " + l);
	        
	        // Printing the string excluding the first and last character
	        System.out.println("Excluding the first and last letters: " + mid);
	        
	        //First half of the string
	        if (str.length()%2 == 0)
	        {
	        	String front = str.substring(0, n/2);
	        	System.out.println("The first half of the string (even length): " + front);
	        }
	        else
	        {
	        	String front = str.substring(0, n/2);
	        	System.out.println("The first half of the string (odd length): " + front);
	        }
	        //Second half of the string
	        if (str.length()%2 == 0)
	        {
	        	String back = str.substring(n/2, n);
	        	System.out.println("The second half of the string (even length): " + back);
	        }
	        else
	        {
	        	String back = str.substring(n/2 + 1, n);
	        	System.out.println("The second half of the string (odd length): " + back);
	        }
	        
	        //Middle letter of an odd length string
	        if (str.length()%2 == 0)
	        {
	        	String midChar = str.substring(n/2 - 1, n/2+1);
	        	System.out.println("This string is even and the middle letters are: " + midChar);
	        	
	        }
	        else
	        {
	        	//String midChar = str.substring(n/2, n/2);
	        	String midChar = str.substring(n/2, n/2+1);
	        	System.out.println("This string is odd and the middle letter is: " + midChar);
	        	
	        }
	    }

	public static void main(String[] args) {
		
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter your name");

	    String name = myObj.nextLine();  // Read user input
	    //System.out.println("Your name is: " + name);  // Output user input
	    
	    myObj.close();  //Close the scanner
	    
	    String str = name;
	    
        // Function Call
        characters(str);
	    
	    
		

	}

}
