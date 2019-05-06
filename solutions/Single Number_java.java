class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        for (int n : nums) {
            one ^= n;
        }
        return one;
    }
}