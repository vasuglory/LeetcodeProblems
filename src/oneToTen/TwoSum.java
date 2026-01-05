package oneToTen;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
 /* 
  target = 9
  input nums = [2,7,11,15]
  output = [0,1]
  nums[0] + nums[1] => 9
  return array of indices
 */
	//in worst case loop two times n and n-1 means O(n2) time complexity
	public static ArrayList<Integer> bruteForce(int[] nums, int target){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					list.add(i);
					list.add(j);
				}
			}
		}
		return list;
	}
	
	//using hashmap
	//[2,11,7,15] -> 9
	public static ArrayList<Integer> usingHashMap(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int left = target - nums[i];
			if(map.containsKey(left)) {
				list.add(i);
				list.add(map.get(left));
				break;
			}
			map.put(nums[i], i);
			System.out.println(map);
		}
		return list;
	}
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(bruteForce(nums, target));
		int[] nums1 = {2,7,11,15};
		int target1 = 9;
		System.out.println(usingHashMap(nums1, target1));
	}
	
}
 