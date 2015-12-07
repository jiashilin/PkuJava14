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
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
        if(root==null){
            return root;
        }
        if(root.left!=null&&root.right!=null){
            temp=root.left;
            root.left=root.right;
            root.right=temp;
        }else if(root.left!=null&&root.right==null){
            root.right=root.left;
            root.left=null;
        }else if(root.left==null&&root.right!=null){
            root.left=root.right;
            root.right=null;
        }else{
            return root;
        }
         invertTree(root.left);
         invertTree(root.right); 
         return root;
    }
}