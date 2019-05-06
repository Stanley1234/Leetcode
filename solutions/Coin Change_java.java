class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0 || coins.length == 0) return -1;
        
        int[] dp = new int[amount + 1];
        for (int i = 1;i <= amount;i ++) {
            dp[i] = -1;
            for (int j = 0;j < coins.length;j ++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1) 
                        dp[i] = dp[i - coins[j]] + 1;
                    else
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return (int)dp[amount];
    }
}