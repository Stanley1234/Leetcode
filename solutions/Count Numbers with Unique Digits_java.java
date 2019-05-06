class Solution {
    
    // define 10^0 = 0
    // count[i] refers to the # of numbers with unique digits within [10^(i - 1), 10^i - 1]
    
    // without dp, this question could be solved by using permutation exactly
    
    private int A(int n, int k) {
        if (k == 0) { return 1; }
        return n * A(n - 1, k - 1);
    }
    
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) { n = 10; }
        
        int sum = 1;
        for (int i = 1;i <= n;i ++) {
            sum += A(10, i - 1) * (11 - i) - A(9, i - 1);
        }
        return sum;
    }
}