public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> list2 = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		if (nums == null || nums.length < 4) {
			return list;
		}
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (i != 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int l = j + 1;
				int k = nums.length - 1;
				int sum = target;
				while (l < k) {
					sum = nums[i] + nums[j] + nums[l] + nums[k];
					if (sum == target) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[l]);
						tmp.add(nums[k]);
						if (!list2.contains(tmp)) {
							list2.add(tmp);
							list.add(tmp);
						}
						l++;
						k--;
						while (l < k && nums[l] == nums[l - 1]) {
							l++;
						}
						while (l < k && nums[k] == nums[k + 1]) {
							k--;
						}
					} else if (sum < target) {
						l++;
					} else {
						k--;
					}
				}
			}
		}
		return list;
	}
}