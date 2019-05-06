class Solution {
    
    // idle table method
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A'] ++;
        }
        Arrays.sort(count);

        int height = count[25] - 1, width = n + 1;
        int idleTime = height * width;
        int i = 25;
        while (i >= 0 && count[i] > 0) {
            idleTime -= Math.min(count[i], height);
            i --;
        }
        return idleTime > 0 ? idleTime + tasks.length : tasks.length;
    }
}