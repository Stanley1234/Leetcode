class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][][] dp = new int[4][N][N];

        for (int i = 0;i < N;i ++) {
            Arrays.fill(dp[0][i], 1);
            Arrays.fill(dp[1][i], 1);
            Arrays.fill(dp[2][i], 1);
            Arrays.fill(dp[3][i], 1);
        }
        for (int i = 0;i < mines.length;i ++) {
            dp[0][mines[i][0]][mines[i][1]]
                    = dp[1][mines[i][0]][mines[i][1]]
                    = dp[2][mines[i][0]][mines[i][1]]
                    = dp[3][mines[i][0]][mines[i][1]]
                    = 0;
        }

        for (int i = 0;i < N;i ++) {
            // left direction
            for (int j = 1;j < N;j ++) {
                dp[0][i][j] = dp[0][i][j] == 0 ? 0 : 1 + dp[0][i][j - 1];
            }
            // right direction
            for (int j = N - 2;j >= 0;j --) {
                dp[1][i][j] = dp[1][i][j] == 0 ? 0 : 1 + dp[1][i][j + 1];
            }
        }
        for (int j = 0;j < N;j ++) {
            // up direction
            for (int i = N - 2;i >= 0;i --) {
                dp[2][i][j] = dp[2][i][j] == 0 ? 0 : 1 + dp[2][i + 1][j];
            }
            // down direction
            for (int i = 1;i < N;i ++) {
                dp[3][i][j] = dp[3][i][j] == 0 ? 0 : 1 + dp[3][i - 1][j];
            }
        }

        int ans = 0;
        for (int i = 0;i < N;i ++) {
            for (int j = 0;j < N;j ++) {
                ans = Math.max(ans,
                        Math.min(dp[0][i][j],
                                Math.min(dp[1][i][j],
                                        Math.min(dp[2][i][j], dp[3][i][j]))));
            }
        }
        return ans;
    }
} 