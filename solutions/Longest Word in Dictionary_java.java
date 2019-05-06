class Solution {
        public String longestWord(String[] words) {
        Arrays.sort(words);
        
        List<String> constructedWords = new ArrayList<>();
        
        for (String word : words) {
            if (word.length() == 1) {
                constructedWords.add(word);
                continue;
            }
            
            for (String constructedWord : constructedWords) {
                if (word.length() == constructedWord.length() + 1 
                        && word.startsWith(constructedWord)) {
                    constructedWords.add(word);
                    break;
                }
            }
        }
        
        int ansIndex = -1;
        for (int i = constructedWords.size() - 1;i >= 0;i --) {
            if (ansIndex == -1 || constructedWords.get(i).length() >= constructedWords.get(ansIndex).length()) {
                ansIndex = i;
            }
        }
        
        return ansIndex == -1 ? "" : constructedWords.get(ansIndex);
    }

}