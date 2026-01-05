package oneToTen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SmallerThanTheCurrentNumberCount {
 /* *
  	input nums = [8,1,2,2,3]
  	output = [4,0,1,1,3]
  	don't count the number that is equal to it, count if it is only less than
  */
	public static ArrayList<Integer> bruteForce(int[] nums){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int count = 0;
			for(int j = 0; j < nums.length; j++) {
				if(nums[i] != nums[j] && nums[j] < nums[i]) {
					count++;
				}
			}
			list.add(count);
				
		}
		return list;
	}
	
	public static ArrayList<Integer> usingHashMap(int[] nums){
		//[8,1,2,2,3] -> [4,0,1,1,3]
		int[] copy = nums.clone();
		HashMap<Integer,Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		//[1,2,2,3,8]
		//map -> {(1,0),(2,1),(3,3),(8,4)}
		Arrays.sort(copy);
		for(int i = 0; i < copy.length; i++) {
			if(!map.containsKey(copy[i])) {
				map.put(copy[i], i);
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			list.add(map.get(nums[i]));
		}
		return list;
		
	}
	
	public static ArrayList<Integer> countIndices(int[] nums){
		
		ArrayList<Integer> list = new ArrayList<>();
		int[] count = new int[102];
		for(int i = 0; i < nums.length; i++) {
			count[nums[i]+1] = count[nums[i]+1] + 1;
		}
		System.out.println(Arrays.toString(count));
		
		for(int i = 1; i < count.length-1; i++) {
			count[i] = count[i] + count[i-1];
		}
		System.out.println(Arrays.toString(count));
		
		for(int i = 0; i < nums.length; i++) {
			list.add(count[nums[i]]);
		}
		return list;	
	}
	public static void main(String[] args) {
//		int[] nums = {8,1,2,2,3};
//		System.out.println(bruteForce(nums));
//		System.out.println("-------------------");
//		int[] nums1 = {6,5,4,8};
//		System.out.println(usingHashMap(nums1));
		
		int[] nums2 = {8,1,2,2,3};
		System.out.println(countIndices(nums2));
	}
}
