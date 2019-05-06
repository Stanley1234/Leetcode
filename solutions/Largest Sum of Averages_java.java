class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        
        int[] sum = new int[A.length];
        double[][] dp = new double[A.length][K + 1];
        sum[0] = A[0];
        for (int i = 1;i < A.length;i ++) {
            sum[i] = sum[i - 1] + A[i];
        }
        
        // dp[i][j] refers to the max average if partition the integers before i-th index into j partitions
        // dp[i][j] = max { dp[u][j - 1] }
        
        for (int i = 0;i < A.length;i ++) {
            dp[i][1] = (double)sum[i] / (i + 1);
            for (int p = 2;p <= K && p <= i + 1;p ++) {  // partition
                for (int j = i - 1;j >= 0;j --) {
                   dp[i][p] = Math.max(dp[i][p], dp[j][p - 1] + (double)(sum[i] - sum[j]) / (i - j));
                }
            }
        }
        double maxLen = 0;
        for (int i = 1;i <= K;i ++) {
            maxLen = Math.max(maxLen, dp[A.length - 1][i]);
        }
        return maxLen;        
    }
}