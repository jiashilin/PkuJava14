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
    //�������ȸ��������һ������������˼�����ȱ�������Ȼ����ڵ㣬Ȼ���ҽڵ�
	//���Խ���ջ��˼�룬��Ϊջ�Ǻ���ȳ������Խ��ǿսڵ�ѹ��ջ�У�Ȼ�������ڵ�
	//����ڵ��ʱ�����������ջ�ڵ�����ӽڵ�
    
	//���ȶ������洢���������
	ArrayList<Integer> a = new ArrayList<Integer>();
	
	//������������������������Ϊ��
	if(root == null) return a;
	
	//����������һ��ջ
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