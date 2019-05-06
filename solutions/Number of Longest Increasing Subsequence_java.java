class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) { return 0; }
        int[] increasingSeqIndex = new int[nums.length];
        int[] cnt = new int[nums.length];
        
        int biggestIndex = 1;
        for (int i = 0;i < nums.length;i ++) {
            increasingSeqIndex[i] = 1;
            for (int j = i - 1;j >= 0;j --) {
                if (nums[i] > nums[j]) {
                    increasingSeqIndex[i] = Math.max(increasingSeqIndex[i], increasingSeqIndex[j] + 1);
                    biggestIndex = Math.max(biggestIndex, increasingSeqIndex[i]);
                }
            }
            if (increasingSeqIndex[i] == 1) {
                cnt[i] = 1;
            } else {
                for (int j = i - 1;j >= 0;j --) {
                    if (nums[i] > nums[j] && increasingSeqIndex[j] + 1 == increasingSeqIndex[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0;i < nums.length;i ++) {
            if (biggestIndex == increasingSeqIndex[i]) {
                sum += cnt[i];
            }
        }
        return sum;
    }
}