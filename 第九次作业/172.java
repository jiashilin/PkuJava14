public class Solution {
	public int trailingZeroes(int n) {
		int i = 0;
		while (n > 0) {
			i += n / 5;
			n /= 5;
		}
		return i;
	}
}