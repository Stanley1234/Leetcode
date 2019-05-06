class Solution {
    public boolean detectCapitalUse(String word) {
        return word.toUpperCase().equals(word) || word.toLowerCase().equals(word) || 
            ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' && word.substring(1).toLowerCase().equals(word                .substring(1)));
    }
}