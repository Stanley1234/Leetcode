class Solution {
    private static final int NOT_EXIST = -1;

   private static final int DUPLICATE = -2;

   public int firstUniqChar(String s) {
      int[] posOfChars = new int[26];
      Arrays.fill(posOfChars, NOT_EXIST);

      for (int i = 0;i < s.length();i ++) {
         if (posOfChars[s.charAt(i) - 'a'] == NOT_EXIST) {
            posOfChars[s.charAt(i) - 'a'] = i;
         } else if (posOfChars[s.charAt(i) - 'a'] != NOT_EXIST) {
            posOfChars[s.charAt(i) - 'a'] = DUPLICATE;
         }
      }

      int smallestPosNonRepeating = Integer.MAX_VALUE;
      for (int i = 0;i < 26;i ++) {
         if (posOfChars[i] != NOT_EXIST && posOfChars[i] != DUPLICATE
            && posOfChars[i] < smallestPosNonRepeating) {
            smallestPosNonRepeating = posOfChars[i];
         }
      }
      if (smallestPosNonRepeating == Integer.MAX_VALUE) {
         return -1;
      }
      return smallestPosNonRepeating;
   }
}