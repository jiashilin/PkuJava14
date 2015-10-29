public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> array = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.empty()) {
			while(p!=null){
				stack.add(p);
				p=p.left;
			}
			p=stack.pop();
			array.add(p.val);
			p=p.right;
		}
		return array;
    }
}