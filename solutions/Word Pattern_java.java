class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s+");
        if (words.length != pattern.length()) {
            return false;
        }
        
        Map<Character, String> patternMap = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        
        patternMap.put(pattern.charAt(0), words[0]);
        usedWords.add(words[0]);
        
        for (int i = 1;i < pattern.length();i ++) {
            if (!patternMap.containsKey(pattern.charAt(i))) {
                if (usedWords.contains(words[i])) {
                    return false;
                }
                patternMap.put(pattern.charAt(i), words[i]);
                usedWords.add(words[i]);
            } else {
                if (!patternMap.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}