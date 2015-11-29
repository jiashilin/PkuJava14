public class Solution {
   public int titleToNumber(String s) {
		int n = 0;
		char[] a = s.toCharArray();
		for(int i = 0;i<s.length();i++){
			n = 26*n+a[i]-'A'+1;
		}
    	return n;
    }
}