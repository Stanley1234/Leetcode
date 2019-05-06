class Solution {
    public int binaryGap(int N) {
      if (N == 0) {
         return 0;
      }

      // number is positive
      // check if there is <= 1 set bit

      int left = 31, right = 0;
      while (left >= 0 && ((N & (1 << left)) == 0)) {
         left --;
      }
      while (right <= 31 && ((N & (1 << right)) == 0)) {
         right ++;
      }

      // only one set bit
      if (left == right) {
         return 0;
      }

      int maxDist = 0;
      int curDist = 0;

      for (int cur = left;cur >= right;cur --) {
         curDist ++;
         maxDist = Math.max(maxDist, curDist);
         if ((N & (1 << cur)) != 0) {
            curDist = 0;
         }
      }
      return maxDist;
   }
}