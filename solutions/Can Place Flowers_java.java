class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return (flowerbed[0] == 1 && n == 0) || (flowerbed[0] == 0 && n <= 1);
        }
        
        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 0) {
                if ((i == 0 && flowerbed[i + 1] == 0)
                   || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0)
                   || (0 < i && i < flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n --;
                } 
            }
            i ++;
        }
        
        return n == 0;
    }
}