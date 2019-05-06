class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> remainMapping = new HashMap<>();
      int[] ans = new int[2];
      
      for (int i = 0;i < nums.length;i ++) {
         
         if (remainMapping.containsKey(nums[i])) {
            ans[0] = remainMapping.get(nums[i]);
            ans[1] = i;
            break;
         }
         remainMapping.put(target - nums[i], i);
      }
      return ans;
   }
}