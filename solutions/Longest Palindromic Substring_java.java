class Solution {
    private boolean[][] create2DArray(int i, int j) {
        boolean[][] arr = new boolean[i][];
        for(int t = 0;t < i;t ++)
            arr[t] = new boolean[j];
        return arr;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return null;

        boolean dp[][] = create2DArray(s.length(), s.length());

        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = true;
        for (int k = 3; k <= s.length(); k++)
            for (int i = 0; i < s.length() - k + 1; i++)
                if (s.charAt(i) == s.charAt(i + k - 1)  && dp[i + 1][i + k - 2])
                    dp[i][i + k - 1] = true;

        for (int k = s.length(); k >= 1; k--)
            for (int i = 0; i < s.length() - k + 1; i++) {
                if (dp[i][i + k - 1]) {
                    return s.substring(i, i + k);
                }
            }
        return null;
    }
}