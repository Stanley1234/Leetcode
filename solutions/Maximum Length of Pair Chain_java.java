class Solution {
    
    private int first(int[] pair) {
        return pair[0];
    }
    
    private int second(int[] pair) {
        return pair[1];
    }
    
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if (first(p1) == first(p2)) {
                    return second(p1) - second(p2);
                }
                return first(p1) - first(p2);
            }
        });
        
        int[] dp = new int[pairs.length];
        int maxLen = 1;
        
        dp[0] = 1;
        for (int i = 1;i < pairs.length;i ++) {
            dp[i] = 1;
            for (int j = 0;j < i;j ++) {
                if (second(pairs[j]) < first(pairs[i]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}