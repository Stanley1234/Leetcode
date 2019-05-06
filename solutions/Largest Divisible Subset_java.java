class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        
        int[] dp = new int[nums.length];
        int[] next = new int[nums.length];
        Arrays.sort(nums);
        
        int maxIndex = nums.length - 1, maxDp = 1;
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2;i >= 0;i --) {
            dp[i] = 1;
            for (int j = i + 1;j < nums.length;j ++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    next[i] = j;
                    if (maxDp < dp[i]) {
                        maxDp = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        int cur = maxIndex;
        List<Integer> ans = new ArrayList<>();
        while (maxDp -- > 0) {
            ans.add(nums[cur]);
            cur = next[cur];
        }
        return ans;
    }
}