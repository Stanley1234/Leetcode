class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        
        int insertIndex = 0, curIndex = 0;
        while (curIndex < nums.length) {
            if (nums[curIndex] != 0) {
                nums[insertIndex] = nums[curIndex];
                insertIndex ++;
            }
            curIndex ++;
        }
        while (insertIndex < nums.length) {
            nums[insertIndex ++] = 0;
        }
    }
}