class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastOne = -1;
        while (n > 0) {
            if (lastOne == n % 2) {
                return false;
            }
            lastOne = n % 2;
            n /= 2;
        }
        return true;
    }
}