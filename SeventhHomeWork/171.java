public class Solution {
    public int titleToNumber(String s) {
        int len=s.length();
		int re=0;
		for(int i=0;i<len;i++){
			re=re+(int)Math.pow(26, len-1-i)*(s.charAt(i)-'A'+1);
		}
		return re;
    }
}