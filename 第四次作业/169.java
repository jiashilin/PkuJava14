public class Solution {
    public int majorityElement(int[] nums) {
     	int n = nums.length;
		int count = 0, x = nums[0];
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			if (nums[i] == x) {
				count++;
				if (count > n / 2) {
					return nums[i];
				}
			} else {
				count = 1;
				x = nums[i];
			}
		}
		return 0;   
    }
}