class Solution {
    public int longestPalindrome(String s) {
      Map<Character, Integer> charCount = new HashMap<>();
      for (char ch : s.toCharArray()) {
         charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
      }

      int lengthOfPalindrome = 0;
      for (char ch : charCount.keySet()) {
         int numOfCh = charCount.get(ch);
         if (numOfCh >= 2) {
            lengthOfPalindrome += numOfCh - numOfCh % 2;
            charCount.put(ch, numOfCh % 2);
         }
      }
      
      for (int numOfLetter : charCount.values()) {
         if (numOfLetter == 1) {
            lengthOfPalindrome ++;
            break;
         }
      }
      return lengthOfPalindrome;
   }
}