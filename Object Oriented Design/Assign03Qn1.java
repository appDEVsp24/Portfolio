/** 
* Assignment 3 2D Array, Formulas, and Methods
*  
* Mull, Patrick
* 
* CSCI 428 Assignment 3 -Qn 1 
* 
* 3/26/2024
*/

package New;

public class Assign03Qn1 {
	
	public static void main(String[] args) {
		
		//Implementing a 2D array named "board" with 20 rows and 30 columns
		int row = 20;
		int column = 30;
		
		int[][] board = new int[row][column];
		
		//Filling the array with 0's
		int num = 0;
		
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board [i][j] = num;
            }
        }
		
		//Printing to check the results
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println('\n'); 
		
		//Filling the array with alternating 0's and 1's
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = 0; 
                } 
                else {
                	board[i][j] = 1; 
                }
            }
        }
		
		//Printing to check the results
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println('\n'); 
		
		//Filling only the top and bottom rows with 0's
		for (int i = 0; i < board[0].length; i++) {
            board[0][i] = 0; 
            board[board.length - 1][i] = 0; 
        }

		//Printing to check the results
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println('\n'); 
		
		//Calculating the sum of the elements
		int sum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				sum += board[i][j];
			}
		}
		
		System.out.println("The sum of the elements in the array is: " + sum);
		System.out.println('\n'); 
		
		//Printing the array "board" in tabular form
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
