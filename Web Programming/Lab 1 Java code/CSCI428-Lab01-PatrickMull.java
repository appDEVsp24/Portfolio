/** 
* Lab 1: Menu-based Project.
*  
* Mull, Patrick
* 
* CSCI 428 Lab 1
* 
* 2/27/2024
*/
package menuCode;
import java.util.Scanner;
public class Lab1Menu {
	public static void main(String[] args) {
		int total = 100;  
		int option = 0;
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		while(flag)
		{
			//Menu Options
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("^^^ Student Registration Menu                        ^^^");
			System.out.println("^^^ Choose 1 to add students                         ^^^");  
			System.out.println("^^^ Choose 2 to remove students                      ^^^");  
			System.out.println("^^^ Choose 3 to display the total number of students ^^^");  
			System.out.println("^^^ Choose 4 the EXIT                                ^^^");  
			System.out.println("^^^ Enter 1,2,3 or 4 to select the option you want:  ^^^");  
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			// get choice from user
			option = in.nextInt();
			
			while(option <1 || option > 4)
			{
				System.out.println("Invalid Input. Please enter an valid input.");
				option = in.nextInt();
			}
			
			switch(option)
			{
				case 1:
					//Adding students to the system
					System.out.print("Enter the number of students you want to add:"); 
					total += in.nextInt(); 
					System.out.println("Successfully added the student to the system");
					System.out.println("");
					break;
				case 2: 
					//Removing students from the system
					System.out.print("Enter the number of students you want to remove:");  
					total -= in.nextInt();  
					System.out.println("");               
					break;
				case 3:  
					//Displaying the total number of students 
					System.out.println("Total : "+total+ " students registered.");  
					System.out.println("");  
					break;  

				case 4:  
					//get ready to exit from the menu  	  
					flag = false;
					System.out.println("################################");
					System.out.println("The program exited successfully.");
					System.out.println("Restart to manage the records.  ");
					System.out.println("################################");
					break;
				default:
					System.exit(0);	
			}
		}
	}
}