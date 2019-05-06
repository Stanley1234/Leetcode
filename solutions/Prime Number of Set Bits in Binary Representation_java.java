class Solution {
    
    private static Set<Integer> PRIMES = new HashSet<>();
    
    {
        PRIMES.add(2);
        PRIMES.add(3);
        PRIMES.add(5);
        PRIMES.add(7);
        PRIMES.add(11);
        PRIMES.add(13);
        PRIMES.add(17);
        PRIMES.add(19);
        PRIMES.add(23);
        PRIMES.add(29);
        PRIMES.add(31);        
    }
    
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int i = L;i <= R;i ++) {
            int count = 0;
            int n = i;
            while (n > 0) {
                count += (n & 1);
                n >>= 1;
            }
            if (PRIMES.contains(count)) {
                ans ++;
            }
        }
        return ans;
    }
}