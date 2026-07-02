class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length - 1;
        int sellPrice = prices[n], maxProfit = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] < sellPrice) maxProfit = Math.max(maxProfit, sellPrice - prices[i]);
            else sellPrice = Math.max(sellPrice, prices[i]);
        }
        return maxProfit;
    }
}
