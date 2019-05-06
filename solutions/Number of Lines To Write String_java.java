class Solution {
    public int[] numberOfLines (int[] widths, String str) {
      int numOfLines = 1;
      int widthUsedOnCurrentLine = 0;

      for (char letter : str.toCharArray()) {
         if (widthUsedOnCurrentLine + widths[letter - 'a'] > 100) {
            numOfLines++;
            widthUsedOnCurrentLine = widths[letter - 'a'];
         } else {
            widthUsedOnCurrentLine += widths[letter - 'a'];
         }
      }
      return new int[] {numOfLines, widthUsedOnCurrentLine};
   }
}