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
    
    private int search(TreeNode cur) {
        // invariant: cur is not null
        if (cur.left == null && cur.right == null) {
            return 1;
        } else if (cur.left != null && cur.right == null) {
            return search(cur.left) + 1;
        } else if (cur.left == null && cur.right != null) {
            return search(cur.right) + 1;
        } else {
            return Math.min(search(cur.left), search(cur.right)) + 1;
        }
    }
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return search(root);
    }
}