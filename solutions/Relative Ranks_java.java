class Solution {
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void quickSort(int[] arr, int left, int right, HashMap<Integer, Integer> indices) {
        if (left > right) { return; }
        int pivot = arr[left];
        int i = right, j = right;
        while (i > left) {
            if (arr[i] < pivot) {
                if (i != j) {
                    swap(arr, i, j);
                }
                j --;
            }
            i --;
        }
        swap(arr, left, j);
        indices.put(pivot, j);
        quickSort(arr, left, j - 1, indices);
        quickSort(arr, j + 1, right, indices);
    }

    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        HashMap<Integer, Integer> indices = new HashMap<>();
        quickSort(nums, 0, nums.length - 1, indices);

        String[] ans = new String[copy.length];
        for (int i = 0;i < copy.length;i ++) {
            int pos = indices.get(copy[i]);
            if (pos == 0) {
                ans[i] = "Gold Medal";
            } else if (pos == 1) {
                ans[i] = "Silver Medal";
            } else if (pos == 2) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = (pos + 1) + "";
            }
        }
        return ans;
    }
}