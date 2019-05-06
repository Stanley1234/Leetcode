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

    public TreeNode invertTree(TreeNode template) {
        if (template == null) {
            return null;
        }
        
        TreeNode newNode = new TreeNode(template.val);
        newNode.left = invertTree(template.right);
        newNode.right = invertTree(template.left);
        return newNode;
    }
}