class Solution {
    public int climbStairs(int n) {
        int prev1 = 1, prev2 = 0, steps = 0;
        for (int i = 1; i <= n; i++) {
            steps = prev1 + prev2;
            prev2 = prev1;
            prev1 = steps;
        }
        return steps;
    }
}
