class NumMatrix {
    
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
        
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m][n];
        
        // calculate the sum
        sum[0][0] = matrix[0][0];
        for (int i = 1;i < m;i ++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int j = 1;j < n;j ++) {
            sum[0][j] = sum[0][j - 1] + matrix[0][j];
        }
        for (int i = 1;i < m;i ++) {
            for (int j = 1;j < n;j ++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) { return 0; }
    
        if (row1 == 0 && col1 > 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        } else if (row1 > 0 && col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        } else if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        }
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */