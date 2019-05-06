class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0)
            return;
        int r = matrix.length;
        int c = matrix[0].length;

        boolean hor00 = false;
        boolean ver00 = false;

        for(int i = 0;i < r;i ++) {
            for(int j = 0;j < c;j ++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                    if(i == 0) hor00 = true;
                    if(j == 0) ver00 = true;
                }
            }
        }
        for(int i = 1;i < r;i ++)
            if(matrix[i][0] == 0)
                Arrays.fill(matrix[i], 0);
        for(int j = 1;j < c;j ++)
            if(matrix[0][j] == 0)
                for(int i = 0;i < r;i ++)
                    matrix[i][j] = 0;

        if(ver00) for(int i = 0;i < r;i ++) matrix[i][0] = 0;
        if(hor00) for(int j = 0;j < c;j ++) matrix[0][j] = 0;

    }
}