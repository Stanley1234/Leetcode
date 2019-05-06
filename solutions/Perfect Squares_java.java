class Solution {
    
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1;i * i <= n;i ++) {
            squares.add(i * i);
        }
        
        int[] dp = new int[n + 1];
        for (int i = 1;i <= n;i ++) {
            dp[i] = Integer.MAX_VALUE;
            for (int square : squares) {
                if (square > i) { break; }
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }
}