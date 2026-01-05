package oneToTen;

public class BestTimeToBuyAndSellStock {
	public int MySolution(int[] array) {
		int length = array.length - 1;
		int minIndex = 0;
		int maxIndex = minIndex + 1;
		
		for(int i = 0; i <= length; i++) {
			if(array[i]<array[minIndex]) {
				minIndex = i;
			}
		}
		if(minIndex < length && minIndex != length) {
			for(int i = maxIndex; i <= length; i++) {
				if(array[i]>array[maxIndex]) {
					maxIndex = i;
				}
			}
		}
		else {
			return 0;
		}
		return array[maxIndex] - array[minIndex];
	}
	
	public int usingTwoPointers(int[] prices) {
		int length = prices.length;
		int maxProfit = 0;
		int l = 0;
		int r = 1;
		for(int i = 0; i < length-1; i++) {
			if(prices[l] < prices[r]) {
				int check = prices[r] - prices[l];
				if(check > maxProfit) {
					maxProfit = check;
				}
			} else {
				l+=1;
			}
			r+=1;
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		int i = b.MySolution(new int[] {7,5,3,6,8});
		System.out.println(i);
		int p = b.usingTwoPointers(new int[] {10,9,8,6,4,40});
		System.out.println(p);
	}
}
