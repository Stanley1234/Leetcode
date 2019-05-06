class Solution {
    public int reverse(int x) {
        boolean sign = (x >= 0);   // true if positive
        if (!sign) {
            x = -x;
        }
        
        long n = 0;
        while (x > 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        if (!sign) {
            n = -n;
        }
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            n = 0;
        } 
        return (int)n;
    }
}