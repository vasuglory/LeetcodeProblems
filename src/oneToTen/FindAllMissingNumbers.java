package oneToTen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindAllMissingNumbers {
	//find all the missing in an array the range will be in (1,n) n is length
	//O(nlogn)
	public static ArrayList<Integer> findAllMissingNums(int[] nums) {
		
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		System.out.println(set);
		
		//check if all numbers in range exist in set. 
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i < nums.length+1; i++) {
			if(!set.contains(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	//in place negation of indices for O(n) space
	public static ArrayList<Integer> negationOfIndices(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int temp = Math.abs(nums[i])-1;
			if(nums[temp]>0) {
				nums[temp] = nums[temp] * -1;
			}
		}
		System.out.println(Arrays.toString(nums));
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			
			if(nums[i]>0) {
				list.add(i+1);
			}
		}
		return list;
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findAllMissingNums(nums));
		int[] nums1 = {4,3,2,7,8,2,3,1};
		
		System.out.println(negationOfIndices(nums1));
	}
}
