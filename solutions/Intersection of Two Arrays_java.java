class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        Set<Integer> intersection = new HashSet<>();
        int p1 = 0, p2 = 0;
        
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                intersection.add(nums1[p1]);
                p1 ++;
                p2 ++;
            } else if (nums1[p1] < nums2[p2]) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        
        int[] ans = new int[intersection.size()];
        int cnt = 0;
        for (int elem : intersection) {
            ans[cnt ++] = elem;
        }
        return ans;
       
    }
}