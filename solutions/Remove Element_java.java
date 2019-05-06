class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0;  // points to the next available index
        for (int n : nums) {
            if (n == val) {
                continue;
            }
            nums[head ++] = n;
        }
        return head;
    }
}