class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int n : nums) {
            sum -= n;
        }
        return sum;
    }
}