class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return M;
        }
        int m = M.length, n = M[0].length;
        
        int[][] smoothedImage = new int[m][n];
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                
                int sum = 0;
                int cellsNearby = 0;
                
                for (int r = i - 1;r <= i + 1;r ++) {
                    if (r < 0 || r >= m) {
                        continue;
                    }
                    
                    for (int c = j - 1;c <= j + 1;c ++) {
                        if (c < 0 || c >= n) {
                            continue;
                        }
                        sum += M[r][c];
                        cellsNearby ++;
                    }
                }
                
                smoothedImage[i][j] = (int)Math.floor(((double)sum) / cellsNearby);
            }
        }
        return smoothedImage;
    }
}