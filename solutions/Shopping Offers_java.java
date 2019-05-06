class Solution {
    // DFS + Memorization
    private Map<List<Integer>, Integer> visited = new HashMap<>();
    
    private int buyNonSpecial(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0;i < needs.size();i ++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    } 
    
    /*
        This helper is a little confusing at first sight.
        The dp function is 
            cost[n1, n2, n3, ...] = min{ buyNonSpecial(n1, n2, ...), 
                                    min { special_cost[i] + cost[n1 - special_offer[n1], n2 - special_offer[n2],                                         ...]} }
        
    
    */
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (visited.containsKey(needs)) { return visited.get(needs); }
        
        int minCost = buyNonSpecial(price, needs);
        // buy special
        for (int i = index;i < special.size();i ++) {
            List<Integer> remainingNeeds = new ArrayList<>(needs);
            List<Integer> specialOfferDetails = special.get(i);
            int specialOfferCost = specialOfferDetails.get(specialOfferDetails.size() - 1);

            // if selecting the current plan
            boolean doable = true;
            for (int j = 0;j < specialOfferDetails.size() - 1;j ++) {
                if (needs.get(j) < specialOfferDetails.get(j)) {
                    doable = false;
                    break;
                }
                remainingNeeds.set(j, needs.get(j) - specialOfferDetails.get(j));
            }
            if (!doable) { continue; }
            minCost = Math.min(minCost, specialOfferCost + helper(price, special, remainingNeeds, i));
        }
        visited.put(needs, minCost);
        return minCost;
    }
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }
}