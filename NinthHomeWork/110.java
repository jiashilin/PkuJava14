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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }else{
            int lh=height(root.left);
            int rh=height(root.right);
            if(lh>rh+1||rh>lh+1){
                return false;
            }else{
                return isBalanced(root.left)&&isBalanced(root.right);
            }
        }
        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int lh=height(root.left);
            int rh=height(root.right);
            if(lh>rh){
                return lh+1;
            }else{
                return rh+1;
            }
        }
    }
}