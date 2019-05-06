class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) { return 0; }
        if (cost.length == 1) { return cost[0]; }
        
        // dp[i] saves the minimum cost to arrive at the i-th step
        // dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        // dp[0] = dp[1] = 0
        int[] dp = new int[cost.length + 1];
        for (int i = 2;i <= cost.length;i ++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];       
    }
}