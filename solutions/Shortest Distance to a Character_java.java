class Solution {
   private static final int NONOVERFLOW_NEG_INF = -20000;
   private static final int NONOVERFLOW_POS_INF = 1000000;

   public int[] shortestToChar(String str, char c) {
      int left = NONOVERFLOW_NEG_INF, right = str.indexOf(c);
      int[] dist = new int[str.length()];

      for (int i = 0;i < str.length();i ++) {
         if (str.charAt(i) == c) {
            dist[i] = 0;
            left = i;  // only move left pointer
         } else {
            if (left >= right) {   // right pointer needs to be updted
               int nextPos = str.indexOf(c, left + 1);
               right = (nextPos == -1 ? NONOVERFLOW_POS_INF : nextPos);
            }
            dist[i] = Math.min(i - left, right - i);
         }
      }
      return dist;
   }
}