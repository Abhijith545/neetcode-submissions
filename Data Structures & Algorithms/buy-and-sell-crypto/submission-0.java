class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length - 1;
        int min = prices[n], max = 0;
        for (int i = n; i >= 0; i--) {
            max = Math.max(max, min - prices[i]);
            min = Math.max(min, prices[i]);
        }
        return max;
    }
}
