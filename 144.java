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
    public List<Integer> preorderTraversal(TreeNode root) {
    //题意是先根次序遍历一个二叉树，意思就是先遍历根，然后左节点，然后右节点
	//所以借用栈的思想，因为栈是后进先出，所以将非空节点压入栈中，然后遍历左节点
	//当左节点空时，遍历最后入栈节点的右子节点
    
	//首先定义最后存储结果的数组
	ArrayList<Integer> a = new ArrayList<Integer>();
	
	//考虑最特殊的情况，当二叉树为空
	if(root == null) return a;
	
	//接下来定义一个栈
	Stack<TreeNode> temp = new Stack<TreeNode>();
	
	TreeNode p = root;
	
	//while(p != null){
	while(p != null || !temp.empty()){    
	    while(p != null){
	        
	        a.add(p.val);
	        temp.push(p);
	        p = p.left;
	        
	    }
	    
	    if(!temp.empty()){
	        
	        p = temp.pop();
	        p = p.right;
	        
	    }
	}
	return a;
	}
}