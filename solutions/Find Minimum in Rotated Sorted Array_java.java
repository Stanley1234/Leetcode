class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(mid > 0 && nums[mid - 1] > nums[mid]) {
                break;
            } 
            if(nums[low] <= nums[high]) {
                return nums[low];
            } else  {
                if(nums[mid] >= nums[low])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return nums[mid];
    }
}