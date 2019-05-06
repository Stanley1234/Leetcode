class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int p = m - 1, q = n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[tail] = nums1[p];
                p --;
            } else {
                nums1[tail] = nums2[q];
                q --;
            }
            tail --;
        }
        while (p >= 0) {
            nums1[tail --] = nums1[p --];
        }
        while (q >= 0){
            nums1[tail --] = nums2[q --];
        }
    }
}