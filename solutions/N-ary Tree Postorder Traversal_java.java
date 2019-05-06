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
    
    private void search(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            search(child, ans);
        }
        ans.add(root.val);
    }
    
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        search(root, ans);
        return ans;
    }
}