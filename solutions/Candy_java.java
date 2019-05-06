class Solution {
    public int candy(int[] ratings) {
        // 1. iterate from left to right to construct a sequence that satisfies "get more candies than left             neightbour if rating is higher than that of left neighbor"
        // 2. iterate from right to left to adjust the sequence to satisfy "get more candies than right neighbour             if rating is higher than that of right neighbor"
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);  // each person must have at least one candy
        
        for (int i = 1;i < ratings.length;i ++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 2;i >= 0;i --) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }
}