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
    
    private enum Direction {
        LEFT, RIGHT
    }
    
    private int findLeftLeaveSum(TreeNode node, Direction dir) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return dir == Direction.LEFT ? node.val : 0;
        }
        return findLeftLeaveSum(node.left, Direction.LEFT) + 
               findLeftLeaveSum(node.right, Direction.RIGHT);
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findLeftLeaveSum(root.left, Direction.LEFT) + 
               findLeftLeaveSum(root.right, Direction.RIGHT);
    }
}