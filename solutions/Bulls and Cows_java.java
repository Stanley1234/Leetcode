class Solution {
    public String getHint(String secret, String guess) {
      char[] secretChars = secret.toCharArray();
      char[] guessChar = guess.toCharArray();

      int bulls = 0, cows = 0;

      Map<Character, Integer> secretCharCounter = new HashMap<>();
      for (char ch : secretChars) {
         secretCharCounter.put(ch, secretCharCounter.getOrDefault(ch, 0) + 1);
      }

      // match the exact digits
      for (int i = 0;i < secretChars.length;i ++) {
         if (secretChars[i] == guessChar[i]) {
            bulls ++;
            secretCharCounter.put(secretChars[i], secretCharCounter.get(secretChars[i]) - 1);
         }
      }

      for (int i = 0;i < secretChars.length;i ++) {
         if (secretChars[i] == guessChar[i]) {
            continue;
         }
         if (secretCharCounter.containsKey(guessChar[i]) && secretCharCounter.get(guessChar[i]) > 0) {
            cows ++;
            secretCharCounter.put(guessChar[i], secretCharCounter.get(guessChar[i]) - 1);
         }
      }

      return bulls + "A" + cows + "B";
   }
}