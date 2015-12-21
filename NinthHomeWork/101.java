/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return Symmetric(root.left,root.right);
    }
    
      public boolean Symmetric(TreeNode le,TreeNode ri){
          if(le==null&&ri==null){
              return true;
          }else if(le!=null&&ri!=null&&le.val==ri.val){
              return Symmetric(le.left,ri.right)&&Symmetric(le.right,ri.left);
          }else{
              return false;
          }
      }
}