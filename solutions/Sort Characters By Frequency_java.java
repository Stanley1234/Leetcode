class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> characterCounter = new HashMap<>();
        for (char ch : s.toCharArray()) {
            characterCounter.put(ch, characterCounter.getOrDefault(ch, 0) + 1);
        }
        
        Map<Integer, List<Character>> inversedCounter = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : characterCounter.entrySet()) {
            if (inversedCounter.containsKey(entry.getValue())) {
                inversedCounter.get(entry.getValue()).add(entry.getKey());
            } else {
                inversedCounter.put(entry.getValue(), new ArrayList<>());
                inversedCounter.get(entry.getValue()).add(entry.getKey());
            }
        }
        
        StringBuilder sortedStrBuilder = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : inversedCounter.entrySet()) {
            for (char ch : entry.getValue()) {
                int times = entry.getKey();
                while (times -- > 0) {
                    sortedStrBuilder.append(ch);
                }
            }
        }
        return sortedStrBuilder.reverse().toString();
    }
}