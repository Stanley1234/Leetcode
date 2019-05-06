class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1;i <= n;i ++) {
            sb.delete(0, sb.length());
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0){
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}