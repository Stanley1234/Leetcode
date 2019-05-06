class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // convert the problem to 'equal partition' problem
        // pos - neg = target
        // pos - neg + pos + neg = target + sum
        // pos = (target + sum) / 2
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < target) { return 0; }
        if ((target + sum) % 2 == 1) { return 0; }
        // since the sum of elements in the given array will not exceed 1000, 
        // the achievable target will not exceed 1000
        // thus the newTarget <= 10000
        
        int newTarget = (target + sum) / 2;
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;
        for (int i = 0;i < nums.length;i ++) {
            for (int j = newTarget;j >= nums[i];j --) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[newTarget];
    }
}