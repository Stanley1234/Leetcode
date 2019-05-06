class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        for (int i = 0;i < nums.length;i ++) {
            copy[i] = nums[i];
        }
        
        Arrays.sort(copy);
        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] == copy[left]) { left ++; }
        while (right >= 0 && nums[right] == copy[right]) { right --; }
        if (left > right) { return 0; }
        else { return right - left + 1; }
    }
}