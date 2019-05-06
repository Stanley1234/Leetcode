class Solution {
   public int countPrimes(int n) {
      if (n <= 2) {
         return 0;
      }

      boolean[] isNotPrime = new boolean[n];
      isNotPrime[0] = isNotPrime[1] = true;

      int numOfPrime = 0;
      for (int i = 2;i < n;i ++) {
         if (!isNotPrime[i]) {
            for (int j = 2;j * i < n;j ++) {
               isNotPrime[j * i] = true;
            }
            numOfPrime ++;
         }
      }
      return numOfPrime;
   }
}