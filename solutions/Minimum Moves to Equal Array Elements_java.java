class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for (int i = 1;i < nums.length;i ++) {
            moves += (nums[i] - nums[0]);
        }
        return moves;
    }
    // 1 2 3 => 1 2 2 => 
}