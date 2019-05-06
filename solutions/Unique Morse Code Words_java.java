class Solution {
    private static final String[] TRANSFORMATION = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."   
    };
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> allMorseCodes = new HashSet<>();
        for (String word : words) {
            StringBuilder morseBuilder = new StringBuilder();
            for (char letter : word.toCharArray()) {
                morseBuilder.append(TRANSFORMATION[letter - 'a']);
            }
            allMorseCodes.add(morseBuilder.toString());
        }
        return allMorseCodes.size();
    }
}