/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<String> ans = new ArrayList<>();
    
    private String transform(Stack<Integer> curAns) {
        Iterator<Integer> iter = curAns.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
    
    private void dfs(TreeNode cur, Stack<Integer> curAns) {
        if (cur == null) {
            return;
        }
        curAns.push(cur.val);
        if (cur.left == null && cur.right == null) {
            ans.add(transform(curAns));
        } else {
            dfs(cur.left, curAns);
            dfs(cur.right, curAns);
        }
        curAns.pop();
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        Stack<Integer> curAns = new Stack<>();
        dfs(root, curAns);
        return ans;
    }
}