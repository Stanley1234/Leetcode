class Solution {
    

    private static int[] R_OFFSET = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] C_OFFSET = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    private boolean withinBoundary(int r, int c, int N) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp1 = new double[N][N];
        double[][] dp2 = new double[N][N];
        dp1[r][c] = 1.0;
        while (K -- > 0) {
            for (int i = 0;i < N;i ++) {
                for (int j = 0;j < N;j ++) {
                    dp2[i][j] = dp1[i][j];
                    dp1[i][j] = 0;
                }
            }
            for (int i = 0;i < N;i ++) {
                for (int j = 0;j < N;j ++) {
                    for (int k = 0;k < 8;k ++) {
                        if (withinBoundary(i + R_OFFSET[k], j + C_OFFSET[k], N)) {
                            dp1[i][j] += dp2[i + R_OFFSET[k]][j + C_OFFSET[k]] / 8;
                        }
                    }
                }
            }
        }
        double sum = 0.0;
        for (int i = 0;i < N;i ++) {
            for (int j = 0;j < N;j ++) {
                sum += dp1[i][j];
            }
        }
        return sum;
    }
}