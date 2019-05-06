class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int ans = 0;
        for (int house : houses) {
            int curMin = Integer.MAX_VALUE;
            for (int heater : heaters) {
                curMin = Math.min(curMin, Math.abs(heater - house));
            }
            ans = Math.max(ans, curMin);
        }
        
        return ans;
        // beginning section
        // 1 x x x 5 6 x x x x
        //   y           y
        
    }
}