class Solution {
    
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        
        StringBuilder sb = new StringBuilder(s);
        
        while (left < right) {
            if (!isVowel(sb.charAt(left))) {
                left ++;
            }
            if (!isVowel(sb.charAt(right))) {
                right --;
            }
            if (isVowel(sb.charAt(left)) && isVowel(sb.charAt(right))) {               
                char tmp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, tmp);
                
                left ++;
                right --;
            }
        }
        return sb.toString();
    }
}