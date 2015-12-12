public class Solution {
	public int countPrimes(int n) {
		int i = 0;
		boolean[] a = new boolean[n + 2];
		a[0] = true;
		a[1] = true;
		for (int j = 2; j * j < n; j++) {
			if (!a[j]) {
				int tmp = j * j;
				while (tmp < n) {
					a[tmp] = true;
					tmp += j;
				}
			}
		}
		for (int j = 0; j < n; j++) {
			if (!a[j]) {
				++i;
			}
		}
		return i;
	}
}