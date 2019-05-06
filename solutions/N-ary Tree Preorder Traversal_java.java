/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {

    private void helper(Node cur, List<Integer> ans) {
        if (cur == null) {
            return;
        }
        ans.add(cur.val);
        for (Node child : cur.children) {
            helper(child, ans);
        }
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
}