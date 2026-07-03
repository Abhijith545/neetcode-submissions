class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        int prev2 = cost[0], prev1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int sum = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = sum;
        }
        return Math.min(prev2, prev1);
    }
}
