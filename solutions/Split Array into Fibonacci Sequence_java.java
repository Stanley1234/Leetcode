class Solution {
    
    private List<Integer> ans = new ArrayList<Integer>();
    private boolean find = false;
    
    
    private void dfs(String str, int from) {
        if (from == str.length()) {
            if (ans.size() >= 3) { find =  true; }
            return;
        }
        
        for (int i = from;i < str.length();i ++) {
            long c = Long.parseLong(str.substring(from, i + 1));
            if (c > Integer.MAX_VALUE) { break; }
            
            int ansNum = ans.size();
            if (ansNum >= 2) {
                if (ans.get(ansNum - 1) + ans.get(ansNum - 2) == (int)c) { 
                    ans.add((int)c);
                    dfs(str, i + 1); 
                    if (find) { break; }
                    ans.remove(ans.size() - 1);
                } 
                else if (ans.get(ansNum - 1) + ans.get(ansNum - 2) < (int)c) { 
                    break; 
                }
            } else {
                ans.add((int)c);
                dfs(str, i + 1); 
                if (find) { break; }
                ans.remove(ans.size() - 1);
            }
            
            if (c == 0) { break; }
        }
    }
    
    public List<Integer> splitIntoFibonacci(String S) {
        dfs(S, 0);
        if (find) { return ans; }
        else { return new ArrayList<Integer>(); }
    }
}