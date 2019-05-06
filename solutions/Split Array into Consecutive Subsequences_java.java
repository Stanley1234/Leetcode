class Solution {
    private class Counter extends HashMap<Integer, Integer> {
        public void add(int key, int val) {    
            put(key, get(key) + val);
        }

        public int get(int key) {
            return containsKey(key) ? super.get(key) : 0;
        }
    }

    public boolean isPossible(int[] nums) {
        Counter counter = new Counter();
        Counter tail = new Counter();
        for (int n : nums) {
            counter.add(n, 1);
        }
        
        for (int n : nums) {
            if (counter.get(n) == 0) {
                continue;
            } else if (tail.get(n) > 0) {
                tail.add(n, -1);
                tail.add(n + 1, 1);
                counter.add(n, -1);
            } else if (counter.get(n + 1) > 0 && counter.get(n + 2) > 0) {
                counter.add(n, -1);
                counter.add(n + 1, -1);
                counter.add(n + 2, -1);
                tail.add(n + 3, 1);
            } else {
                return false;
            }
        }
        return true;
    }
}