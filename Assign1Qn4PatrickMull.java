/** 
* My first Java Project.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 1 -Qn 4 
* 
* 01/22/2024
*/
package New;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Assign1Qn4 {

	public static void main(String[] args) {
		int x, y, sum, difference, product, average, distance, maximum, minimum, area, perimeter;
		Scanner myObj = new Scanner(System.in); // Create a Scanner object		
	    System.out.println("Type a number:");	    
	    x = myObj.nextInt(); // Read user input
	    System.out.println("Type another number:");	    
	    y = myObj.nextInt(); // Read user input
	    sum = x + y;  	    
	    difference = x - y; 	    
	    product = x * y;	    
	    average = (x + y) / 2;	    
	    distance = Math.abs(x - y); 	    
	    maximum = Math.max(x, y);	    
	    minimum = Math.min(x,  y);	    
	    area = x * y;	    
	    perimeter = (x * 2) + (y * 2);	    
	    System.out.println("The sum is: " + sum); 	    
	    System.out.println("The difference is: " + difference);	    
	    System.out.println("The product is: " + product);	    
	    System.out.println("The average is: " + average);	    
	    System.out.println("The distance is: " + distance);	    
	    System.out.println("The maximum is: " + maximum);	    
	    System.out.println("The minimum is: " + minimum);	    
	    System.out.println("The area of a rectangle of the length and width of your input is: " + area);	    
	    System.out.println("The perimeter of a rectangle the length and width of your input is is: " + perimeter);		
	}

}