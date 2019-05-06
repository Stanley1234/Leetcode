class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        boolean[] used = new boolean[s.length];
        int contentCnt = 0;
        
        for (int i = g.length - 1;i >= 0;i --) {
            for (int j = 0;j < s.length;j ++) {
                if (used[j]) { continue; }
                // always use the smamllest possible to satisfy the largest needs
                if (s[j] >= g[i]) {   
                    contentCnt ++;
                    used[j] = true; 
                    break; 
                }
            }
        }
        return contentCnt;
    }
}