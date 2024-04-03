/** 
* Assignment 3 2D Array, Formulas, and Methods
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 3 -Qn 3 
* 
* 3/28/2024
*/

package New;

import java.util.Arrays;

public class Assign03Qn3 {
	
	public static void main(String[] args) {
		
		//arrays a,b
		int [] a = {1,4,9,16};
		int [] b = {9,7,4,9,11};
		int [] b1 = {4,7,9,9,11}; //b1 is necessary because the order of array b is different in question 3 from questions 1 and 2

		//calling the methods
		int[] c = append(a,b);
		
		int[] d = merge(a, b);
		
		int[] e = mergeSorted(a,b1);
	}
	
	//a
	public static int [] append (int [] a, int [] b ) {
		//Array temp holds the information from a and b so they don't get modified	
		int[] temp = new int[a.length + b.length];
		
		//adding the contents of a and b to temp
		for (int i = 0; i < a.length; i++) {  
			temp[i] = a[i]; 
	    }
			
		for (int i = 0; i < b.length; i++) {  
	        temp[a.length + i] = b[i]; 
	    }
		
		//printing the new array
		for (int i = 0; i < temp.length; i++) { 
			System.out.print(temp[i]);
		}
		
		System.out.println('\n');
		return temp;
	}
	
	//b
	public static int [] merge (int [] a, int [] b) {
		//Array temp holds the information from a and b so they don't get modified	
		int[] temp = new int[a.length + b.length];
		
		int i = 0, j = 0, k = 0;
		
		//merging the contents of a and b by adding them into temp in an alternating pattern
        while (i < a.length && j < b.length) {
        	temp[k++] = a[i++];
        	temp[k++] = b[j++];
        }
        
        while (i < a.length) {
        	temp[k++] = a[i++];
        }
        
        while (j < b.length) {
        	temp[k++] = b[j++];
        }
        
        //printing the new array
        for (int l = 0; l < temp.length; l++) { 
			System.out.print(temp[l]);
		}
        
        System.out.println('\n');
        return temp;
	}
	
	//c
	public static int [] mergeSorted ( int [] a, int [] b1) {
		//Array temp holds the information from a and b so they don't get modified	
		int[] temp = new int[a.length + b1.length];
		
        int i = 0, j = 0, k = 0;

        //Merging the arrays
        while (i < a.length && j < b1.length) {
            if (a[i] <= b1[j]) {
                temp[k++] = a[i++];
            } 
            else {
            	temp[k++] = b1[j++];
            }
        }

        //Adding any remaining data from a
        while (i < a.length) {
        	temp[k++] = a[i++];
        }

        //adding any remaining data from b
        while (j < b1.length) {
        	temp[k++] = b1[j++];
        }

      //printing the new array
        for (int l = 0; l < temp.length; l++) { 
			System.out.print(temp[l]);
		}
        
        System.out.println('\n');
        return temp;
	}
}