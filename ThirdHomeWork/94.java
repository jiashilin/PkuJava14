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
    public List<Integer> inorderTraversal(TreeNode root) {
	//ÖÐÐò±éÀú
        List<Integer> relist=new ArrayList<Integer>();
       
        TreeNode t=root;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.empty()||t!=null){
            if(t!=null){
                stack.push(t);
                t=t.left;
            }else{
                TreeNode q=stack.pop();
                relist.add(q.val);
                t=q.right;
            }
        }
        return relist;
    }
}