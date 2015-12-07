public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode tmp = root;
		while (tmp != null) {
			if ((p.val - tmp.val) * (q.val - tmp.val) <= 0) {
				return tmp;
			} else if (p.val < tmp.val) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}
		return null;
	}
}