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
    
    private void goToLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> switched = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        
        goToLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (switched.contains(cur)) {
                ans.add(cur.val);
                switched.remove(cur);
                stack.pop();
            } else if (cur.right != null) {
                switched.add(cur);
                
                cur = cur.right;
                goToLeft(cur, stack);
            } else {
                ans.add(cur.val);
                stack.pop();
            }
        }
        return ans;
    }
}