class Solution {
    private int climb(int n, int[] dp) {
        if (n == 0 || n == 1) dp[n] = 1;
        else if (dp[n] == 0) dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return climb(n, dp);
    }
}
