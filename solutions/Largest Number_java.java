class Solution {
    private boolean isZero(String res) {
        for(int i = 0;i < res.length();i ++)
            if(res.charAt(i) != '0')
                return false;
    
        return true;
    }
    
    public String largestNumber(int[] nums) {
        String[] cache = new String[nums.length];
        for(int i = 0;i < nums.length;i ++) 
            cache[i] = Integer.toString(nums[i]);
        Arrays.sort(cache, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                /*int cnt = 0;
                while(cnt < o1.length() && cnt < o2.length()) {
                    if(o1.charAt(cnt) > o2.charAt(cnt))
                        return 1;
                    else if(o1.charAt(cnt) < o2.charAt(cnt))
                        return -1;
                    cnt ++;
                }
                
                if(o1.length() == o2.length())
                    return 0;
                if(cnt < o2.length())  // o2 is longer
                    return o1.charAt(cnt - 1) > o2.charAt(cnt) ? 1 : -1;
                else  // o1 is longer
                    return o1.charAt(cnt) > o2.charAt(cnt - 1) ? 1 : -1;*/
                return (o1 + o2).compareTo(o2 + o1);
                
            }
        });
        
        String res = "";
        for(int i = cache.length - 1;i >= 0;i --) 
            res += cache[i];
        
        if(isZero(res))
            return "0";

        return res;
    }
}