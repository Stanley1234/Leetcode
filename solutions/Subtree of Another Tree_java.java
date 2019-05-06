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
    
    private boolean check(TreeNode s, TreeNode t) {
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if (s == null && t == null) {
            return true;
        }
        if (s.val == t.val) {
            return check(s.left, t.left) && check(s.right, t.right);
        }
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        boolean subTree = false;
        if (s.val == t.val) {
            subTree = check(s, t);
        }
        if (!subTree) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return true;
    }
}