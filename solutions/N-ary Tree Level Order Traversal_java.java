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
  
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLevelNum = queue.size();
            
            List<Integer> curLevel = new ArrayList<>();
            while (curLevelNum -- > 0) {
                Node cur = queue.poll();
                curLevel.add(cur.val);
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(curLevel);
        }
        return ans;
    }
    
    
}