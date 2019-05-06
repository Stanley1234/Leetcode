class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> ratingsOnList1 = new HashMap<>();
        for (int i = 0;i < list1.length;i ++) {
            ratingsOnList1.put(list1[i], i + 1);
        }
        
        List<String> commonInterest = new ArrayList<>();
        int bestRating = Integer.MAX_VALUE;  
        for (int i = 0;i < list2.length;i ++) {
            if (!ratingsOnList1.containsKey(list2[i])) {
                continue;
            }
            int curRating = ratingsOnList1.get(list2[i]) + i;
            if (curRating == bestRating) {
                commonInterest.add(list2[i]);
            } else if (curRating < bestRating) {
                bestRating = curRating;
                commonInterest.clear();
                commonInterest.add(list2[i]);
            }
        }
        String[] res = new String[commonInterest.size()];
        for (int i = 0;i < commonInterest.size();i ++) {
            res[i] = commonInterest.get(i);
        }
        return res;
    }
}