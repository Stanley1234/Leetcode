class Solution {
    public boolean judgeSquareSum(int c) {
        int upperbound = (int)Math.ceil(Math.sqrt(c));
        int lowerbound = 0;
        while (lowerbound <= upperbound) {
            if (lowerbound * lowerbound + upperbound * upperbound == c) {
                return true;
            }
            if (lowerbound * lowerbound + upperbound * upperbound < c) {
                lowerbound ++;
            } else {
                upperbound --;
            }
        }
        return false;
    }
}