class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> candiesCount = new HashMap<>();
        
        // init
        for (int candy : candies) {
            if (candiesCount.containsKey(candy)) {
                candiesCount.put(candy, candiesCount.get(candy) + 1);
            } else {
                candiesCount.put(candy, 1);
            }
        }
        
        int neededForSister = candies.length / 2;
        if (neededForSister <= candiesCount.size()) {
            return neededForSister;
        } else {
            return candiesCount.size();
        }
    }
}