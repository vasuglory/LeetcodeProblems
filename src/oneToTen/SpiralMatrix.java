package oneToTen;

import java.util.ArrayList;

public class SpiralMatrix {
/* 
 	
 	---->
 	  	0 1 2
 	  	  r
 	0 	1 2 3 |   00,01,02
 t	1 	4 5 6 |   12 22 
 	2 	7 8 9     21 20
 	
 	input: [[1,2,3],[4,5,6],[7,8,9]]
 	output: [1,2,3,6,9,8,7,4,5]
 */
	public static ArrayList<Integer> spiralMatrixBoundaries(int[][] matrix){
		
		ArrayList<Integer> res = new ArrayList<>();
		int top = 0; //first row
		int left = 0; //left column
		int bottom = matrix.length - 1; //last row
		int right = matrix[0].length - 1; //right column
		
		while(top <= bottom && left <= right) {
			//[1,2,3,4]
			//first row left to right
			for(int i = left; i <= right; i++) {
				//left to right
				res.add(matrix[top][i]);
			}
			top++;
			
			//top to bottom
			for(int i = top; i <= bottom; i++) {
				res.add(matrix[i][right]);
			}
			right--;
			
			if(top <= bottom) {
				// right to left
				for(int i = right; i >= left; i--) {
					res.add(matrix[bottom][i]);
				}
				bottom--;
			}
			
			
			if(left <= right) {
				//bottom to top
				for(int i = bottom; i >= top; i--) {
					res.add(matrix[i][left]);
				}
				left++;
			}
			
			
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralMatrixBoundaries(matrix));
		
		
	}
}
