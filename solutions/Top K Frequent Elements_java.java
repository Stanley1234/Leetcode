class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyCounter = new HashMap<>();
        for (int n : nums) {
            frequencyCounter.put(n, frequencyCounter.getOrDefault(n, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> inversedCounter = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyCounter.entrySet()) {
            if (inversedCounter.containsKey(entry.getValue())) {
                inversedCounter.get(entry.getValue()).add(entry.getKey());
            } else {
                inversedCounter.put(entry.getValue(), new ArrayList<>());
                inversedCounter.get(entry.getValue()).add(entry.getKey());
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int eachKey : inversedCounter.descendingKeySet()) {
            List<Integer> elems = inversedCounter.get(eachKey);
            
            for (int elem : elems) {
                result.add(elem);
                if (result.size() == k) {
                    break;
                }
            }
            
            if (result.size() == k) {
                break;
            }
        }
        return result;
    }
}