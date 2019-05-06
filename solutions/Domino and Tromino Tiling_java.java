class Solution {
    /*
        A Math 249 problem:
        dp[1] = 1
        dp[2] = 2
        dp[n] = dp[n - 1] + dp[n - 2] + 2 (dp[n - 3] + dp[n - 4] + ... + dp[0] )
    
    */
    
    public int numTilings(int N) {
        if (N == 1) { return 1; }
        if (N == 2) { return 2; }
        if (N == 3) { return 5; }
        
        final int mod = 1000000007;
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4;i <= N;i ++) {
            dp[i] = ((2 * (dp[i - 1]  % mod)) % mod + dp[i - 3] % mod) % mod;
        }
        return dp[N];
    }
}