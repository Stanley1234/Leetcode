class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;   // impossible to reshape
        }
        int curR = 0, curC = 0;
        int[][] newMatrix = new int[r][c];
        for (int i = 0;i < r;i ++) {
            for (int j = 0;j < c;j ++) {
                newMatrix[i][j] = nums[curR][curC ++];
                if (curC == n) {
                    curC = 0;
                    curR ++;
                }
            }
        }
        return newMatrix;
    }
}