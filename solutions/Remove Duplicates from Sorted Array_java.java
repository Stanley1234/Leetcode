class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int head = 0, cur = 1;
        int last = nums[0];
        
        while (cur < nums.length) {
            if (nums[cur] != last) {
                last = nums[cur];
                nums[++ head] = nums[cur];
            }
            cur ++;
        }
        
        return head + 1;
    }
}