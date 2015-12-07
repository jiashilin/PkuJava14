public class Solution {
    public void moveZeroes(int[] nums) {
        int last = 1;
		for (int i = 0; last < nums.length;) {
			if (nums[i] == 0 && nums[last] == 0) {
				last++;
			} else if (nums[i] == 0 && nums[last] != 0) {
				nums[i] = nums[last];
				nums[last] = 0;
			} else {
				i++;
				last++;
			}
		}
    }
}