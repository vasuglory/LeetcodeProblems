package oneToTen;

import java.util.HashSet;

public class OneContainsDuplicates {
	// I used loop within loop so it O(n^2) time complexity in worst case.
	public boolean containsDuplicatesMine(int[] array) {
		for(int i = 0; i < array.length;i++) {
			for(int j = i+1; j < array.length; j++) {
				if(array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsDuplicatesUsingSet(int[] array) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < array.length; i++) {
			if(set.contains(array[i])) {
				return true;
			}
			set.add(array[i]);
		}
		return false;
	
	}
	public static void main(String[] args) {
		//return true if you found duplicates else false
		OneContainsDuplicates og = new OneContainsDuplicates();
		int[] array = {1,2,3,1};
		boolean result = og.containsDuplicatesMine(array);
		System.out.println(result);
		int[] array1 = {14,55,67,45,67,89,14};
		boolean result1 = og.containsDuplicatesUsingSet(array1);
		System.out.println("using set: "+result1);
	}
}
