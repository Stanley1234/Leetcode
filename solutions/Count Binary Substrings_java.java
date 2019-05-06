class Solution {
    public int countBinarySubstrings(String s) {
      int prevRunning = 0;
      int curRunning = 0;
      char curNum = s.charAt(0);

      int count = 0;

      for (int i = 0;i < s.length();i ++) {
         if (s.charAt(i) == curNum) {
            curRunning ++;
         } else {
            count += Math.min(prevRunning, curRunning);

            curNum = s.charAt(i);
            prevRunning = curRunning;
            curRunning = 1;
         }
      }
      count += Math.min(prevRunning, curRunning);
      return count;
   }
}