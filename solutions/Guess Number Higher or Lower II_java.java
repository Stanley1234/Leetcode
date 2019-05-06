class Solution {
    /*
    1 2 3 4 5 6

    0 0 0 0 0 0
    1 2 3 4 5
    2 3 4 5
    4 6 8
    6 8
    8
    */

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];  
        // dp[i][j] saves "the maximum money I need to pay when I need to guess a number in [i, j] among all             possible situations"
        // dp[i][i] = i
        // dp[i][i + 1] = i
        // dp[i][j] = max{ k + max { dp[i][k - 1], dp[k + 1][j] }  }
        // when thinking about the dp equation, think it as "I choose k, but unfortunately, k is not the correct             number"
        
        for (int k = 1;k <= n;k ++) {  // length of interval
            for (int s = 1;s <= n - k + 1;s ++) {  // starting point
                int t = s + k - 1;
                
                if (s == t) {
                    dp[s][t] = 0;
                } else if (s == t - 1) {
                    dp[s][t] = s;
                } else if (s == t - 2)  {
                    dp[s][t] = s + 1;
                } else {
                    //dp[s][t] = Math.max(s + Math.max(s + 1, t), t + Math.max(s, t - 1));   // if guess the                         number at two end points
                    dp[s][t] = Integer.MAX_VALUE;
                    for (int j = s + 1;j <= t - 1;j ++) {
                        dp[s][t] = Math.min(dp[s][t], j + Math.max(dp[s][j - 1], dp[j + 1][t])); 
                    }
                }
            }
        }
        
        return dp[1][n];
    }
}