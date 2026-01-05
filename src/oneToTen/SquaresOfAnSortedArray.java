package oneToTen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class SquaresOfAnSortedArray {
	/*
	 given an array in non-decreasing order
	 return an array of squares of each number sorted in decreasing order.
	 */
	
	public int[] mine(int[] nums){
		//traverse the array and square
		for(int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		//sort the array
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i]<nums[j] || nums[i] == nums[j]) {
					nums[i] = nums[i];
				}
				else {
					int element = nums[i];
					nums[i] = nums[j];
					nums[j] = element;
				}
			}
		}
		return nums;
	}
	
	/*reverse and merge
	 	1. find where we have positive number
	 	2. reverse all negative numbers
	 	3. then square them, it will be non-descending order so no need for sorting
	 */
	
	//1
	
	public ArrayList<Integer> reverseAndMerge(int[] nums) {
		//[-7,-5,-4,-1,0,3,10]
		//[-1,-4,-5,-7,0,3,10]
		int positiveValueIndex = 0; //4
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0 || nums[i] > 0) {
				
				positiveValueIndex = i;
				break;
			}
		}
		
		//reverse all negative values
		if(positiveValueIndex!=0) {
			int range = positiveValueIndex;
			int first = 0;
			int last = positiveValueIndex - 1;
			for(int i = 0; i < range; i++) {
				if(range>=2) {
					int element = nums[first];
					nums[first] = nums[last];
					nums[last] = element;
				}
				range = range - 2;
				first++;
				last--;
			}
			
		}
//		[-1,-7,-5,0,3,10]
		//merging two sorted lists.
		ArrayList<Integer> list = new ArrayList<Integer>();
		int left = 0;
		int right = positiveValueIndex; //5
		while(left < positiveValueIndex && right < nums.length) {
			
			int abs = nums[left] * -1;
			
			
			if(abs < nums[right]) {
				list.add(nums[left]);
				nums[left] = 0;
				left++;
			}
			else if(abs == nums[right]) {
				list.add(nums[left]);
				list.add(nums[right]);
				left++;
				right--;
			}
			else {
				list.add(nums[right]);
				nums[right] = 0;
				right++;
			}
		}
		
		//check unadded elements
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				list.add(nums[i]);
			}
		}
		
		//square and merge??
		for(int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i) * list.get(i));
		}

		System.out.println(Arrays.toString(nums));
		return list;
	}


	public ArrayDeque<Integer> twoPointersWhoGreatest(int[] nums) {
		//-4,-1,3,10
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		int l = 0;
		int r = nums.length - 1;
		while(l<=r) {
			int left = nums[l];
			int right = nums[r];
			if(nums[l] < 0) {
				left = -1 * nums[l];
			}
			if(nums[r] < 0) {
				right = -1 * nums[r];
			}
			
			if(left > right) {
				deque.addFirst(left * left);
				l+=1;
			}
			else {
				deque.addFirst(right * right);
				r-=1;
			}
		}
	
		
		return deque;
	}

	public static void main(String[] args) {

		
		SquaresOfAnSortedArray sq = new SquaresOfAnSortedArray();
		int[] nums = {-7,-5,-4,-1,0,3,10};
//		System.out.println(Arrays.toString(sq.mine(nums)));
//		System.out.println(Arrays.toString(nums));
		System.out.println("----");
		System.out.println(sq.reverseAndMerge(nums));
		
		System.out.println("-----");
		System.out.println(sq.twoPointersWhoGreatest(new int[] {-4,-1,3,10}));
	}
}
 