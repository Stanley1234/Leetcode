class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int totalTrap = 0;
        
        // find the leftmost edge and rightmost that can hold water
        while (left + 1 <= right && height[left] <= height[left + 1]) {
            left ++;
        }
        
        while (right - 1 >= left && height[right] <= height[right - 1]) {
            right --;
        }
        
        while (left <= right) {
            if (height[left] < height[right]) {
                
                int lcap = height[left];
                
                left ++;
                while (left < right && height[left] <= lcap) {
                    totalTrap += (lcap - height[left]);
                    left ++;
                }
                
            } else {
                
                int rcap = height[right];
                
                right --;
                while (left < right && height[right] <= rcap) {
                    totalTrap += (rcap - height[right]);
                    right --;
                }
            }
        }
        return totalTrap;
    }
}