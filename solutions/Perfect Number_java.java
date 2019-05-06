class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) { 
            return false; 
        }
        
        long sum = 0;
        int div = 1;
        while (div * div <= num) {
            if (num % div == 0) {
                sum += (long)div;
                if (div != 1) {
                    sum += (long)(num / div);
                }
            }
            div ++;
        }
        return sum == num;
    }
}