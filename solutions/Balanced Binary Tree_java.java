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
    
    
    
    private int checkBalance(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int leftHeight = checkBalance(cur.left);
        int rightHeight = checkBalance(cur.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        
        if (Math.abs(leftHeight - rightHeight) >= 2) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
}