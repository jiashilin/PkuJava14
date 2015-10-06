public class Solution {
    public boolean isHappy(int n) {
		HashSet<Integer>hash=new HashSet<Integer>();
		int num = 0, m = 0;
		while (!hash.contains(n)) {
			num = 0;
			hash.add(n);
			while (n != 0) {
				m = n % 10;
				n = n / 10;
				num = num + m * m;
			}
			n = num;
		}
		if (num == 1) {
			return true;
		} else {
			return false;
		}
    }
}