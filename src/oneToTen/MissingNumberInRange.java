package oneToTen;

import java.util.Arrays;

public class MissingNumberInRange {
	/* 
	 * in 0 to n range return only missing number if it is missing.
	 * input = [0,1,3]
	 * range = length of array -> 3
	 * from range (0,3) -> 1,2,3
	 * So one number will be for sure missing.
	 * In range (0,9) all 0 to 9 will be there but in an array length of 9 means,
	 	0 to 8 so it's either one number in 0 to 8 is missing or 9 is missing.
	*/			
	public static int missingNumberMine(int[] array) {
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		for(int i = 0 ; i < array.length; i++) {
			if(i != array[i]) {
				return array[i] - 1;
			}
			if(array[i] == array.length - 1) {
					return array[i] + 1;
				}
			}
		return -1;
		}
	//using sum formula like python range
	//O(n) time complexity.
	public static int missingNumSum(int[] nums) {
		//the actual sum of numbers till n should be.
		int n = nums.length;
		int actualSum = n * (n+1)/2;
		System.out.println("Actual sum of nums: "+actualSum);
		//the sum for given nums:
		int total = 0;
		for(int i = 0; i < nums.length; i++){
			total = total + nums[i];
		}
		System.out.println("The sum of given nums: "+total);
		return actualSum-total;
	}
	
	public static void main(String[] args) {
		int[] array = {0,1,2,3,4,5,6,7,8};
		int result = missingNumberMine(array);
		System.out.println("using mine: "+result);
		int[] nums = {3,0,1,2,5};
		System.out.println("using sum formula: "+missingNumSum(nums));
	}

	
}
