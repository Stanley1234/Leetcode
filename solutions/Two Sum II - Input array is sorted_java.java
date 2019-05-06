class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] ans = new int[2];
        while (true) {
            if (numbers[left] + numbers[right] == target)  {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] < target){
                left ++;
            } else {
                right --;
            }
        }
        return ans;
    }
}