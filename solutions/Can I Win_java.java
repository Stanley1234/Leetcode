class Solution {
    
    private boolean[] used;
    
    private Map<Integer, Boolean> canWin = new HashMap<>();
  
    private int transformToInt() {
        int sum = 0;
        for (int i = 0;i < used.length;i ++) {
            if (used[i])
              sum |= (1 << i);
        }
        return sum;
    }
    
    private boolean brutal(int maxChoosable, int total, int curSum, boolean round) {
        if (curSum >= total) { return !round; }
        
        if (round) {
            for (int i = 1;i <= maxChoosable;i ++) {
                if (used[i]) { continue; }
                used[i] = true;
              
                boolean win;
                if (canWin.containsKey(transformToInt())) { 
                    win = canWin.get(transformToInt()); 
                } else {
                    win = brutal(maxChoosable, total, curSum + i, !round);
                    canWin.put(transformToInt(), win);
                }
              
                used[i] = false;
                if (win) { return true; }
            }
            return false;
        } else {
            for (int i = 1;i <= maxChoosable;i ++) {
                if (used[i]) { continue; }
                used[i] = true;
              
                boolean win;
                if (canWin.containsKey(transformToInt())) {
                    win = canWin.get(transformToInt());
                } else {
                    win = brutal(maxChoosable, total, curSum + i, !round);
                    canWin.put(transformToInt(), win);
                }
                used[i] = false;
                if (!win) { return false; }
            }
            return true;
        }
    }
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) { return true; }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) { return false; }
        
        used = new boolean[maxChoosableInteger + 1];
        return brutal(maxChoosableInteger, desiredTotal, 0, true);
    }
}