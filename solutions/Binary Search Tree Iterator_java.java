/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode cur = root;
        stack.push(cur);
        while (cur.left != null) {
            cur = cur.left;
            stack.push(cur);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right == null) {
            return cur.val;
        }
        
        TreeNode ret = cur;
        cur = cur.right;
        stack.push(cur);
        
        while (cur.left != null) {
            cur = cur.left;
            stack.push(cur);
        }
        return ret.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */