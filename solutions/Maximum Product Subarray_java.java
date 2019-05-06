class Solution {
    public int maxProduct(int[] nums) {
        
        // key: every integer is greather than one or smaller than -1
        int maxProd = nums[0], minProd = nums[0];
        int globalMax = maxProd;
        
        for(int i = 1;i < nums.length;i ++) {
            
            if(nums[i] < 0) {
                int tmp = maxProd;
                maxProd = minProd;
                minProd = tmp;
            }
            
            maxProd = Math.max(maxProd * nums[i], nums[i]);
            minProd = Math.min(minProd * nums[i], nums[i]);
            globalMax = Math.max(globalMax, maxProd);
        }
        return globalMax;
    }
}