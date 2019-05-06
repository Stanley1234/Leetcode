class Solution {
    
    public boolean isNumber(String s) {
        
        // if a sign exists until next 'e' occurs
        boolean hasSign = false;
        
        // if a dot exists
        boolean hasDot = false;
        
        // if a exp exists
        boolean hasExp = false;
        
        // if a digit exists until next 'e', '.' occurs
        boolean hasDigit = false;
        
        // if for the whole string, the digit exists or not
        boolean globExistsDigit = false;
        
        int left = 0, right = s.length() - 1;
        
        // move left, right to the first / last place having nonwhitespace
        while (left < right && Character.isWhitespace(s.charAt(left))) {
            left ++;
        }
        while (left < right && Character.isWhitespace(s.charAt(right))) {
            right --;
        }
        
        while (left <= right) {
            char ch = s.charAt(left);
            
            if (!Character.isDigit(ch) && ch != 'e' && ch != '.' && ch != '+' && ch != '-') {
                return false;
            }
            
            switch (ch) {
                case 'e':
                    if (hasExp || (hasDot && !globExistsDigit) || 
                       (!hasDot && !hasDigit)) {
                        return false;
                    } 
                    hasDigit = false;
                    hasExp = true;
                    hasSign = false;
                    break;
                case '.':
                    if (hasDot || hasExp) {
                        return false;
                    }
                    hasDot = true;
                    hasDigit = false;
                    break;
                case '+':
                case '-':
                    if (hasSign || hasDigit || (hasDot && !hasExp)) {
                        return false;
                    }
                    hasSign = true;
                    break;
                default:
                    globExistsDigit = true;
                    hasDigit = true;
                    break;
            }
            left ++;
        }
       
        // can only end with
        // 1. digits
        // 2. a dot with digit prior
        if (Character.isDigit(s.charAt(right)) || 
            (s.charAt(right) == '.' && globExistsDigit)) {
            return true;
        }
        return false;
    }
}