public class Solution {
    public int maxProfit(int[] prices) {
     if (prices.length <= 0) {
			return 0;
		}
		int max = 0;
		/*for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if (prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}*/
		int minElement=Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++){
			max=Math.max(max, prices[i]-minElement);
			minElement=Math.min(minElement, prices[i]);
		}
		return max;
    }
}