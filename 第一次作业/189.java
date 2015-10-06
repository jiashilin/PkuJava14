public class Solution {
    public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int i = 0, j = 0;
		int[] nums1 = new int[n];
		for (i = 0; i < k; i++) {
			nums1[i] = nums[n - k + i];
		}
		for (i = k; i < n; i++) {
			nums1[i] = nums[j];
			j++;
		}
		for (i = 0; i < n; i++) {
			nums[i] = nums1[i];
		}
    }
}