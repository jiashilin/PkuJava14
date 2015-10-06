public class Solution {
    public String addBinary(String a, String b) {
 		StringBuffer result = new StringBuffer("");
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		int a1;
		int b1;
		for (a1 = 0, b1 = 0; i >= 0 || j >= 0; i--, j--) {
			if(i >= 0){
			    a1 = a.charAt(i) - '0';
			}else{
			    a1 = 0;
			}
			if(j >= 0){
			    b1 = b.charAt(j) - '0';
			}else{
			    b1 = 0;
			}
			int c = (a1 + b1 + carry) % 2;
			carry = (a1 + b1 + carry) / 2;
			result = result.insert(0, c);
		}
		if (carry == 1) {
			result.insert(0, '1');
		}
		return result.toString();
    }
}