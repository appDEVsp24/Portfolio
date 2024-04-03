/** 
* Assignment 3 2D Array, Formulas, and Methods
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 3 -Qn 2 
* 
* 3/28/2024
*/

package New;

import java.lang.Math; 
import java.util.Scanner;

//Class for the required methods: distance, radius, circumference, and area
class Formula {  
    
	//uses the formula provided. The output gives the radius, which is half the diameter
    public double distance(double x1, double y1, double x2, double y2)
    {
    	return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
    
    //Finds the radius with the provided formula
    public double radius(double xC, double yC, double xP, double yP) {
        return distance(xC, yC, xP, yP);
    }

    //Finds the circumference with the formula: 2 pi r (using the provided value of pi)
    public double circumference(double radius) {
        return 2 * 3.1416 * radius;
    }

    //Finds the area with the formula: pi r squared 
    public double area(double radius) {
        return 3.1416 * Math.pow(radius, 2);
    }
} 


public class Assign03Qn2 {
	
	public static void main(String[] args) {
		
		  @SuppressWarnings("resource")
		  Scanner scanner = new Scanner(System.in);
		  
		  //Creating an object of class Formula
		  Formula formula = new Formula();
		  
	      //Getting user input for the four numbers required
	      System.out.print("Enter X coordinate for the center of the circle: ");
	      
	      double xC = scanner.nextDouble();
	      
	      System.out.print("Enter Y coordinate for the center of the circle: ");
	      
	      double yC = scanner.nextDouble();
	      
	      System.out.print("Enter X coordinate for a point on the circle: ");
	      
	      double xP = scanner.nextDouble();
	      
	      System.out.print("Enter Y coordinate for a point on the circle: ");
	      
	      double yP = scanner.nextDouble();
	      
	      //Calling the methods created above
	      double radius = formula.radius(xC, yC, xP, yP);
	      
	      double distance = 2 * radius;
	      
	      double circumference = formula.circumference(radius);
	      
	      double area = formula.area(radius);
	      
	      System.out.println('\n');
	      
	      //Displaying the results
	      System.out.println("The distance between the points on the circle: " + distance);

	      System.out.println("The radius of the circle: " + radius);
	      
	      System.out.println("The circumference of the circle: " + circumference);
	      
	      System.out.println("The area of the circle: " + area);
	}

}
