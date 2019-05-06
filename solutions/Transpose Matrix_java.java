class Solution {
    public int[][] transpose(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] newMatrix = new int[c][r];
        
        for (int j = 0;j < c;j ++) {
            for (int i = 0;i < r;i ++) {
                newMatrix[j][i] = A[i][j];
            }
        }
        return newMatrix;
    }
}