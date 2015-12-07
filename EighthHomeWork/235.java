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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val&&q.val<root.val){
            root=root.left;
            return lowestCommonAncestor(root,p,q);
        }else if(p.val>root.val&&q.val>root.val){
            root=root.right;
            return lowestCommonAncestor(root,p,q);
        }else{
            return root;
        }
        
    }
}