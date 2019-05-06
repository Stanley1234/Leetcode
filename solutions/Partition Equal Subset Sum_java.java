class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0;i < nums.length;i ++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) { return false; }
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i= sum;i >= n;i --) {
                dp[i] |= dp[i - n];
            }
        }
        return dp[sum / 2];
    }
}