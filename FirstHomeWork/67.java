public class Solution {
    public String addBinary(String a, String b) {
      
		if(a.length()>b.length()){
			String temp=a;
			a=b;
			b=temp;
		}
		int la=a.length()-1;
		int lb=b.length()-1;
		String str="";
		int s=0;
		while(la>=0){
			int sum=(int)(a.charAt(la)-'0')+(int)(b.charAt(lb)-'0')+s;
			str=String.valueOf(sum%2)+str;
			s=sum/2;
			la--;
			lb--;
		}
		while(lb>=0){
			int sum=(int)(b.charAt(lb)-'0')+s;
			str=String.valueOf(sum%2)+str;
			s=sum/2;
			lb--;
		}
		if(s==1){
			str="1"+str;
		}
		return str;
	        
    }
}