class Solution {
    public boolean isAnagram(String s, String t) {
      int[] count = new int[26];
      for (char ch : s.toCharArray()) {
         count[ch - 'a']++;
      }

      for (char ch : t.toCharArray()) {
         count[ch - 'a']--;
      }
      
      for (int cnt : count) {
         if (cnt != 0) {
            return false;
         }
      }
      return true;
   }
}