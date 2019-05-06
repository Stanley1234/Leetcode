class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> imNum = new LinkedList<>();
        for (int i = digits.length - 1;i >= 0;i --) {
            
            int val;
            if (i == digits.length - 1) {
                val = digits[i] + 1;
                imNum.add(0, val % 10);
            } else {
                val = imNum.get(0) + digits[i];
                imNum.set(0, val % 10);
            }
            
            if (val >= 10) {
                imNum.add(0, 1);
            } else {
                imNum.add(0, 0);
            }
        }
        if (imNum.get(0) == 0) {
            imNum.remove(0);
        }
        int[] ans = new int[imNum.size()];
        int cnt = 0;
        for (int d : imNum) {
            ans[cnt ++] = d;
        }
        return ans;
    }
}