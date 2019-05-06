class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int len = matrix.length;

        for(int k = 0;k < len / 2;k ++) {
            int s = k;
            while(s < len - k - 1) {
                int tmp = matrix[k][s];
                matrix[k][s] = matrix[len - s - 1][k];
                matrix[len - s - 1][k] = matrix[len - k - 1][len - s - 1];
                matrix[len - k - 1][len - s - 1] = matrix[s][len - k - 1];
                matrix[s][len - k - 1] = tmp;

                s ++;
            }
        }
    }
}