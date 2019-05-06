class Solution {
    private int factorial(int t) {
        int res = 1;
        for(int i = 2;i <= t;i ++ )
            res = res * i;
        return res;
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> unused = new LinkedList<>();

        for(int i = 1;i <= n;i ++)
            unused.add(i);
        while(k > 1) {
            int cnt = 0;
            while(cnt * (factorial(unused.size() - 1)) + 1 <= k) {
                cnt ++;
            }
            cnt --;
            k -= cnt * (factorial(unused.size() - 1));
            sb.append(unused.get(cnt));
            unused.remove(cnt);
        }

        for(Integer elem : unused) {
            sb.append(elem);
        }

        return sb.toString();
    }
}