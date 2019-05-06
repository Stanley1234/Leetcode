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
    
    private void getLeafSequence(TreeNode root, List<Integer> leafSeq) {
      if (root == null) {
         return;
      }
      if (root.left == null && root.right == null) {
         leafSeq.add(root.val);
         return;
      }
      getLeafSequence(root.left, leafSeq);
      getLeafSequence(root.right, leafSeq);
   }

   public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> seq1 = new ArrayList<>();
      List<Integer> seq2 = new ArrayList<>();
      
      getLeafSequence(root1, seq1);
      getLeafSequence(root2, seq2);
      
      if (seq1.size() != seq2.size()) {
         return false;
      }
      
      for (int i = 0;i < seq1.size();i ++) {
         if (seq1.get(i) != seq2.get(i)) {
            return false;
         }
      }
      return true;
   }
}