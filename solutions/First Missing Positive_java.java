class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        
        int cur = 0;
        while (cur < nums.length && nums[cur] <= 0) {
            cur ++;
        }
        
        int next = 1;
        while (cur < nums.length && nums[cur] == next) {
            
            cur ++;
            while (cur < nums.length && nums[cur] == nums[cur - 1]) {
                cur ++;
            }
            next ++;
        }
        return next;
    }
}