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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    
    //用后根次序遍历数组，先左子节点，然后右子节点，最后根节点
    //可以用递归调用的思想，先做后右一直调用
    
    ArrayList<Integer> a = new ArrayList<Integer>();
    
    if(root == null) return a;
    
    ArrayList<Integer> left = postorderTraversal(root.left);
    ArrayList<Integer> right = postorderTraversal(root.right);
    
    if(left != null){
        //a.addall(left);
        a.addAll(left);
    }
    
    if(right != null){
        //a.addall(right);
        //a.addAll(left);
        a.addAll(right);
    }
    
    a.add(root.val);
    
    return a;
    
    }
}