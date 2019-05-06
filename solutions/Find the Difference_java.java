class Solution {
    public char findTheDifference(String s, String t) {
      int[] count = new int[26];
      for (char ch : s.toCharArray()) {
         count[ch - 'a']++;
      }

      char added = 0;
      for (char ch : t.toCharArray()) {
         count[ch - 'a']--;
         if (count[ch - 'a'] < 0) {
            added = ch;
            break;
         }
      }
      return added;

   }
}