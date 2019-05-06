class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int[] ans = new int[nums1.length];
        
        for (int i = 0;i < nums2.length;i ++) {
            indices.put(nums2[i], i);
        }
        
        for (int i = 0;i < nums1.length;i ++) {
            int pos = -1;
            for (int j = indices.get(nums1[i]);j < nums2.length;j ++) {
                if (nums2[j] > nums1[i]) {
                    pos = j;
                    break;
                }
            }
            if (pos == -1) {
                ans[i] = -1;
            } else {
               ans[i] = nums2[pos];
            }
        }
        return ans;
    }
}