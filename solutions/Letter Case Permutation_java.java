class Solution {
    
    private List<String> ans = new ArrayList<>();
    
    private void generate(StringBuilder sb, int index) {
        if (index == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        if (!Character.isAlphabetic(sb.charAt(index))) {
            generate(sb, index + 1);
        } else {
            generate(sb, index + 1);
            sb.setCharAt(index, Character.toUpperCase(sb.charAt(index)));
            generate(sb, index + 1);
            sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));
        }
    }
    
    public List<String> letterCasePermutation(String input) {
        StringBuilder sb = new StringBuilder(input.toLowerCase());
        generate(sb, 0);
        return ans;
    }
}