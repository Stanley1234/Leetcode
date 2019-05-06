class Solution {
    public int mySqrt(int x) {
        // f(x) = x * x - n;   
        // f'(x) = 2 * x;
        // x_{n+ 1} = x_{n} - f(x_{n})  /f'(x_{n})
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= (long)x && (mid + 1) * (mid + 1) > (long)x) { return (int)mid; }
            if (mid * mid < (long)x) { left = mid + 1; }
            else { right = mid - 1; }
        }
        return 0;
    }
}