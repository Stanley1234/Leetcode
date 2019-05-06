class Solution {
    private int getNumOfDigits(int N) {
        if (N == 0) { return 1; }
        int cnt = 0;
        while (N > 0) {
            N /= 10;
            cnt ++;
        }
        return cnt;
    }

    private String repeat(char i, int k) {
        StringBuilder sb = new StringBuilder();
        while (k -- > 0) {
            sb.append(i);
        }
        return sb.toString();
    }

    public int monotoneIncreasingDigits(int N) {
        String ans = "";
        int numOfDigits = getNumOfDigits(N);

        Loop:
        for (int i = 0;i < numOfDigits;i ++) {
            for (char j = '1';j <= '9';j ++)
            if (Integer.parseInt(ans + repeat(j, numOfDigits - i)) > N) {
                ans += (char)(j - 1);
                continue Loop;
            }
            ans += '9';
        }
        return Integer.parseInt(ans);
    }
}