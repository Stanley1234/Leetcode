class Solution {
    
    /*
    1. First put all ugly numbers in three groups
    2. Three pointers point at the next possible at each group
    
    */
    
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int cur = 1;
        int[] ugly = new int[n + 1];
        
        ugly[1] = 1;
        for (int i = 2;i <= n;i ++) {
            ugly[i] = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            if (ugly[i] == ugly[p2] * 2) { p2 ++; }
            if (ugly[i] == ugly[p3] * 3) { p3 ++; }
            if (ugly[i] == ugly[p5] * 5) { p5 ++; }
        }
        return ugly[n];
    }
}