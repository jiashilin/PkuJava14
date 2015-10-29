public class Solution {
    public int minDepth(TreeNode root) {
 		if (root == null) {
			return 0;
		}
		int mindepth = 1, size = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.remove();
				if (node.left == null && node.right == null) {
					return mindepth;
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			mindepth++;
		}
		return 0;
    }
}