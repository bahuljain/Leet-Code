public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;

		int maxProfit = 0, min = prices[0], max = prices[0];

		for (int i = 1; i < prices.length; i++) {

			if (max < prices[i]) {
				max = prices[i];
			} else if (prices[i] < min) {
				int profit = max - min;
				maxProfit = (profit > maxProfit) ? profit : maxProfit;
				min = prices[i]; max = prices[i];
			}

		}
		int profit = max - min;
		maxProfit = (profit > maxProfit) ? profit : maxProfit;

		return maxProfit;

	}
}
