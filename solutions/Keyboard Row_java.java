class Solution {
    private static Set<Character>[] ALPHABETS_PER_LINE = new Set[] {
      new HashSet(Arrays.asList('Q','W','E','R','T','Y','U','I','O','P')),
      new HashSet(Arrays.asList('A','S','D','F','G','H','J','K','L')),
      new HashSet(Arrays.asList('Z','X','C','V','B','N','M'))
   };

   public String[] findWords(String[] words) {
      List<String> targetWords = new ArrayList<>();

      for (String word : words) {
         boolean allOnOneLine = true;

         int lineNum = -1;
         for (int i = 0;i < 3;i ++) {
            System.out.println(word.charAt(0));
            if (ALPHABETS_PER_LINE[i].contains(Character.toUpperCase(word.charAt(0)))) {
               lineNum = i;
               break;
            }
         }

         for (char ch : word.toCharArray()) {
            if (!ALPHABETS_PER_LINE[lineNum].contains(Character.toUpperCase(ch))) {
               allOnOneLine = false;
            }
         }

         // including empty string
         if (allOnOneLine) {
            targetWords.add(word);
         }
      }

      String[] ans = new String[targetWords.size()];
      for (int i = 0;i < targetWords.size();i ++) {
         ans[i] = targetWords.get(i);
      }

      return ans;
   }
}