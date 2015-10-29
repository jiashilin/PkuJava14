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
    
    //�ú������������飬�����ӽڵ㣬Ȼ�����ӽڵ㣬�����ڵ�
    //�����õݹ���õ�˼�룬��������һֱ����
    
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