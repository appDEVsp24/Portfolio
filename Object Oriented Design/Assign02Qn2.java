/** 
* Assignment 2: Strings and loops.
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 2 -Qn 2 
* 
* 2/5/2024
*/
package New;

import java.util.Scanner;

public class Assign02Qn2 {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Marriage Status (S for Single, M for Married): ");
        
        String inputStatus = scanner.nextLine();

        System.out.println("Enter taxable income amount (i.e. 1000): ");
        
        int income = scanner.nextInt();

        calculateTax(inputStatus, income);

        scanner.close();
    }

    private static void calculateTax(String inputStatus, int income) 
    {
    
    	String tax;

        if (inputStatus.equals("S")) 
        {
            if (income > 0 && income < 8001) 
            {
                tax = "10%";
                System.out.println("Tax: " + tax);
            } 
            else if (income >= 8001 && income < 32001) 
            {
                tax = "$800 + 15%";
                System.out.println("Tax: " + tax);
            } 
            else if (income >= 32001)
            {
                tax = "$4,400 + 25%";
                System.out.println("Tax: " + tax);
            }
        } 
        else if (inputStatus.equals("M"))
        {
            if (income > 0 && income < 16001)
            {
                tax = "10%";
                System.out.println("Tax: " + tax);
            } 
            else if (income >= 16001 && income < 64001)
            {
                tax = "$1,600 + 15%";
                System.out.println("Tax: " + tax);
            } 
            else if (income >= 64001) 
            {
                tax = "$8,800 + 25%";
                System.out.println("Tax: " + tax);
            }
        } 
        else 
        {
            System.out.println("Invalid Marriage Status input.");
        }
    } 
}

